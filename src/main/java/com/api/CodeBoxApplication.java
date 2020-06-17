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
        log.info("程序环境:                {}", env.getProperty("spring.profiles.active"));
        log.info("程序端口:                {}", env.getProperty("server.port"));
        log.info("Startup complete (启动完成)...");
//        log.info("Logging Level:           {}", env.getProperty("logback.level"));
        log.info("====================================================================");
    }


}