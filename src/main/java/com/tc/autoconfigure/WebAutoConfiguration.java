package com.tc.autoconfigure;

import com.tc.config.WebConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author woshi
 * @date 2020/12/8
 */
//@ConditionalOnWebApplication
@Configuration
@Import(WebConfiguration.class)
public class WebAutoConfiguration {
}