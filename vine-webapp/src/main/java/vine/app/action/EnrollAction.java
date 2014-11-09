package vine.app.action;

import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import vine.app.dao.model.User;
import vine.app.dao.model.UserEnroll;
import vine.app.factory.AppBeanFactory;
import vine.app.message.EnrollMessage;
import vine.app.message.EnrollMessage.Enroll;
import vine.app.message.HOpCodeEx;
import vine.common.cache.UserLoginCache;
import vine.common.constant.MessageResult;
import vine.common.constant.SessionAttributeKey;
import vine.core.net.packet.enums.RETCODE;
import vine.app.service.EnrollService;
import vine.core.net.action.clazz.Module;
import vine.core.net.action.clazz.RequestModule;
import vine.core.net.packet.HttpPacket;
import vine.core.net.session.UserSession;
import vine.core.utils.RandomValidateCode;
import vine.core.utils.TokenUtil;
import vine.core.utils.UUIDGenerator;

/**
 * Created by liguofang on 2014/10/24.
 */
@Controller
@Module(100)
public class EnrollAction {
    private static final Logger log = LoggerFactory.getLogger(EnrollAction.class);
    EnrollService enrollService=AppBeanFactory.getEnrollService();

    @RequestModule(value = HOpCodeEx.GetValidateCode, needOnline = false)
    public HttpPacket getValidateCode (UserSession session, HttpPacket packet) {
        log.debug("getValidateCode begin...");
        String validateCode = RandomValidateCode.getRandomString();
        session.setAttribute(SessionAttributeKey.RANDOM_CODE_KEY,validateCode);
        try {
            EnrollMessage.GetValidateCode.Builder builder = EnrollMessage.GetValidateCode.newBuilder();
            builder.setValidateCode(validateCode);
            byte[] buff = builder.build().toByteArray();
            packet.packResponse(MessageResult.SUCCESS,buff);
        } catch (Exception e) {
            //解析请求数据错误。。TODO
            log.error("packetId[{}] request message parse error:{}",packet.getPacketId(),e);
            e.printStackTrace();
            packet.packResponse(MessageResult.EXCEPTION,null);
            return packet;
        }
        log.debug("getValidateCode response packet:{}",packet);
        return packet;
    }

    /**
     * 注册接口
     * @param session
     * @param packet
     * @return
     * TODO 对接口的数据有效性进行验证，验证成功后，调用service进行数据库操作
     * 手机号和mobile的合法性要进行验证
     * 如果是注册，判断手机号或者email是否存在，如果存在则返回提示用户已注册
     */
    @RequestModule(value = HOpCodeEx.Enroll, needOnline = false)
    public HttpPacket enroll (UserSession session, HttpPacket packet) {
        log.debug("eroll[{}] begin...",packet.getPacketId());
        log.debug("eroll request packet:{}",packet);
        //接口数据验证
        Enroll req =null;
        try {
            req = Enroll.parseFrom(packet.getAppBody());
        } catch (InvalidProtocolBufferException e) {
            //解析请求数据错误。。TODO
            log.error("packetId[{}] request message parse error:{}",packet.getPacketId(),e);
            e.printStackTrace();
            packet.packResponse(MessageResult.MESSAGE_PARSE_ERROR,null);
            return packet;
        }
        String userId = packet.getAppHead().userId;
        EnrollMessage.LoginType loginType = req.getLoginType();
        log.debug("用户登录类别=[{}]",loginType);
        if (EnrollMessage.LoginType.GUEST == loginType) {
            log.debug("游客浏览");
            //TODO 记录游客浏览日志记录，直接返回
            packet.packResponse(MessageResult.SUCCESS,null);
            return packet;
        } else if (EnrollMessage.LoginType.LOGIN== loginType) {
            log.debug("用户登录");
            //TODO 需要进行密码验证，且在日志表中更新用户登陆记录
            log.debug("enroll[{}] checkPassword...userId=[{}],passwod=[{}]",packet.getPacketId(),userId,req.getPassword());
            //根据邮箱号或者手机号，为主键判断密码是否正确。
//            UserEnroll user = enrollService.findEnrollByUserId(userId);
//            log.debug("user={}",user);

            if (enrollService.checkPassword(req.getEmail(),req.getMobileNo(),req.getPassword())) {
                //设置token，并返回给客户端
                String token = TokenUtil.generateToken(userId + packet.getPacketHead().stamp);
                log.debug("LOGIN TOKEN=[{}]",token);
                UserLoginCache.setToken(token);
                packet.getAppHead().token = token;
                packet.packResponse(MessageResult.SUCCESS,null);
                return packet;
            } else {
                log.error("password is not correct!!! please login again!!");
                packet.packResponse(MessageResult.ENROLL_PASSWORD_ERROR,null);
                return packet;
            }
        } else if (EnrollMessage.LoginType.ENROLL == loginType) {
            log.debug("用户注册！");
        }

        //1、TODO 对校验码的验证,放在客户端进行验证，服务器不再进行验证
        String checkCode = req.getCheckCode();
        log.debug("request checkCode=[{}]",checkCode);
        log.debug("request validateCode=[{}]",session.getAttribute(SessionAttributeKey.RANDOM_CODE_KEY));
        //2、对手机号或者邮箱号的唯一性验证
        String mobileNo = req.getMobileNo();
        String email = req.getEmail();
        if (mobileNo.equals("") && email.equals("")) {
            log.error("mobileNo or email must input!!!");
            packet.packResponse(MessageResult.ENROLL_EMAIL_OR_MOBILE_EMPTY,null);
            return packet;
        }
        if (!mobileNo.equals("") && enrollService.findEnrollByMobileNo(mobileNo)!=null) {
            log.error("mobileNo already exist!!!");
            packet.packResponse(MessageResult.ENROLL_MOBILE_EXIST,null);
            return packet;
        } else if (!email.equals("")  && enrollService.findEnrollByEmail(email) != null) {
            log.error("email already exist!!!");
            packet.packResponse(MessageResult.ENROLL_EMAIL_EXIST,null);
            return packet;
        }
        String password = req.getPassword();
        UserEnroll userEnroll = new UserEnroll();
        userEnroll.setMobileNo(mobileNo);
        userEnroll.setEmail(email);
        userEnroll.setPassword(password);
        userEnroll.setCreator("admin");
        userId = UUIDGenerator.getUUID();
        userEnroll.setUserId(userId);
        enrollService.enroll(userEnroll);
        long seqno = userEnroll.getSeqno();
//        EnrollRet.Builder builder = EnrollRet.newBuilder();
//        builder.setUserId(String.valueOf(userId));
        String token = TokenUtil.generateToken(userId +packet.getPacketHead().stamp);
        //将token放到缓存中，以后每次用户交互都要进行token的验证。
        UserLoginCache.setToken(token);
//        builder.setToken(token);
//        byte[] buff = builder.build().toByteArray();
        packet.getAppHead().token = token;
        packet.getAppHead().userId = userId;
        packet.packResponse(MessageResult.SUCCESS,null);
        if (log.isDebugEnabled())
            log.debug("enroll[{}], \n response packet:{}",packet.getPacketId(),packet);
        return packet;
    }


