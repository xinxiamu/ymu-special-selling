package service.basic.user.config.ds;

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

    @Value("${spring.datasource.druid.spcs-user.url}")
    private String spcsUserUrl;
    @Value("${spring.datasource.druid.spcs-user.username}")
    private String spcsUserUserName;
    @Value("${spring.datasource.druid.spcs-user.password}")
    private String spcsUserPwd;

    @Value("${spring.datasource.druid.spcs-user.initialSize}")
    private int initialSize;
    @Value("${spring.datasource.druid.spcs-user.minIdle}")
    private int minIdle;
    @Value("${spring.datasource.druid.spcs-user.minIdle}")
    private int maxActive;
    @Value("${spring.datasource.druid.spcs-user.maxWait}")
    private int maxWait;
    @Value("${spring.datasource.druid.spcs-user.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;
    @Value("${spring.datasource.druid.spcs-user.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.druid.spcs-user-slave.url}")
    private String spcsUserSlaveUrl;
    @Value("${spring.datasource.druid.spcs-user-slave.username}")
    private String spcsUserSlaveUserName;
    @Value("${spring.datasource.druid.spcs-user-slave.password}")
    private String spcsUserSlavePwd;
    @Value("${spring.datasource.druid.spcs-user-slave.initialSize}")
    private int initialSizeSlave;
    @Value("${spring.datasource.druid.spcs-user-slave.minIdle}")
    private int minIdleSlave;
    @Value("${spring.datasource.druid.spcs-user-slave.minIdle}")
    private int maxActiveSlave;
    @Value("${spring.datasource.druid.spcs-user-slave.maxWait}")
    private int maxWaitSlave;
    @Value("${spring.datasource.druid.spcs-user-slave.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillisSlave;
    @Value("${spring.datasource.druid.spcs-user-slave.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillisSlave;


    @Value("${spring.datasource.driver.mysql.driver-class-name}")
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
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);

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
        dataSource.setMinIdle(minIdleSlave);
        dataSource.setInitialSize(initialSizeSlave);
        dataSource.setMaxActive(maxActiveSlave);
        dataSource.setMaxWait(maxWaitSlave);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillisSlave);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillisSlave);

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
