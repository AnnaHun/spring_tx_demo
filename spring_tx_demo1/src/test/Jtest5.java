package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import service.UserService;

/**
 * Created by Intellij IDEA.
 *
 * @author ZhuZhaoMing
 * @Description
 * @date 2021/8/31-2:40 下午
 * @motto: Never say die Never give up
 */
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:resource/bean1.xml")
@SpringJUnitConfig(locations = "classpath:resource/bean1.xml")
public class Jtest5 {
    @Autowired
    private UserService userService;

    @Test
    public void test1() {
        userService.accountMoney();
    }
}
