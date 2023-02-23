package com.wyl.mybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @auther yanl.wang
 * @date 2023/2/20
 **/
public class TestMybatis {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyBatisConfiguration.class);
        UserDao userDao = (UserDao) context.getBean("userDao");

        User user = new User();
        user.setId(3);
        user.setUsername("xiaojr");
        userDao.save(user);
    }
}
