package com.wyl.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.wyl.boot.bean.Car;
import com.wyl.boot.bean.Pet;
import com.wyl.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @auther yanl.wang
 * @date 2023/2/21
 **/
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true)
//@ConditionalOnMissingBean(name = "tom")
@EnableConfigurationProperties(Car.class)
public class MyConfig {

    @Bean
    public User user01(){
        User user = new User(18, "zhangsan");
        user.setPet(tom());
        return user;
    }

    @Bean
    public Pet tom(){
        Pet pet = new Pet(1, "黑色");
        return pet;
    }
}
