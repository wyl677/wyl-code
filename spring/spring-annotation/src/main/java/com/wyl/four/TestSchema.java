package com.wyl.four;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @auther yanl.wang
 * @date 2023/2/20
 **/
public class TestSchema {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Account account = context.getBean("account", Account.class);
        System.out.println(account);
    }
}
