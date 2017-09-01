package service.sys.email;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class ServiceSysEmailApp {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ServiceSysEmailApp.class).web(true).run(args);
	}

}
