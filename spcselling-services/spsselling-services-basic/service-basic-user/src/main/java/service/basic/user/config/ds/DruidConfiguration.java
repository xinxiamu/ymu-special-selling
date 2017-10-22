package service.basic.user.config.ds;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Druid监控 http://localhost:8080/druid
 *
 * @author Administrator
 */
@Configuration
public class DruidConfiguration {

    private static final Logger log = LoggerFactory.getLogger(DruidConfiguration.class);

    //登录账号
    @Value("${druid.login-user-name}")
    private String loginUsername;
    //登录密码
    @Value("${druid.login-user-pwd}")
    private String loginPwd;
    //ip白名单，多个用英文逗号隔开
    @Value("${druid.allow}")
    private String allow;
    //ip黑名单
    @Value("${druid.deny}")
    private String deny;

    @Bean
    public ServletRegistrationBean druidServlet() {
        log.info("init Druid Servlet Configuration ");
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        StatViewServlet statViewServlet = new StatViewServlet();
        servletRegistrationBean.setServlet(statViewServlet);
        servletRegistrationBean.addUrlMappings("/druid/*");
        Map<String, String> initParameters = new HashMap<String, String>();

        initParameters.put("loginUsername", loginUsername);// 用户名
        initParameters.put("loginPassword", loginPwd);// 密码

        initParameters.put("resetEnable", "false");// 禁用HTML页面上的“Reset All”功能

        initParameters.put("allow", allow); // IP白名单 (没有配置或者为空，则允许所有访问)
        initParameters.put("deny", deny);// IP黑名单
        // (存在共同时，deny优先于allow)
        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        WebStatFilter   webStatFilter = new WebStatFilter();
        filterRegistrationBean.setFilter(webStatFilter);
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
