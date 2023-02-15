import com.wyl.bean.Person;
import com.wyl.bean.Student;
import com.wyl.beanpost.Categroy;
import com.wyl.factorybean.ConnectionFactoryBean;
import com.wyl.life.Product;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

/**
 * @auther yanl.wang
 * @date 2023/2/6
 * 测试
 **/
public class TestSpring {

    @Test
    public void test1(){
        //1.获得Spring的工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");

        //2.通过工厂获得对象
        Person person = (Person) context.getBean("person");
        System.out.println(person);

        Student stu = context.getBean("stu", Student.class);
        System.out.println(stu);
    }

    /**
     * 测试FactoryBean创建复杂对象
     */
    @Test
    public void test2(){
        //1.获得Spring的工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");

        //2.通过工厂获得对象
        Connection conn = context.getBean("conn", Connection.class);

        System.out.println(conn);

        //加 & 符号 获取ConnectionFactoryBean的对象
        ConnectionFactoryBean bean = context.getBean("&conn", ConnectionFactoryBean.class);
        System.out.println(bean);

    }

    /**
     * 测试实例工厂创建复杂对象
     */
    @Test
    public void test3(){
        //1.获得Spring的工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");

        //2.通过工厂获得对象
        Connection conn = context.getBean("conn2", Connection.class);
        System.out.println(conn);
    }

    /**
     * 测试静态工厂创建复杂对象
     */
    @Test
    public void test4(){
        //1.获得Spring的工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");

        //2.通过工厂获得对象
        Connection conn = context.getBean("conn3", Connection.class);
        System.out.println(conn);
    }

    /**
     * 测试生命周期
     */
    @Test
    public void test5(){
        //1.获得Spring的工厂
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
//        context.getBean("product", Product.class);
        context.close();
    }

    /**
     * 测试配置文件参数化
     */
    @Test
    public void test6(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext1.xml");
        Connection conn = context.getBean("conn", Connection.class);
        System.out.println(conn);
    }

    /**
     * 测试自定义类型转换器
     */
    @Test
    public void test7(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext2.xml");
        com.wyl.converter.Student stu = context.getBean("stu", com.wyl.converter.Student.class);
        System.out.println(stu);
    }

    /**
     * 测试BeanPostProcessor
     */
    @Test
    public void test8(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext3.xml");
        Categroy c = context.getBean("c", Categroy.class);
        System.out.println(c);
    }

}
