package com.wyl.factorybean;

import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 * @auther yanl.wang
 * @date 2023/2/6
 * Spring  FactoryBean接口创建复杂对象
 **/
public class ConnectionFactoryBean implements FactoryBean<Connection> {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Connection getObject() throws Exception {
        //用于书写创建复杂对象的代码  com.mysql.cj.jdbc.Driver
        Class.forName(driverClassName);
        Connection conn = DriverManager.getConnection(url, username, password);//jdbc:mysql://192.168.83.2:3306/sunds
        return conn;
    }

    @Override
    public Class<?> getObjectType() {
        return Connection.class;
    }

    /**
     * true:单例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
