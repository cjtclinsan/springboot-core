package com.tc.springtc.bootstrap;

import com.tc.springtc.repository.NameRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author woshi
 * @date 2021/1/7
 */
public class DerivedComponentAnnotationBootstrap {
    static {
        // 解决 Spring 2.5.x 不兼容 Java 8 的问题
        // 同时，请注意 Java Security 策略，必须具备 PropertyPermission
        System.setProperty("java.version", "1.7.0");
    }

    public static void main(String[] args) {
        // 构建 XML 配置驱动 Spring 上下文
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        // 设置 XML 配置文件你的位置
        context.setConfigLocation("classpath:/META-INF/spring/context.xml");
        // 启动上下文
        context.refresh();
        // 获取名为 "chineseNameRepository" 的 Bean 对象
        NameRepository nameRepository = (NameRepository) context.getBean("chineseNameRepository");
        // 输出用户名
        System.out.println(nameRepository.findAll());
    }
}