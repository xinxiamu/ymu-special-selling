package service.sys.sms;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceSysSmsApp {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ServiceSysSmsApp.class).web(true).run(args);
	}

}
