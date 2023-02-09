import com.wyl.proxy.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sound.midi.Soundbank;

/**
 * @auther yanl.wang
 * @date 2023/2/8
 **/
public class TestProxy {

    /**
     * 测试：静态代理的代码
     */
    @Test
    public void test1(){
        UserService userService = new UserServiceProxy();
        userService.login("wyl","123456");
        userService.register(new User());

        System.out.println("================================");
        OrderService orderService = new OrderServiceProxy();
        orderService.showOrder();
    }

    /**
     * 测试：Spring动态代理
     */
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.login("wyl","123456");
        userService.register(new User());
    }

    /**
     * 测试：Spring动态代理实现 MethodInterceptor 接口
     */
    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext1.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.login("wyl","123456");
        userService.register(new User());
    }

}
