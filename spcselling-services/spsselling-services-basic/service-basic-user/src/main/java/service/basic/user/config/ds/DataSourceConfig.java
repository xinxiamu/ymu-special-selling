package service.basic.user.config.ds;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.logging.Log4j2Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import com.ymu.spcselling.infrastructure.dao.ds.DynamicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 配置数据源
 */
@Configuration
public class DataSourceConfig {

    @Autowired
    private Environment env;

//    @Value("${spring.datasource.druid.filters}")
//    private String filters;

    /**
     * druid监控filter配置。
     * @return
     */
    @Bean
    public StatFilter statFilter() {
        StatFilter statFilter = new StatFilter();
        statFilter.setSlowSqlMillis(5 * 1000); //超过5秒执行的为慢sql
        statFilter.setLogSlowSql(true); //日志记录慢sql
        statFilter.setMergeSql(true); //相同sql合并
        return statFilter;
    }

    //----------- sql注入攻击防御配置 start ---------//

    @Bean
    public WallConfig wallConfig() {
        WallConfig wallConfig = new WallConfig();
        wallConfig.setDir("classpath:druid/wall/mysql"); //sql过滤规则装载位置。
        return wallConfig;
    }

    @Bean
    public WallFilter wallFilter() {
        WallFilter wallFilter = new WallFilter();
        wallFilter.setDbType("mysql"); //指定数据库类型。
        wallFilter.setConfig(wallConfig());
        return wallFilter;
    }

    //----------- sql注入攻击防御配置 end ---------//


    /**
     * 打印sql语句。
     * @return
     */
    @Bean(name = "log4j2Filter")
    public Log4j2Filter log4j2Filter() {
        Log4j2Filter log4j2Filter = new Log4j2Filter();
        log4j2Filter.setConnectionLogEnabled(false);
        log4j2Filter.setResultSetLogEnabled(true); //显示sql
        log4j2Filter.setDataSourceLogEnabled(false);
        log4j2Filter.setStatementExecutableSqlLogEnable(true); //输出可执行的SQL
        log4j2Filter.setStatementLogEnabled(false);
        return log4j2Filter;
    }



    //-------------- 数据源配置 start ---------------//

    /**
     * 会员主库（spcs_user）数据源。
     *
     * @return
     * @throws SQLException
     */
    @Bean(name = "spcsUserDataSource")
    @Qualifier("spcsUserDataSource")
    public DataSource spcsUserDataSource(@Autowired SpcsUserDSArgs args) throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(args.getUrl());
        dataSource.setUsername(args.getUsername());
        dataSource.setPassword(args.getPassword());
        dataSource.setDriverClassName(args.getDriverClassName());
        dataSource.setInitialSize(args.getInitialSize());
        dataSource.setMinIdle(args.getMinIdle());
        dataSource.setMaxActive(args.getMaxActive());
        dataSource.setMaxWait(args.getMaxWait());
        dataSource.setTimeBetweenEvictionRunsMillis(args.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(args.getMinEvictableIdleTimeMillis());

        dataSource.setUseGlobalDataSourceStat(true); //合并多个DruidDataSource的监控数据

        //加上这个，否则无法监控sql
//        dataSource.setFilters(filters);

        List<Filter> proxyFilters = new ArrayList<>();
        proxyFilters.add(statFilter());
        proxyFilters.add(log4j2Filter());
        proxyFilters.add(wallFilter());
        dataSource.setProxyFilters(proxyFilters);

        return dataSource;
    }

    /**
     * 会员从库（spcs_user_slave）数据源。
     *
     * @return
     * @throws SQLException
     */
    @Bean(name = "spcsUserSlaveDataSource")
    @Qualifier("spcsUserSlaveDataSource")
    public DataSource spcsUserSlaveDataSource(@Autowired SpcsUserSlaveDSArgs args) throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(args.getUrl());
        dataSource.setUsername(args.getUsername());
        dataSource.setPassword(args.getPassword());
        dataSource.setDriverClassName(args.getDriverClassName());
        dataSource.setMinIdle(args.getMinIdle());
        dataSource.setInitialSize(args.getInitialSize());
        dataSource.setMaxActive(args.getMaxActive());
        dataSource.setMaxWait(args.getMaxWait());
        dataSource.setTimeBetweenEvictionRunsMillis(args.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(args.getMinEvictableIdleTimeMillis());

        //加上这个，否则无法监控sql
//        dataSource.setFilters(filters);

        List<Filter> proxyFilters = new ArrayList<>();
        proxyFilters.add(statFilter());
        proxyFilters.add(log4j2Filter());
        proxyFilters.add(wallFilter());
        dataSource.setProxyFilters(proxyFilters);

        return dataSource;
    }


    /**
     * 动态数据源: 通过AOP在不同数据源之间动态切换
     *
     * @return
     */
    @Primary
    @Bean(name = "dynamicDS")
    @Scope("singleton")
    public DataSource muDynamicDataSource(@Qualifier("spcsUserDataSource") DataSource spcsUserDataSource,
                                          @Qualifier("spcsUserSlaveDataSource") DataSource spcsUserSlaveDataSource) {
        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap<>(5);
        dsMap.put(DSType.SPCS_USER.name(), spcsUserDataSource);
        dsMap.put(DSType.SPCS_USER_SLAVE.name(), spcsUserSlaveDataSource);

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(spcsUserDataSource);
        dynamicDataSource.setTargetDataSources(dsMap);

        return dynamicDataSource;
    }

}
