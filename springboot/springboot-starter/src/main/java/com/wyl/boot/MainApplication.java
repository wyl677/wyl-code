package com.wyl.boot;

import ch.qos.logback.core.db.DBHelper;
import com.wyl.boot.bean.Car;
import com.wyl.boot.bean.Pet;
import com.wyl.boot.bean.User;
import com.wyl.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @auther yanl.wang
 * @date 2023/2/21
 * 主程序类
 * @SpringBootApplication ：这是一个SpringBoot应用
 **/
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        //1.返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class);
        //2.查看容器里面的组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("==== "+beanDefinitionName);
        }

        //3.从容器中获取组件(就算proxyBeanMethods = false，还是从容器中拿，获取到的是同一个对象)
        Pet tom1 = run.getBean("tom", Pet.class);
        Pet tom2 = run.getBean("tom", Pet.class);
        System.out.println("tom1==tom2:"+ (tom1 == tom2));

        //4.获取配置类的对象(proxyBeanMethods = false时，MyConfig就是普通的对象，不是容器创建的代理对象)
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

        User user1 = bean.user01();
        User user2 = bean.user01();
        System.out.println("user1==user2: "+ (user1==user2));

        //5.proxyBeanMethods = true 宠物是同一个宠物
        User user01 = run.getBean("user01", User.class);
        Pet tom = run.getBean("tom",Pet.class);
        System.out.println(user01.getPet() == tom);

        System.out.println("=================");
        //6.获取所有指定类型的组件
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }

        DBHelper bean1 = run.getBean(DBHelper.class);
        System.out.println(bean1);

        Car car = run.getBean(Car.class);
        System.out.println(car);
    }
}
