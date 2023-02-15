package com.wyl.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @auther yanl.wang
 * @date 2023/2/15
 **/
public class ProxyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("--------new log----------");
                Object ret = method.invoke(bean, args);

                return ret;
            }
        };
        Object proxy = Proxy.newProxyInstance(ProxyBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), handler);
        return proxy;
    }
}
