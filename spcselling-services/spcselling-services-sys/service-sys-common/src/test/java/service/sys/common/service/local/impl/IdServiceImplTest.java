package service.sys.common.service.local.impl;

import com.ymu.spcselling.infrastructure.idgenerator.ID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.sys.common.service.local.IdService;
import service.sys.common.vo.resp.VSnowflakeIdResp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.IsEqual.equalTo;

public class IdServiceImplTest {

    private static final Logger log = LogManager.getLogger(IdServiceImplTest.class);

    private long id;
    private Set<Long> set;
    private IdService idService;

    @Before
    public void setUp() throws Exception {
        set = new HashSet<>();
        id = 352608540609069079L;
        idService = new IdServiceImpl();
    }

    @After
    public void tearDown() throws Exception {
        set = null;
        id = 0L;
        idService = null;
    }

//    @Test
    public void expId() throws Exception {
        VSnowflakeIdResp actual = idService.expId(id);
        Assert.assertThat(actual.getSequence(), equalTo(23L));
        Assert.assertThat(actual.getWorkerId(), equalTo(92L));
        Assert.assertThat(actual.getTimeStamp(), equalTo(84068427231L));
    }

//    @Test
    public void genId() throws Exception {
        List<IdService> idServices = new ArrayList<>();
        for (int j = 0; j < 1024; j++) {
            IdService idService = new IdServiceImpl();
            idServices.add(idService);
        }

        for (IdService idService : idServices) {
            IdWorkThread idWorkThread = new IdWorkThread(set, idService);
            Thread t = new Thread(idWorkThread);
            t.setDaemon(true);
            t.start();
        }

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    @Test
    public void stressTest() throws Exception {
        loop(2000000000);
        //loop(2000000000);
        //loop(2000000000);
        //loop(2000000000);
    }

    private void loop(int idNum) throws Exception {
        long start = System.currentTimeMillis();
        for (int i = 0; i < idNum; i++) {
            long id = idService.genId(0,0);
            log.info("{}", id);
        }
        long duration = System.currentTimeMillis() - start;
        log.info("total time:{}ms,speed is:{}/ms", duration, idNum / duration);
    }

    static class IdWorkThread implements Runnable {
        private Set<Long> set;
        private IdService idService;

        public IdWorkThread(Set<Long> set, IdService idService) {
            this.set = set;
            this.idService = idService;
        }

        @Override
        public void run() {
            while (true) {
                long id = idService.genId(0,0);
                log.info("{}", id);
                if (!set.add(id)) {
                    log.info("duplicate:{}", id);
                }
            }
        }
    }
}