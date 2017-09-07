package com.ymu.spcselling.config.server;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableAutoConfiguration
@EnableEurekaClient
@EnableDiscoveryClient
@EnableConfigServer // 开启配置中心功能
@SpringBootApplication
public class SpcsellingConfigServerApp {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpcsellingConfigServerApp.class).web(true).run(args);
	}

}
