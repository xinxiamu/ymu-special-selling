package com.ymu.spcselling.infrastructure.dao.ds;



public class DataSourceContextHolder {

//    private static final Logger LOGGER = LogManager.getLogger(DataSourceContextHolder.class);

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    /**
     * 设置数据源名。
     * @param dbType
     */
    public static void setDS(String dbType) {
//        log.debug("切换到{}数据源", dbType);
        contextHolder.set(dbType);
    }

    /**
     * 获取数据源名。
     * @return
     */
    public static String getDS() {
        return (contextHolder.get());
    }

    /**
     * 清除数据源名。
     */
    public static void clearDS() {
        contextHolder.remove();
    }
}