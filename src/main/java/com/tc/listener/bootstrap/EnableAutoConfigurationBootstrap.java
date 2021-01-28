package com.tc.listener.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author woshi
 * @date 2021/1/12
 */
@EnableAutoConfiguration(exclude = SpringApplicationAdminJmxAutoConfiguration.class)
public class EnableAutoConfigurationBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(EnableAutoConfigurationBootstrap.class)
                .web(WebApplicationType.NONE)       // 非web应用
                .run(args)                          // 运行
                .close();                           // 关闭当前上下文
    }
}