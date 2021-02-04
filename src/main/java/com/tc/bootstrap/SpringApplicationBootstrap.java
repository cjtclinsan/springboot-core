package com.tc.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jmx.export.annotation.AnnotationMBeanExporter;

/**
 * @author woshi
 * @date 2021/2/3
 */
//@SpringBootApplication
public class SpringApplicationBootstrap {
    public static void main(String[] args) {
        // 启动 Spring Boot 应用
        ConfigurableApplicationContext context = SpringApplication.run(SpringApplicationBootstrap.class, args);

        AnnotationMBeanExporter exporter = context.getBean(AnnotationMBeanExporter.class);

        System.out.println("AnnotationMBeanExporter Bean:"+exporter);

        context.close();
//        SpringApplication.run(SpringApplicationBootstrap.class, args);
    }
}