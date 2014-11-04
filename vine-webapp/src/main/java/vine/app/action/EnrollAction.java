package vine.app.action;

import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import vine.app.dao.model.UserEnroll;
import vine.app.factory.AppBeanFactory;
import vine.app.message.EnrollMessage;
import vine.app.message.EnrollMessage.Enroll;
import vine.app.message.EnrollMessage.EnrollRet;
import vine.app.message.HOpCodeEx;
import vine.common.constant.SessionAttributeKey;
import vine.core.net.packet.enums.RETCODE;
import vine.app.service.EnrollService;
import vine.core.net.action.clazz.Module;
import vine.core.net.action.clazz.RequestModule;
import vine.core.net.packet.HttpPacket;
import vine.core.net.session.UserSession;
import vine.core.utils.RandomUtil;
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
            packet.setAppBody(buff);
            packet.setRetCode(RETCODE.SUCCESS);
            packet.setStamp();
        } catch (Exception e) {
            //解析请求数据错误。。TODO
            log.error("packetId[{}] request message parse error:{}",packet.getPacketId(),e);
            e.printStackTrace();
            packet.setRetCode(RETCODE.MESSAGE_PARSE_ERROR);
            packet.setAppBody(null);
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
        log.debug("eroll begin...");
        log.debug("eroll request packet:{}",packet);
        //接口数据验证
        Enroll req =null;
        try {
            req = Enroll.parseFrom(packet.getAppBody());
        } catch (InvalidProtocolBufferException e) {
            //解析请求数据错误。。TODO
            log.error("packetId[{}] request message parse error:{}",packet.getPacketId(),e);
            e.printStackTrace();
            packet.setRetCode(RETCODE.MESSAGE_PARSE_ERROR);
            packet.setAppBody(null);
            return packet;
        }
        //1、对校验码的验证
        String checkCode = req.getCheckCode();
        if (!checkCode.equalsIgnoreCase((String)session.getAttribute(SessionAttributeKey.RANDOM_CODE_KEY))) {
            packet.setRetCode(RETCODE.VALIDATECODE_ERROR);
            packet.setAppBody(null);
            packet.setStamp();
            return packet;
        }
        //2、对手机号或者邮箱号的唯一性验证
        String mobileNo = req.getMobileNo();
        if (null == mobileNo || mobileNo.equals("") ||!enrollService.mobileNoExist(mobileNo)) {
                //TODO 手机号存在
        }

        String email = req.getEmail();

        if (null == email || email.equals("") || enrollService.emailExist(email)) {
            //TODO 手机号存在
        }


        String password = req.getPassword();
        Integer loginType = req.getLoginType();
        UserEnroll userEnroll = new UserEnroll();
        userEnroll.setMobileNo(mobileNo);
        userEnroll.setEmail(email);
        userEnroll.setPassword(password);
        userEnroll.setCreator("admin");
//        int userId = RandomUtil.nextInt(9999); 
        String userId = UUIDGenerator.getUUID();
        userEnroll.setUserId(userId);
        enrollService.enroll(userEnroll);
        /*if(loginType!=0) {
            enrollService.enroll(userEnroll);
        }  else {
            log.debug("guest enroll，log guest..");
            //TODO 游客登录
        }*/
        long seqno = userEnroll.getSeqno();
        EnrollRet.Builder builder = EnrollRet.newBuilder();
        builder.setUserId(String.valueOf(userId));
        builder.setToken(TokenUtil.generateToken(seqno+userId +packet.getPacketHead().stamp));
        //TODO 将token放到session中，以后每次用户交互都要进行token的验证。
        byte[] buff = builder.build().toByteArray();
        packet.setAppBody(buff);
        packet.setRetCode(RETCODE.SUCCESS);
        packet.setStamp();
        log.debug("eroll response packet:{}",packet);
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
            packet.setRetCode(RETCODE.FAILED);
            e.printStackTrace();
            //TODO 做错误处理
            return packet;
        }
        packet.setRetCode(RETCODE.SUCCESS);
        packet.setStamp();
        packet.setAppBody(null);
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
