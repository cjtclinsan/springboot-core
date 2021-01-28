package com.tc.samples.autoconfigure.config;

import com.tc.samples.autoconfigure.formatter.DefaultFormatter;
import com.tc.samples.autoconfigure.formatter.Formatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author woshi
 * @date 2021/1/28
 */
@Configuration
public class FormatterAutoConfiguration {
    @Bean
    public Formatter defaultFormatter(){
        return new DefaultFormatter();
    }
}