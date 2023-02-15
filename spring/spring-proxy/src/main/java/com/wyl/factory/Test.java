package com.wyl.factory;

import com.wyl.proxy.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @auther yanl.wang
 * @date 2023/2/15
 **/
public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext2.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.login("wyl","123456");
        userService.register(new User());
    }
}
