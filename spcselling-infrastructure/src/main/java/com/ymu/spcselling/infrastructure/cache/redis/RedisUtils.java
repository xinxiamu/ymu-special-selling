package com.ymu.spcselling.infrastructure.cache.redis;

import org.springframework.data.redis.core.StringRedisTemplate;

public final class RedisUtils {

	private RedisUtils() {
	}

	/**
	 * 
	 * @param k
	 * @param v
	 * @param redisTemplate
	 */
	public static final void setStr(String k, String v, StringRedisTemplate redisTemplate) {
	}

}
