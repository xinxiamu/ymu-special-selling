package com.spcs.web.facade.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * spring mvc配置类。添加这个后，自动配置WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter将失效。
 * 所以推荐默认，一般情况不引入这个。
 */
@Configuration
//@EnableWebMvc //用了EnableWebMvc后，springBoot的默认的mvc配置都失效，要自己去配置每一项。所以一般不用
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 1、 extends WebMvcConfigurationSupport
     * 2、重写下面方法;
     * setUseSuffixPatternMatch : 设置是否是后缀模式匹配，如“/user”是否匹配/user.*，默认真即匹配；
     * setUseTrailingSlashMatch : 设置是否自动后缀路径模式匹配，如“/user”是否匹配“/user/”，默认真即匹配；
     */
   /* @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(true)
                .setUseTrailingSlashMatch(false);
        super.configurePathMatch(configurer);
    }*/

   /* @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/myres/**").addResourceLocations("F:/mu/ymu-special-selling/static/**");
        super.addResourceHandlers(registry);
    }*/

}