    /**
     * 注销用户
     * @param session
     * @param packet
     * @return
     */
    @RequestModule(value = HOpCodeEx.Logout, needOnline = false)
    public HttpPacket logout (UserSession session, HttpPacket packet) {
        log.debug("logout begin...");
        log.debug("logout request packet:{}",packet);
        packet.setStamp();
        packet.setAppBody(null);
        log.debug("logout do nothing now, need to be done....");
        //TODO 记录用户访问信息表，并将用户状态置为非活跃状态
        return packet;
    }
    /**
     * 忘记密码
     * @param session
     * @param packet
     * @return
     */
    @RequestModule(value = HOpCodeEx.ForgetPassword, needOnline = false)
    public HttpPacket forgetPassword (UserSession session, HttpPacket packet) {
        //TODO 输入数据为手机号或者email，后台进行验证
        log.debug("forgetPassword begin...");
        log.debug("forgetPassword request packet:{}",packet);
        packet.setStamp();
        packet.setAppBody(null);
        log.debug("forgetPassword do nothing now, need to be done....");
        //TODO 记录用户访问信息表，并将用户状态置为非活跃状态
        return packet;
    }

    /**
     * 重置密码，测试时将密码置为6个0
     * @param session
     * @param packet
     * @return
     * TODO TOKEN 验证
     * TODO 旧密码验证成功后，才能重置新密码
     */
    @RequestModule(value = HOpCodeEx.ResetPassword, needOnline = false)
    public HttpPacket resetPassword(UserSession session, HttpPacket packet) {
        log.debug("resetPassword begin...");

        log.debug("resetPassword request packet:{}",packet);
        try {
            EnrollMessage.ResetPassword req = EnrollMessage.ResetPassword.parseFrom(packet.getAppBody());
            String userId = req.getUserId();
            String oldPwd = req.getOldPassword();
            String newPwd = req.getNewPassword();

            enrollService.resetPasswordByUserId(userId, newPwd);
        } catch (Exception e) {
            log.debug("resetPassword action exception:",e);
            packet.packResponse(MessageResult.EXCEPTION,null);
            e.printStackTrace();
            return packet;
        }

        packet.packResponse(MessageResult.SUCCESS,null);
        log.debug("resetPassword action execute successful...");
        log.debug("resetPassword response packet:{}",packet);
        //TODO 输入数据为手机号或者email，后台进行验证
        return packet;
    }
    /**
     * 用户信息维护
     * @param session
     * @param packet
     * @return
     */
    @RequestModule(value = HOpCodeEx.UserInfoEdit, needOnline = false)
    public HttpPacket userInfoEdit (UserSession session, HttpPacket packet) {
        //TODO 用户信息维护 优先级低 later
        log.debug("userInfoEdit begin...");
        log.debug("userInfoEdit request packet:{}",packet);
        packet.setStamp();
        packet.setAppBody(null);
        log.debug("userInfoEdit do nothing now, need to be done....");
        return packet;
    }
}
