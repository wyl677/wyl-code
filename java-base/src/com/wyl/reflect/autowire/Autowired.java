package com.wyl.reflect.autowire;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
@Documented
//自定义注解
public @interface Autowired {

}
