package service.sys.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 定义消息转换器。扫描不到呀。定制了WebMvcConfigurationSupport，这里时效。
 */
//@Configuration
//@EnableWebMvc
////@Order(2)
//@ComponentScan
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    //定义自己的消息转换机制
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        super.configureMessageConverters(converters);
//        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
//                .indentOutput(true)
//                .dateFormat(new SimpleDateFormat("yyyy-MM-dd"));
//                .modulesToInstall(new ParameterNamesModule());
//        converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
//        converters.add(new MappingJackson2XmlHttpMessageConverter(builder.xml().build()));
    }

    //转换与格式化
    @Override
    public void addFormatters(FormatterRegistry registry) {
        super.addFormatters(registry);
    }

    /**
     * 定义全局验证器
     *
     * 同时添加局部验证器
     * @Controller public class MyController {
     * @InitBinder protected void initBinder(WebDataBinder binder) {
     * binder.addValidators(new FooValidator());
     * }
     * }
     */
    @Override
    public Validator getValidator() {
//         return new GlobalValidator();
        return super.getValidator();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }

}
