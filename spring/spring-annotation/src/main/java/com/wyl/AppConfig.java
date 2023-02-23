package com.wyl;

import com.wyl.bean.ConnectionFactoryBean;
import com.wyl.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @auther yanl.wang
 * @date 2023/2/19
 **/
@Configuration
public class AppConfig {

    /**
     * 简单对象
     *
     * @return
     */
    @Bean
    public User user() {
        return new User();
    }

    @Bean
    public Connection conn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.83.2:3306/sunds?useSSL=false", "root", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * @return
     * @Bean注解和FactoryBean集成的方式
     */
    @Bean
    public Connection conn1() {
        Connection conn = null;
        try {
            ConnectionFactoryBean factoryBean = new ConnectionFactoryBean();
            conn = factoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
