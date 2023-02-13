package com.wyl.sqlSession;

/**
 * @auther yanl.wang
 * @date 2023/2/12
 **/
public interface SqlSessionFactory {
    /**
     * 1.生产sqlSession对象  2.创建执行器对象
     * @return
     */
    SqlSession openSession();
}
