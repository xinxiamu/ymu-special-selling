package service.sys.common.service.local.impl;

import com.ymu.spcselling.infrastructure.idgenerator.ID;
import com.ymu.spcselling.infrastructure.idgenerator.SnowflakeIdWorker;
import com.ymu.spcselling.infrastructure.utils.BeanUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import service.sys.common.service.local.IdService;
import service.sys.common.vo.resp.VSnowflakeIdResp;

@Service
public class IdServiceImpl implements IdService {

    private static final Logger LOGGER = LogManager.getLogger(IdServiceImpl.class);

    @Override
    public long genId(long dataCenterId, long workerId) {
        SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(workerId,dataCenterId);
        return snowflakeIdWorker.nextId();
    }

    @Override
    public VSnowflakeIdResp expId(long id) {
        ID snowflakeId = SnowflakeIdWorker.convert(id);
        VSnowflakeIdResp v = new VSnowflakeIdResp();
        BeanUtil.from(snowflakeId).to(v);
//        ValueOperations ops = stringRedisTemplate.opsForValue();
////        ops.set("username","abcd");
//        LOGGER.debug("==============username:" + ops.get("username"));
        return v;
    }
}