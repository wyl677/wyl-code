package com.wyl.docker;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @auther yanl.wang
 * @date 2022/6/25
 **/
@SpringBootApplication
@MapperScan("com.wyl.docker.mapper")
public class DockerBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(DockerBootApplication.class,args);
    }
}
