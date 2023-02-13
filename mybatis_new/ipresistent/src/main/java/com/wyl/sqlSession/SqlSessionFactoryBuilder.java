package com.wyl.sqlSession;

import com.wyl.config.XMLConfigBuilder;
import com.wyl.pojo.Configuration;
import org.dom4j.DocumentException;

import java.io.InputStream;

/**
 * @auther yanl.wang
 * @date 2023/2/12
 **/
public class SqlSessionFactoryBuilder {

    /**
     * 1.解析配置文件，封装容器对象
     * 2.创建SqlSessionFactory工厂
     * @param inputStream
     * @return
     */
    public SqlSessionFactory build(InputStream inputStream) throws DocumentException {

        //1.解析配置文件，封装容器对象 XMLConfigBuilder：专门解析核心配置文件的解析类
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parse(inputStream);

        //2.创建SqlSessionFactory工厂对象
        DefaultSqlSessionFactory defaultSqlSessionFactory = new DefaultSqlSessionFactory(configuration);
        return defaultSqlSessionFactory;
    }
}
