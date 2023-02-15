package com.wyl.dynamic;

import com.wyl.proxy.User;
import com.wyl.proxy.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @auther yanl.wang
 * @date 2023/2/15
 * 对应配置文件：applicationContext.xml
 **/
public class TestBefore {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.login("wyl","123456");
        System.out.println();
        userService.register(new User());
    }
}
