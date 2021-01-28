package com.tc.springtc.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author woshi
 * @date 2021/1/7
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface StringRepository {
    String value() default "";
}
