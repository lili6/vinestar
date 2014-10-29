package vine.app.service;

import org.springframework.stereotype.Service;
import vine.app.dao.auto.EnrollDao;
import vine.app.dao.model.UserEnroll;

import javax.annotation.Resource;

/**
 * Created by liguofang on 2014/10/27.
 */
@Service
public class EnrollService {
    @Resource
    private EnrollDao enrollDao;

    /**
     * 用户登陆和注册
     * TODO mobile短信接口
     * TODO 用户ID生成规则，在集群环境下userid不允许重复
     * TODO 更新用户访问记录表
     * TODO email的邮件接口
     * TODO 更新用户访问记录表
     */
    public void enroll(UserEnroll userEnroll) {
        //1、根据手机号查询是否已经注册，如果有则直接按返回手机号已注册
        //2、判断密码是否正确，如果校验正确，则开始生成userId 写入数据库中。
        //3、写入成功后，将生成的UserEnroll返回给客户端
        enrollDao.insertEnroll(userEnroll);
    }

    /**
     * 根据userId获取password
     */
    public UserEnroll findEnrollByMobileNo(String mobileNo){
        return enrollDao.findEnrollByMobileNo(mobileNo);

    }
    /**
     * 根据userId更新Password
     */
    public void resetPasswordByUserId(String userId, String password){
//        UserEnroll user2 = new UserEnroll();
//        user2.setUserId(Integer.parseInt(userId));
//        user2.setPassword(password);
        enrollDao.resetPasswordByUserId(userId,password);

    }

}
