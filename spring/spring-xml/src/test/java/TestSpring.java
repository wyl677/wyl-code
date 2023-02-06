import com.wyl.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @auther yanl.wang
 * @date 2023/2/6
 **/
public class TestSpring {

    @Test
    public void test1(){
        //1.获得Spring的工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");

        //2.通过工厂获得对象
        Person person = (Person) context.getBean("person");
        System.out.println(person);
    }
}
