package com.wyl.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @auther yanl.wang
 * @date 2023/2/20
 * 纯注解AOP开发
 **/
public class TestAop {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userServiceImpl = (UserService) context.getBean("userServiceImpl");
        userServiceImpl.register();
        userServiceImpl.login();
    }
}
