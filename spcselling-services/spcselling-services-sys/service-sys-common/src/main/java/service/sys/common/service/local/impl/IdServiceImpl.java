package service.sys.common.service.local.impl;

import com.ymu.spcselling.infrastructure.idgenerator.ID;
import com.ymu.spcselling.infrastructure.idgenerator.SnowflakeIdWorker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import service.sys.common.service.local.IdService;

import java.util.Date;

@Service
public class IdServiceImpl implements IdService {

    private static final Logger LOGGER = LogManager.getLogger(IdServiceImpl.class);


    @Override
    public long genId(long dataCenterId, long workerId) {
        SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(workerId,dataCenterId);
        return snowflakeIdWorker.nextId();
    }

    @Override
    public ID expId(long id) {
        return SnowflakeIdWorker.convert(id);
    }
}