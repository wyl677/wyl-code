package com.wyl.executor;

import com.wyl.pojo.Configuration;
import com.wyl.pojo.MappedStatement;

import java.sql.SQLException;
import java.util.List;

/**
 * @auther yanl.wang
 * @date 2023/2/13
 **/
public interface Executor {
    <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object param) throws Exception;

    void close();
}
