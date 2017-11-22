package com.ymu.spcselling.infrastructure.spring.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;

public final class ConfigUtils {

    /**
     *  配置tomcat多协议。http，https
     * @param redirectFlag true，打开http协议将自动转换到https。否则不转。
     * @param serverPortHttp http协议端口
     * @param getServerPortHttps https端口
     * @return
     */
    public static final EmbeddedServletContainerFactory tomcatMultipleProtocol(boolean redirectFlag, int serverPortHttp, int getServerPortHttps) {
        TomcatEmbeddedServletContainerFactory tomcat;
        if (redirectFlag) {
            tomcat = new TomcatEmbeddedServletContainerFactory() {
                @Override
                protected void postProcessContext(Context context) {
                    SecurityConstraint constraint = new SecurityConstraint();
                    constraint.setUserConstraint("CONFIDENTIAL");
                    SecurityCollection collection = new SecurityCollection();
                    constraint.addCollection(collection);
                    collection.addPattern("/*");
                    context.addConstraint(constraint);
                }
            };
            tomcat.addAdditionalTomcatConnectors(createStandardConnector(redirectFlag,serverPortHttp,getServerPortHttps));
        } else {
            tomcat = new TomcatEmbeddedServletContainerFactory();
            tomcat.addAdditionalTomcatConnectors(createStandardConnector(redirectFlag,serverPortHttp,getServerPortHttps));
        }

        return tomcat;
    }

    private static Connector createStandardConnector(boolean redirectFlag,int serverPortHttp,int getServerPortHttps) {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        if (redirectFlag) {
            connector.setScheme("http");
            connector.setPort(serverPortHttp); // Connector监听的http的端口号
            connector.setSecure(false);
            connector.setRedirectPort(getServerPortHttps);  // 监听到http的端口号后转向到的https的端口号
        } else {
            connector.setPort(serverPortHttp);
        }
        return connector;
    }
}
