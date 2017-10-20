package service.basic.user.config.ds;

import java.sql.SQLException;
import java.util.*;

import javax.sql.DataSource;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.logging.Log4j2Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.ymu.spcselling.infrastructure.dao.ds.DynamicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;


/**
 * 配置数据源
 */
@Configuration
public class DataSourceConfig {

    @Autowired
    private Environment env;

    @Value("${spring.datasource.druid.spcs-user.url}")
    private String spcsUserUrl;
    @Value("${spring.datasource.druid.spcs-user.username}")
    private String spcsUserUserName;
    @Value("${spring.datasource.druid.spcs-user.password}")
    private String spcsUserPwd;

    @Value("${spring.datasource.druid.spcs-user-slave.url}")
    private String spcsUserSlaveUrl;
    @Value("${spring.datasource.druid.spcs-user-slave.username}")
    private String spcsUserSlaveUserName;
    @Value("${spring.datasource.druid.spcs-user-slave.password}")
    private String spcsUserSlavePwd;

    @Value("${spring.datasource.druid.mysql.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.druid.filters}")
    private String filters;


    @Bean(name = "log4j2Filter")
    public Log4j2Filter log4j2Filter() {
        Log4j2Filter log4j2Filter = new Log4j2Filter();
        log4j2Filter.setConnectionLogEnabled(false);
        log4j2Filter.setResultSetLogEnabled(true); //显示sql
        log4j2Filter.setDataSourceLogEnabled(false);
        log4j2Filter.setStatementExecutableSqlLogEnable(true);
        log4j2Filter.setStatementLogEnabled(false);
        return log4j2Filter;
    }

    /**
     * 会员主库（spcs_user）数据源。
     *
     * @return
     * @throws SQLException
     */
    @Bean(name = "spcsUserDataSource")
    @Qualifier("spcsUserDataSource")
    public DataSource spcsUserDataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(spcsUserUrl);
        dataSource.setUsername(spcsUserUserName);
        dataSource.setPassword(spcsUserPwd);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setInitialSize(1);
        dataSource.setMinIdle(1);
        dataSource.setMaxActive(50);
        dataSource.setMaxWait(60000);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMinEvictableIdleTimeMillis(300000);

        //加上这个，否则无法监控sql
        dataSource.setFilters(filters);

        List<Filter> proxyFilters = new ArrayList<>();
        proxyFilters.add(log4j2Filter());
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
    public DataSource spcsUserSlaveDataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(spcsUserSlaveUrl);
        dataSource.setUsername(spcsUserSlaveUserName);
        dataSource.setPassword(spcsUserSlavePwd);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setMinIdle(1);
        dataSource.setInitialSize(1);
        dataSource.setMaxActive(50);
        dataSource.setMaxWait(60000);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMinEvictableIdleTimeMillis(300000);

        //加上这个，否则无法监控sql
        dataSource.setFilters(filters);

        List<Filter> proxyFilters = new ArrayList<>();
        proxyFilters.add(log4j2Filter());
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
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(spcsUserDataSource);

        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap<>(5);
        dsMap.put(DSType.SPCS_USER.name(), spcsUserDataSource);
        dsMap.put(DSType.SPCS_USER_SLAVE.name(), spcsUserSlaveDataSource);

        dynamicDataSource.setTargetDataSources(dsMap);

        return dynamicDataSource;
    }

}
