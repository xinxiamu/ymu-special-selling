package service.sys.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ymu.spcselling.infrastructure.spring.AppContext;
import com.ymu.spcselling.infrastructure.spring.SpringBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

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

    @Bean
    public CorsFilter corsFilter(@Autowired CorsRegistrationConfig corsRegistrationConfig) {
        //1.添加CORS配置信息
        CorsConfiguration config = new CorsConfiguration();
        //放行哪些原始域
        config.addAllowedOrigin(corsRegistrationConfig.getAllowedOrigins());
        //是否发送Cookie信息
        config.setAllowCredentials(corsRegistrationConfig.getAllowCredentials());
        //放行哪些原始域(请求方式)
        config.addAllowedMethod(corsRegistrationConfig.getAllowedMethods());
        //放行哪些原始域(头部信息)
        config.addAllowedHeader(corsRegistrationConfig.getAllowedHeaders());
        //暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
//        config.addExposedHeader("header-1,header-2");

        //2.添加映射路径
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);

        //3.返回新的CorsFilter.
        return new CorsFilter(configSource);
    }
}
