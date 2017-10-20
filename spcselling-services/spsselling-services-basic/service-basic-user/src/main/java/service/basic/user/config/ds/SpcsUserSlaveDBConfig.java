package service.basic.user.config.ds;

import com.ymu.spcselling.infrastructure.dao.BaseRepositoryFactoryBean;
import net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import service.basic.user.common.Constants;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@AutoConfigureAfter(DataSourceConfig.class)
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactorySpcsUserSlaveDB", transactionManagerRef = "transactionManagerSpcsUserSlaveDB", basePackages = {
        Constants.SPCS_USER_REPOSITORY_PACKAGE_PATH}, repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)

public class SpcsUserSlaveDBConfig {

    @Autowired
    Environment ev;

    @Autowired
    @Qualifier("dynamicDS")
    private DataSource dataSource; // 数据源

    @Primary
    @Bean(name = "entityManagerSpcsUserSlave")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactorySpcsUserSlaveDB(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "entityManagerFactorySpcsUserSlaveDB")
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySpcsUserSlaveDB(EntityManagerFactoryBuilder builder) {
        if (ev.acceptsProfiles("dev") || ev.acceptsProfiles("test")
                || ev.acceptsProfiles("update")) {
            dataSource = new DataSourceSpy(dataSource); // log4jdbc打印sql日志。
        }
        return builder.dataSource(dataSource).properties(getVendorProperties(dataSource))
                .packages(Constants.SPCS_USER_ENTITY_PACKAGE_PATH)
                .persistenceUnit("spcsUserSlaveUnit").build(); //实体管理器别名,多数据元要设置。
    }

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        JpaProperties jpaProperties = new JpaProperties();
        return jpaProperties.getHibernateProperties(dataSource);
    }

    /**
     * 开启事务。
     *
     * @param builder
     * @return
     */
    @Primary
    @Bean(name = "transactionManagerSpcsUserSlaveDB")
    public PlatformTransactionManager transactionManagerSpcsUserSlaveDB(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactorySpcsUserSlaveDB(builder).getObject());
    }

    /**
     * spring jdbc。
     *
     * @param dataSource
     * @return
     */
    @Bean(name = "jdbcTemplate")
    @Primary
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("dynamicDS") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}