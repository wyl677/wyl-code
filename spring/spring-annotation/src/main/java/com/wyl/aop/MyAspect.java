package com.wyl.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @auther yanl.wang
 * @date 2023/2/20
 **/
@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(* com.wyl.aop..*.*(..))")
    public void pointCut(){}

    @Around("pointCut()")
    public Object arround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("------------Log-----------");
        Object proceed = joinPoint.proceed();
        return proceed;
    }
}
