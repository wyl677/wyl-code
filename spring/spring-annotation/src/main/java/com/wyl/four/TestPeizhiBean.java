package com.wyl.four;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @auther yanl.wang
 * @date 2023/2/20
 **/
public class TestPeizhiBean {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Account4 account4 = context.getBean("account4", Account4.class);
        System.out.println(account4);
    }
}
