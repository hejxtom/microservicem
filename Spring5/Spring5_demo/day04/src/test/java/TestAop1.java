
import com.atguigu.spring5.aop1.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Classname TestAop1
 * @Description TODO
 * @Date 15:55 2021/3/29
 * @Created by hejx
 */

public class TestAop1 {
    @Test
    public void testUser1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user=context.getBean("user",User.class);
        user.add();

    }
}
