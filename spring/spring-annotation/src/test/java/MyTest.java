import com.wyl.AppConfig;
import com.wyl.Appconfig1;
import com.wyl.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;

/**
 * @auther yanl.wang
 * @date 2023/2/19
 **/
public class MyTest {

    /**
     * 用于测试：配置Bean
     */
    @Test
    public void test1(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.wyl");
//        User user = (User) ctx.getBean("user");
//        System.out.println(user);

        Connection conn = ctx.getBean("conn1", Connection.class);
        System.out.println(conn);
    }

    /**
     * 用于测试：配置Bean JDK类型的数据注入解决耦合问题
     */
    @Test
    public void test2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig1.class);
        User user = (User) context.getBean("user");
        System.out.println(user);
    }
}
