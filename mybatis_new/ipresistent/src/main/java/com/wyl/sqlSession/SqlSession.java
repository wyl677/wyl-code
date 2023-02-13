package com.wyl.sqlSession;

import java.util.List;

/**
 * @auther yanl.wang
 * @date 2023/2/13
 **/
public interface SqlSession {

    /**
     * 查询多个结果
     * @return
     * E 泛型Element
     */
    <E> List<E> selectList(String statementId,Object param) throws Exception;

    /**
     * 查询单个结果对应的方法
     * T Type类型未知，无法确定用T
     */
    <T> T selectOne(String statementId,Object param) throws Exception;

    /**
     * 清除资源
     */
    void close();

    /**
     * 生产代理对象
     */
    <T> T getMapper(Class<?> mapperClass);


}
