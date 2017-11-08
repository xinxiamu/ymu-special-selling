package service.basic.user.config.ds;

import com.ymu.spcselling.infrastructure.dao.BaseRepositoryFactoryBean;
import net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import service.basic.user.common.Constants;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactorySpcsUserDB", transactionManagerRef = "transactionManagerSpcsUserDB", basePackages = {
        Constants.SPCS_USER_REPOSITORY_PACKAGE_PATH}, repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
public class SpcsUserDBConfig {

    @Autowired
    Environment ev;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource; // 数据源

    @Primary
    @Bean(name = "entityManagerSpcsUser")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactorySpcsUserDB(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "entityManagerFactorySpcsUserDB")
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySpcsUserDB(EntityManagerFactoryBuilder builder) {
        if (ev.acceptsProfiles("dev") || ev.acceptsProfiles("test")
                || ev.acceptsProfiles("update")) {
            dataSource = new DataSourceSpy(dataSource); // log4jdbc打印sql日志。
        }
        return builder.dataSource(dataSource).properties(getVendorProperties(dataSource))
                .packages(Constants.SPCS_USER_ENTITY_PACKAGE_PATH)
                .persistenceUnit("spcsUserUnit").build(); //实体管理器别名,多数据元要设置。
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
    @Bean(name = "transactionManagerSpcsUserDB")
    public PlatformTransactionManager transactionManagerSpcsUserDB(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactorySpcsUserDB(builder).getObject());
    }

}