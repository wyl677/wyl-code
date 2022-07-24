package com.wyl.docker.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

/**
 * @auther yanl.wang
 * @date 2022/6/26
 **/
@Configuration
@Slf4j
public class RedisConfig {
    /**
     * redis 序列化的工具配置类，下面这个请一定开启配置
     * 127.0.0.1:6379> keys *
     * "ord:102"   序列化过
     * "\xac\xed\x00\x05t\x00\aord:102"    野生，没有序列化过
     */
    @Bean
    public RedisTemplate<String, Serializable> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(lettuceConnectionFactory);
        // 设置 key 序列化方式 string
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 设置 value 的序列化方式 json
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
