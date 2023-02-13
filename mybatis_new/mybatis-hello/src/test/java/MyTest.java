import com.wyl.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.parsing.GenericTokenParser;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @auther yanl.wang
 * @date 2023/2/9
 **/
public class MyTest {

    /**
     * 测试mybatis执行sql语句
     */
    @Test
    public void testSelectStudentById() throws IOException {
        String config = "mybatis/mybatis-config.xml";
        InputStream inputStream = MyTest.class.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        String sqlId = "com.wyl.dao.StudentDao"+"."+"selectStudentById";
        Student student = session.selectOne(sqlId,1003);
        System.out.println("111:"+student);
        session.close();
    }

    /**
     * 测试mybatis执行sql语句
     */
    @Test
    public void insertStudent() throws IOException {
        String config = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        String sqlId = "com.wyl.dao.StudentDao"+"."+"insertStudent";
        Student student = new Student();
        student.setId(1002);
        student.setName("王冰冰");
        student.setEmail("wangbingbing@qq.com");
        student.setAge(18);
        int insert = session.insert(sqlId,student);
        System.out.println("111:"+insert);
        session.commit();
        session.close();
    }
}
