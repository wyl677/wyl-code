package com.wyl;

import com.wyl.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @auther yanl.wang
 * @date 2023/2/11
 **/
public class StarApp {
    public static void main(String[] args) throws IOException {
        //1.获取配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        //2.加载解析配置文件并获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.根据SqlSessionFactory对象获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.过程SqlSession中提供的API方法来操作数据库
        String sqlId = "com.wyl.dao.StudentDao"+"."+"selectStudentById";
        Student student = sqlSession.selectOne(sqlId,1001);
        System.out.println(student);
        sqlSession.close();



    }
}
