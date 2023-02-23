package com.wyl.four;

import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

/**
 * @auther yanl.wang
 * @date 2023/2/20
 * 基于schema
 **/
public class Account implements Serializable {
    @Value("${id}")
    private Integer id;
    @Value("${name}")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
