package com.ymu.spcselling.gateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

/**
 * 使用@EnableZuulProxy注解激活zuul。
 * 跟进该注解可以看到该注解整合了@EnableCircuitBreaker、@EnableDiscoveryClient，是个组合注解，目的是简化配置。
 */
@EnableZuulProxy
@SpringBootApplication
public class SpcsellingApiGatewayApp {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpcsellingApiGatewayApp.class).run(args);
	}

	/**
	 * 使用regexmapper提供serviceId和routes之间的绑定. 它使用正则表达式组来从serviceId提取变量, 然后注入到路由表达式中。
	 *
	 * 这个意思是说"springms-provider-user-version"将会匹配路由"/version/springms-provider-user/**". 任何正则表达式都可以, 但是所有组必须存在于servicePattern和routePattern之中.
	 *
	 * @return
	 */
	@Bean
	public PatternServiceRouteMapper serviceRouteMapper() {
		return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)", "${version}/${name}");
	}


}
