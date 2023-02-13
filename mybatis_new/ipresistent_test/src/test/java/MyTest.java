import com.wyl.dao.IUserDao;
import com.wyl.io.Resources;
import com.wyl.pojo.User;
import com.wyl.sqlSession.SqlSession;
import com.wyl.sqlSession.SqlSessionFactory;
import com.wyl.sqlSession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @auther yanl.wang
 * @date 2023/2/12
 **/
public class MyTest {

    @Test
    public void test1() throws Exception {
        //1.根据配置文件路径，加载成字节输入流，存到内存中 注意：配置文件还未解析
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        System.out.println(resourceAsSteam);
        //2.解析了配置文件，封装类Configuration对象 2。创建sqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);

        //3.生产sqlSession 创建了执行器对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4.调用sqlSession方法
        User user = new User();
        user.setId(1);
        user.setUsername("tom");
//        User user2 = sqlSession.selectOne("user.selectOne",user);
//        System.out.println(user2);

        List<Object> objects = sqlSession.selectList("user.selectList", null);
        System.out.println(objects);

        //5.释放资源
        sqlSession.close();
    }

    /**
     * mapper代理方式测试
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        //1.根据配置文件路径，加载成字节输入流，存到内存中 注意：配置文件还未解析
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        System.out.println(resourceAsSteam);
        //2.解析了配置文件，封装类Configuration对象 2。创建sqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);

        //3.生产sqlSession 创建了执行器对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4.调用sqlSession方法
        IUserDao userDaoProxy = sqlSession.getMapper(IUserDao.class);
//        List<User> all = userDaoProxy.findAll();
//        for (User user : all) {
//            System.out.println(user);
//        }

        User user = new User();
        user.setId(1);
        user.setUsername("tom");
        User user1 = userDaoProxy.selectOne(user);
        System.out.println(user1);

        //5.释放资源
        sqlSession.close();
    }
}
