package com.wyl;

import com.wyl.bean.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import sun.rmi.server.UnicastServerRef;

/**
 * @auther yanl.wang
 * @date 2023/2/20
 **/
@Configuration
@PropertySource("init.properties")
public class Appconfig1 {

    @Value("${id}")
    private Integer id;
    @Value("${username}")
    private String username;
    @Bean
    public User user(){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        return user;
    }
}
