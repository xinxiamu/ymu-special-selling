package com.ymu.spcselling.infrastructure.utils.sql;

/**
 * copy自mybatis源码。用在spring jdbc sql构造
 * Created by mutou on 16-12-19.
 */
public class SqlBuilder extends AbstractSqlBuilder<SqlBuilder> {

    @Override
    public SqlBuilder getSelf() {
        return this;
    }
}
