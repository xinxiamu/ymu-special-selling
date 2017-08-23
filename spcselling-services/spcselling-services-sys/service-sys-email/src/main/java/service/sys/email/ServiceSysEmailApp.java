package service.sys.email;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceSysEmailApp {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ServiceSysEmailApp.class).web(true).run(args);
	}

}
