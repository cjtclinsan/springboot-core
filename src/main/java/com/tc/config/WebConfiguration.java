package com.tc.config;

import com.tc.autoconfigure.WebAutoConfiguration;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.servlet.function.RequestPredicates.GET;
import static org.springframework.web.servlet.function.RouterFunctions.route;
import static org.springframework.web.servlet.function.ServerResponse.ok;

/**
 * @author woshi
 * @date 2020/12/7
 */
@Configuration
public class WebConfiguration {
    @Bean
    public RouterFunction<ServerResponse> helloworld(){
        return route(GET("/hello-world"),
                request -> ok().body(Mono.just("Hello world"))
        );
    }

    @EventListener(WebServerInitializedEvent.class)
    public void onWebServerReady(WebServerInitializedEvent event){
        System.out.println("当前 WebServer 实现类为"+event.getWebServer().getClass().getName());
    }

    @Bean
    public ApplicationRunner runner(BeanFactory beanFactory){
        return args -> {
            System.out.println("当前 helloWorld Bean 实现类为："
                    + beanFactory.getBean("helloworld").getClass().getName());

            System.out.println("当前 WebConfiguration Bean 实现类为："
                    + beanFactory.getBean(WebConfiguration.class).getClass().getName());
        };
    }
}