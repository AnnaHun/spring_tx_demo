package service;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Intellij IDEA.
 *
 * @author ZhuZhaoMing
 * @Description
 * @date 2021/8/30-9:25 下午
 * @motto: Never say die Never give up
 */
@Service
//@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)
public class UserService {

    @Autowired
    private UserDao userDao;

    //    转账
    public void accountMoney() {

//        try {
////        开启事务
//
////        进行业务操作
//
////        没有发生异常，提交事务
//        } catch (Exception e) {
////出现异常，事务回滚
//
//        }


//      lucy少100
        userDao.reduceMoney();
//      mary多100
        userDao.addMoney();

    }
}
