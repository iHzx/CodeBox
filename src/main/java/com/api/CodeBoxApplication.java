package com.api;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.mybatis.spring.annotation.MapperScan;

/**
 * 项目启动类
 * @author huzhaoxi
 * @date 2019/09/27 09:20
 */
@SpringBootApplication
@MapperScan("com.api.dao")
public class CodeBoxApplication {

    private static Logger log = LoggerFactory.getLogger(CodeBoxApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CodeBoxApplication.class,args);
        Environment env = context.getEnvironment();
        log.info("====================================================================");
        log.info("Project Environment:     {}", env.getProperty("project.env"));
        log.info("Server Port:             {}", env.getProperty("server.port"));
        log.info("Logging Level:           {}", env.getProperty("logback.level"));
        log.info("Startup complete ...");
        log.info("====================================================================");
    }

//    /**
//     * http重定向到https
//     * @return
//     */
//    @Bean
//    public TomcatServletWebServerFactory servletContainer() {
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
//            @Override
//            protected void postProcessContext(Context context) {
//                SecurityConstraint constraint = new SecurityConstraint();
//                constraint.setUserConstraint("CONFIDENTIAL");
//                SecurityCollection collection = new SecurityCollection();
//                collection.addPattern("/*");
//                constraint.addCollection(collection);
//                context.addConstraint(constraint);
//            }
//        };
//        tomcat.addAdditionalTomcatConnectors(httpConnector());
//        return tomcat;
//    }
//
//    @Bean
//    public Connector httpConnector() {
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        connector.setScheme("http");
//        //Connector监听的http的端口号
//        connector.setPort(9988);
//        connector.setSecure(false);
//        //监听到http的端口号后转向到的https的端口号
//        connector.setRedirectPort(443);
//        return connector;
//    }



}