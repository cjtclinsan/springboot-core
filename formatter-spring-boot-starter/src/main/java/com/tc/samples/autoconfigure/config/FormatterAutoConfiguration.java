package com.tc.samples.autoconfigure.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tc.samples.autoconfigure.formatter.DefaultFormatter;
import com.tc.samples.autoconfigure.formatter.Formatter;
import com.tc.samples.autoconfigure.formatter.JsonFomatter;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author woshi
 * @date 2021/1/28
 */
@Configuration
@ConditionalOnProperty(prefix = "formatter", name = "enabled", havingValue = "true", matchIfMissing = true)  // 当属性配置不存在时，同样视作匹配
@ConditionalOnResource(resources = "META-INF/spring.factories")
@ConditionalOnNotWebApplication
@ConditionalOnExpression("${formatter.enabled:false}")
public class FormatterAutoConfiguration {
    @Bean
    @ConditionalOnMissingClass(value = "com.fasterxml.jackson.databind.ObjectMapper")
    public Formatter defaultFormatter(){
        return new DefaultFormatter();
    }

    @Bean
    @ConditionalOnClass(name = "com.fasterxml.jackson.databind.ObjectMapper")
    @ConditionalOnMissingBean(type = "com.fasterxml.jackson.databind.ObjectMapper")
    public Formatter jsonFormatter(){
        return new JsonFomatter();
    }

    @Bean
    @ConditionalOnBean(ObjectMapper.class)
    public Formatter objectMapperFormatter(ObjectMapper objectMapper){
        return new JsonFomatter(objectMapper);
    }
}