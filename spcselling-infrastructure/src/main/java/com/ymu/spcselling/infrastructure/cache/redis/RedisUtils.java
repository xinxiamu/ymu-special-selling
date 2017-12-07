package com.ymu.spcselling.infrastructure.cache.redis;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.validation.constraints.NotNull;
import java.util.concurrent.TimeUnit;

public final class RedisUtils {

	private RedisUtils() {
	}

	/**
	 *  保存字符。永久。
	 * @param k
	 * @param v
	 * @param redisTemplate
	 */
	public static final void setStr(String k, String v, StringRedisTemplate redisTemplate) {
		if (redisTemplate == null || k == null || v == null) {
			throw new NullPointerException("参数有null值");
		}

		redisTemplate.opsForValue().set(k,v);
	}

	/**
	 * 保存字符串。设置过期时间
	 * @param k
	 * @param v
	 * @param timeout
	 * @param timeUnit
	 * @param redisTemplate
	 */
	public static final void setStr(String k, String v, long timeout, TimeUnit timeUnit, StringRedisTemplate redisTemplate) {
		if (redisTemplate == null || !(redisTemplate instanceof StringRedisTemplate)) {
			throw new IllegalArgumentException("redisTemplate非法");
		}

		redisTemplate.opsForValue().set(k,v,timeout,timeUnit);
	}

	/**
	 * 获取字符串内容。
	 * @param key
	 * @param redisTemplate
	 * @return
	 */
	public static final String getStr(String key,StringRedisTemplate redisTemplate) {
		String result = redisTemplate.opsForValue().get(key);
		return result;
	}

}
