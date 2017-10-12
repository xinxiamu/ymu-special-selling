package service.sys.common.config;

import com.ymu.spcselling.infrastructure.spring.AppContext;
import com.ymu.spcselling.infrastructure.spring.SpringBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {

    /**
     * 环境上下文。
     *
     * @return
     */
    @Bean
    public AppContext appContext() {
        return new AppContext();
    }

    /**
     * Bean工厂。
     *
     * @return
     */
    @Bean
    public SpringBeanFactory springBeanFactory() {
        return new SpringBeanFactory();
    }

}
