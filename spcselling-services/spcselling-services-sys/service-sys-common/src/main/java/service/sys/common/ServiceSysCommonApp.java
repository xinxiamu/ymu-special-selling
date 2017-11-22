package service.sys.common;

import com.ymu.spcselling.infrastructure.spring.config.ConfigUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
//@ComponentScan(value = {"service.sys.common","com.ymu.spcselling.infrastructure.spring"})
public class ServiceSysCommonApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ServiceSysCommonApp.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ServiceSysCommonApp.class);
    }

    //---------- tomcat多协议配置 start ----------------//

    @Value("${custom.tomcat.http.port}")
    private int serverPortHttp;

    @Value("${server.port}")
    private int getServerPortHttps;

    /**
     * true,http自动跳出到https。false不跳转。
     */
    @Value("${custom.tomcat.redirect-flg}")
    private boolean redirectFlag;

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        return ConfigUtils.tomcatMultipleProtocol(redirectFlag,serverPortHttp,getServerPortHttps);
    }
    //---------- tomcat多协议配置 end ----------------//
}
