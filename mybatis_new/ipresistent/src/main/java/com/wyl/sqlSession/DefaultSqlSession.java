package com.wyl.sqlSession;

import com.wyl.executor.Executor;
import com.wyl.pojo.Configuration;
import com.wyl.pojo.MappedStatement;

import java.lang.reflect.*;
import java.util.List;

/**
 * @auther yanl.wang
 * @date 2023/2/13
 **/
public class DefaultSqlSession implements SqlSession{

    private Configuration configuration;
    private Executor executor;

    public DefaultSqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    @Override
    public <E> List<E> selectList(String statementId, Object param) throws Exception {
        // 将查询操作委派给底层的执行器
        //query():执行底层的JDBC 1。数据库配置信息 2。sql配置信息
        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementId);
        List<E> list = executor.query(configuration,mappedStatement,param);
        return list;
    }

    @Override
    public <T> T selectOne(String statementId, Object param) throws Exception {
        // 去调用selectList();
        List<Object> list = this.selectList(statementId, param);
        if (list.size()==1){
            return (T) list.get(0);
        }else if (list.size()>1){
            throw new RuntimeException("返回结果过多");
        }else {
            return null;
        }
    }

    @Override
    public void close() {
        executor.close();
    }

    @Override
    public <T> T getMapper(Class<?> mapperClass) {
        //使用JDK动态代理生成基于接口的代理对象
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {
                System.out.println("1111");
                //具体的逻辑:执行底层的JDBC
                //通过调用SqlSession里面的方法来完成方法的调用
                //参数的准备：1.statementId 2.param
                //问题1：无法获取现有的statementId
                String methodName = method.getName();// findAll
                System.out.println("methodName:"+methodName);
                //com.wyl.dao.IUserDao
                String className = method.getDeclaringClass().getName();
                String statementId = className+"."+methodName;

                // 方法调用 问题2：要调用sqlSession中增删改查的什么方法呢？
                // 改造当前工程：sqlCommandType
                MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementId);
                // select update delete insert
                String sqlCommandType = mappedStatement.getSqlCommandType();
                switch (sqlCommandType){
                    case "select":
                        //执行查询方法调用
                        //问题3：该调用selectList还是selectOne?
                        Type genericReturnType = method.getGenericReturnType();
                        // 判断是否实现了泛型类型参数化
                        if (genericReturnType instanceof ParameterizedType){
                            if (objects != null){
                                return selectList(statementId, objects[0]);
                            }
                            return selectList(statementId,null);
                        }
                        return selectOne(statementId,objects[0]);
                    case "update":
                        //执行更新方法调用
                        break;
                    case "delete":
                        //执行删除方法调用
                        break;
                    case "insert":
                        //执行插入方法调用
                        break;
                }

                return null;
            }
        };
        Object proxy = Proxy.newProxyInstance(DefaultSqlSession.class.getClassLoader(),new Class[]{mapperClass},handler);
        return (T) proxy;
    }
}
