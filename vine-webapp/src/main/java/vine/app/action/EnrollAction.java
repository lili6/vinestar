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
import vine.core.net.packet.enums.RETCODE;
import vine.app.service.EnrollService;
import vine.core.net.action.clazz.Module;
import vine.core.net.action.clazz.RequestModule;
import vine.core.net.packet.HttpPacket;
import vine.core.net.session.UserSession;
import vine.core.utils.RandomUtil;
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
    /**
     * 注册接口
     * @param session
     * @param packet
     * @return
     * TODO 对接口的数据有效性进行验证，验证成功后，调用service进行数据库操作
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
            packet.setRetCode(RETCODE.MESSAGE_PARSE_ERROR);
            packet.setAppBody(null);
            return packet;
        }
        String checkCode = req.getCheckCode(); //  TODO对校验码的验证
        String mobileNo = req.getMobileNo();
        String email = req.getEmail();
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
        if(loginType!=0) {
            enrollService.enroll(userEnroll);
        }  else {
            log.debug("guest enroll，log guest..");
            //TODO 游客登录
        }
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
