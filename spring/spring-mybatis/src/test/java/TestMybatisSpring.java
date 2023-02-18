import com.wyl.dao.UserDao;
import com.wyl.entity.User;
import com.wyl.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @auther yanl.wang
 * @date 2023/2/16
 **/
public class TestMybatisSpring {

    /**
     * 用于测试：Spring与Mybatis的整合
     */
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        User user = new User();
        user.setId(4);
        user.setUsername("xiaowb");
        userDao.save(user);
        System.out.println(userDao);
    }

    /**
     * 用于测试：Spring的事务处理
     */
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");
        User user = new User();
        user.setId(9);
        user.setUsername("wangbd4");
        userService.register(user);
    }
}
