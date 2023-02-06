package com.wyl.annotation;

import java.lang.annotation.*;

/**
 * @auther yanl.wang
 * @date 2023/2/3
 **/
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WylRequestMapping {
    String value() default "";
}
