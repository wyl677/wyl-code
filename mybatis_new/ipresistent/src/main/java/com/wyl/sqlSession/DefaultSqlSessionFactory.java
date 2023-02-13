package com.wyl.sqlSession;

import com.wyl.executor.Executor;
import com.wyl.executor.SimpleExecutor;
import com.wyl.pojo.Configuration;

/**
 * @auther yanl.wang
 * @date 2023/2/13
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        //1.创建执行器对象
        Executor simpleExecutor = new SimpleExecutor();

        //2.生产sqlSession对象
        DefaultSqlSession defaultSqlSession = new DefaultSqlSession(configuration,simpleExecutor);
        return defaultSqlSession;
    }
}
