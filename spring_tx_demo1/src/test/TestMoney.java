package test;

import config.TxConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import service.UserService;

import java.lang.management.PlatformLoggingMXBean;

/**
 * Created by Intellij IDEA.
 *
 * @author ZhuZhaoMing
 * @Description
 * @date 2021/8/30-9:41 下午
 * @motto: Never say die Never give up
 */
public class TestMoney {

    @Test
    public void testAccount() {


        ApplicationContext context = new ClassPathXmlApplicationContext("resource/bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    @Test
    public void testAccount2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("resource/bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    @Test
    public void testAccount3() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    @Test
    public void testGenericApplicationContext() {
//        创建GeneracApplicationContext
        GenericApplicationContext context = new GenericApplicationContext();
//        调用context的方法对象注册
        context.refresh();
        context.registerBean(User.class, () -> new User());
//        获取在spring注册的对象
        Object user = context.getBean("test.User");
        System.out.println(user);

    }
}
