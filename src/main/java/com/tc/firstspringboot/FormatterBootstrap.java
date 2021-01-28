package com.tc.firstspringboot;

import com.tc.samples.autoconfigure.formatter.Formatter;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author woshi
 * @date 2021/1/28
 */
@EnableAutoConfiguration
public class FormatterBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(FormatterBootstrap.class)
                .web(WebApplicationType.NONE).run(args);

        // 待格式化对象
        Map<String, Object> data = new HashMap<>();
        data.put("name", "tccc");
        // 获取 formatter
        Formatter formatter = context.getBean(Formatter.class);
        System.out.printf("formatter.format(data) : %s\n", formatter.format(data));
        // 关闭当前上下文
        context.close();
    }
}