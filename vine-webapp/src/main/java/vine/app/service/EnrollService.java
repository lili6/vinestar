package vine.app.service;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import vine.app.dao.auto.EnrollDao;
import vine.app.dao.model.UserEnroll;

import javax.annotation.Resource;

/**
 * Created by liguofang on 2014/10/27.
 */
@Service
public class EnrollService {
    private static final Logger log = LoggerFactory.getLogger(EnrollService.class);
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
    public int enroll(UserEnroll userEnroll) {
        //1、根据手机号查询是否已经注册，如果有则直接按返回手机号已注册
        //2、判断密码是否正确，如果校验正确，则开始生成userId 写入数据库中。
        //3、写入成功后，将生成的UserEnroll返回给客户端
        int ret = enrollDao.insertEnroll(userEnroll);
        log.debug("enroll ret={}" ,ret);
        log.debug("userId=[{}]",userEnroll.getUserId());
        return ret;
    }

    /**
     * 根据手机号查找用户注册信息
     * @return null 此号码没有注册
     *
     */
    public UserEnroll findEnrollByMobileNo(String mobileNo){
        UserEnroll userEnroll = enrollDao.findEnrollByMobileNo(mobileNo);
        if (log.isDebugEnabled()) { log.debug("findEnrollByMobileNo mobileNo=[{}] result:{}",mobileNo ,userEnroll);}

        return userEnroll;

    }

    /**
     * 根据邮箱号查找用户信息
     * @param email
     * @return null，此邮箱未注册，否则已注册
     */
    public UserEnroll findEnrollByEmail(String email) {
        UserEnroll userEnroll = enrollDao.findEnrollByEmail(email);
        if (log.isDebugEnabled()) {log.debug("findEnrollByEmail email=[{}] result: {}",email,userEnroll);}
        return userEnroll;
    }

    /**
     * 根据userId查找用户信息
     * @param userId
     * @return
     */
    public UserEnroll findEnrollByUserId(String userId) {
        UserEnroll userEnroll = enrollDao.findEnrollByUserId(userId);
        if (log.isDebugEnabled()) {log.debug("findEnrollByUserId userId=[{}] result: {}",userId,userEnroll);}
        return userEnroll;
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

    /**
     *  TODO 考虑下密码加密的情况
     * @param email
     * @param mobileNo
     * @param password
     * @return true 验证成功， false 验证失败
     */
    public boolean checkPassword(String email,String mobileNo, String password) {
        UserEnroll userEnroll =null;
        if (!email.equals("")) {
            userEnroll = this.findEnrollByEmail(email);
        }
        log.debug("userEnroll:[{}]",userEnroll);
        if (userEnroll == null && !password.equals("")) {
            userEnroll = this.findEnrollByMobileNo(mobileNo);
        }
        if (userEnroll ==null) {
            return false;
        }
        String pwd = userEnroll.getPassword();
        log.debug("req password=[{}],db password=[{}]", password, pwd);
        if (null != pwd && pwd.equals(password)) {
            return true;
        }
        return false;
    }

}
