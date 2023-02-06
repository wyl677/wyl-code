package com.wyl.bean;

import java.util.*;

/**
 * @auther yanl.wang
 * @date 2023/2/6
 * Spring基础复习，XML配置文件
 **/
public class Person {
    private Integer age;
    private String name;
    private String[] email;
    private Set<String> tels;
    private List<String> addr;
    private Map<String,String> qqs;
    private Properties p;

    private Son son;

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", email=" + Arrays.toString(email) +
                ", tels=" + tels +
                ", addr=" + addr +
                ", qqs=" + qqs +
                ", p=" + p +
                ", son=" + son +
                '}';
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getEmail() {
        return email;
    }

    public void setEmail(String[] email) {
        this.email = email;
    }

    public Set<String> getTels() {
        return tels;
    }

    public void setTels(Set<String> tels) {
        this.tels = tels;
    }

    public List<String> getAddr() {
        return addr;
    }

    public void setAddr(List<String> addr) {
        this.addr = addr;
    }

    public Map<String, String> getQqs() {
        return qqs;
    }

    public void setQqs(Map<String, String> qqs) {
        this.qqs = qqs;
    }

    public Properties getP() {
        return p;
    }

    public void setP(Properties p) {
        this.p = p;
    }

    public Son getSon() {
        return son;
    }

    public void setSon(Son son) {
        this.son = son;
    }
}
