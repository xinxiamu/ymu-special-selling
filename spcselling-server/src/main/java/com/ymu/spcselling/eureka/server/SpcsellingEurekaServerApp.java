package com.ymu.spcselling.eureka.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpcsellingEurekaServerApp {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpcsellingEurekaServerApp.class).web(true).run(args);
	}

}
