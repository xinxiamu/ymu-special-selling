package com.ymu.spcselling.infrastructure.dao;

import javax.persistence.EntityManager;

import org.springframework.jdbc.core.JdbcTemplate;

@SuppressWarnings("rawtypes")
public interface BaseDao<T extends BaseRepository> {

	 T getMRepository();
	 
	 EntityManager getEntityManager();
	 
	 JdbcTemplate getJdbcTemplate();
	 
}
