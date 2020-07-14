package com.myown.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import uk.org.lidalia.sysoutslf4j.context.SysOutOverSLF4J;

@SpringBootApplication
@EnableScheduling
@EnableAsync
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class GameApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SysOutOverSLF4J.sendSystemOutAndErrToSLF4J();
        SpringApplication.run(GameApplication.class, args);
    }

    /*
    * 继承SprinBootServletInitializer抽象类
    * 是为了当使用外置的Tomcat服务器时也可以启动项目
    * */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GameApplication.class);
    }
}
