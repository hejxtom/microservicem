import com.atguigu.spring5.*;
import com.atguigu.spring5.aop.User;
import com.atguigu.spring5.config.ConfigAop;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Classname TestAop
 * @Description TODO
 * @Date 15:17 2021/3/29
 * @Created by hejx
 */

public class TestAop {
    @Test
    public void testUser1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user=context.getBean("user",User.class);
        user.add();

    }
    @Test
    public void testUser2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigAop.class);
        User user=context.getBean("user",User.class);
        user.add();

    }

}
