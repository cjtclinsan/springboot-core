package com.tc.springboot.bootstrap;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.stream.Stream;

/**
 * @author woshi
 * @date 2021/1/8
 */
@ComponentScan(basePackages = "")           // 扫描默认包
public class ComponentScanDefaultPackageBootstrap {
    public static void main(String[] args) {
        // 注册当前引导类作为配置 Class,并启动当前上下文
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanDefaultPackageBootstrap.class);
        // 输出当前 Spring 应用上下文中所注册的 Bean 名称
        System.out.println("当前 Spring 应用上下文中所有注册的 Bean 名称：");
        Stream.of(context.getBeanDefinitionNames())
                .map(name -> "\t"+name)
                .forEach(System.out::println);
        // 关闭上下文
        context.close();
    }
}