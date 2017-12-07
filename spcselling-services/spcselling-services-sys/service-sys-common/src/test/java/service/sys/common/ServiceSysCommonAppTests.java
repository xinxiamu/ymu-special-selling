package service.sys.common;

import com.ymu.spcselling.infrastructure.cache.redis.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import service.sys.common.vo.resp.VSnowflakeIdResp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceSysCommonAppTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void contextLoads() {
    }

    @Test
    public void strTest() {
        // 保存字符串
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("abc", "111");
        System.out.println("================" + stringRedisTemplate.opsForValue().get("abc"));

        //过期
        ops.set("aa", "aaaaa", 10, TimeUnit.MINUTES);

        RedisUtils.setStr("cba","cba",stringRedisTemplate);

        String rsult = RedisUtils.getStr("cba",stringRedisTemplate);
        System.out.println("==========cba:" + rsult);
    }

    @Test
    public void objectTest() {
        VSnowflakeIdResp vo = new VSnowflakeIdResp();
        vo.setDataCenterId(0);
        vo.setSequence(11111111111L);
        vo.setTimeStamp(24324234234L);
        vo.setWorkerId(4);

        ValueOperations<String, VSnowflakeIdResp> ops = redisTemplate.opsForValue();
        ops.set("cache:snowflakeId", vo);

        VSnowflakeIdResp resp = ops.get("cache:snowflakeId");
        System.out.println("==========" + resp.getSequence());
    }

    @Test
    public void hashTest() {
        Map<String, String> m1 = new HashMap<>();
        m1.put("a", "aaaaa");
        m1.put("b", "bbbb");

        HashOperations ops = redisTemplate.opsForHash();
		ops.putAll("c:m1",m1);
		System.out.println("=====m1.a" + ops.get("c:m1","a"));
        List a = ops.multiGet("c:m1", m1.keySet());
        System.out.println("====a:" + a);

		ops.put("c:m2","a","1111111111111");
		ops.put("c:m2","b",2222);
    }

}
