package com.wyl.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @auther yanl.wang
 * @date 2023/2/20
 **/
@Configuration
@ComponentScan(basePackages = "com.wyl.aop")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

}
