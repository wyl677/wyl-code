package com.wyl.dao;

import com.wyl.pojo.User;

import java.util.List;

/**
 * @auther yanl.wang
 * @date 2023/2/13
 **/
public interface IUserDao {

    List<User> findAll() throws Exception;

    User selectOne(User user) throws Exception;
}
