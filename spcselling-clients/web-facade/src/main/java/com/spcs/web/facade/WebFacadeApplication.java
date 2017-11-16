package com.spcs.web.facade;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.SocketUtils;

@SpringBootApplication
public class WebFacadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebFacadeApplication.class, args);
	}

	//---------- tomcat多协议配置 start ----------------//

	@Value("${custom.tomcat.http.port}")
	private int serverPortHttp;

	@Value("${server.port}")
	private int getServerPortHttps;

	/**
	 * true,http自动跳出到https。false不跳转。
	 */
	@Value("${custom.tomcat.redirect-flg}")
	private boolean redirectFlag;

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory tomcat;
		if (redirectFlag) {
			tomcat = new TomcatEmbeddedServletContainerFactory() {
				@Override
				protected void postProcessContext(Context context) {
					SecurityConstraint constraint = new SecurityConstraint();
					constraint.setUserConstraint("CONFIDENTIAL");
					SecurityCollection collection = new SecurityCollection();
					collection.addPattern("/*");
					constraint.addCollection(collection);
					context.addConstraint(constraint);
				}
			};
			tomcat.addAdditionalTomcatConnectors(createStandardConnector());
		} else {
			tomcat = new TomcatEmbeddedServletContainerFactory();
			tomcat.addAdditionalTomcatConnectors(createStandardConnector());
		}

		return tomcat;
	}

	@Bean
	public Connector createStandardConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		if (redirectFlag) {
			connector.setScheme("http");
			// Connector监听的http的端口号
			connector.setPort(serverPortHttp);
			connector.setSecure(false);
			// 监听到http的端口号后转向到的https的端口号
			connector.setRedirectPort(getServerPortHttps);
		} else {
			connector.setPort(serverPortHttp);
		}
		return connector;
	}

	//---------- tomcat多协议配置 end ----------------//
}
