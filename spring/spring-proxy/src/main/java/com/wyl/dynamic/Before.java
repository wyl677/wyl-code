package com.wyl.dynamic;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @auther yanl.wang
 * @date 2023/2/8
 **/
public class Before implements MethodBeforeAdvice {
    /**
     * 需要把运行在原始方法执行之前运行的额外功能，书写在before方法中
     * @param method
     * @param args
     * @param target
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("--------log 日志额外功能------------");
    }
}
