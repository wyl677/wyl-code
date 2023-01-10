package com.wyl.dao;

import com.wyl.domain.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @auther yanl.wang
 * @date 2022/7/24
 **/
public interface StudentDao {
    //查询一个学生
    Student selectStudentById(Integer id);
}
