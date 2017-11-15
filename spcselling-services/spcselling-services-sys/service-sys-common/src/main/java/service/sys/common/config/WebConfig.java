package service.sys.common.config;

import com.ymu.spcselling.infrastructure.spring.mvc.api.CustomRequestMappingHandlerMapping;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping handlerMapping = new CustomRequestMappingHandlerMapping();
        handlerMapping.setOrder(0);
        handlerMapping.setInterceptors(getInterceptors());
        return handlerMapping;
    }

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
    }

    /**
     * 全局验证器
     * @return
     */
    @Override
    protected Validator getValidator() {
//        return new GlobalValidator(); //设置自己的全局表单校验器后，hibernate-valid的将失效
        return super.getValidator();
    }

    @Override
    protected void addFormatters(FormatterRegistry registry) {
        super.addFormatters(registry);
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }

    /**
     * 全局跨域设置。
     * @param registry
     */
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        /*registry.addMapping("/**")
                //放行哪些原始域
                .allowedOrigins("*")
                //是否发送Cookie信息
                .allowCredentials(true)
                //放行哪些原始域(请求方式)
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                //放行哪些原始域(头部信息)
                .allowedHeaders("*");*/

        //配置允许跨域访问的路径
        registry.addMapping("/**");
    }

}
