package com.wyl.four;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @auther yanl.wang
 * @date 2023/2/20
 **/
public class TestBean {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Account3 account = context.getBean("account3", Account3.class);
        System.out.println(account);
    }
}
