package vine.app.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import vine.app.message.EnrollMessage;
import vine.app.message.HOpCodeEx;
import vine.core.net.HOpCode;
import vine.core.net.action.clazz.Module;
import vine.core.net.action.clazz.RequestModule;
import vine.core.net.http.HttpPacket;
import vine.core.net.session.UserSession;

/**
 * Created by liguofang on 2014/10/24.
 */
@Controller
@Module(100)
public class EnrollAction {
    private static final Logger log = LoggerFactory.getLogger(EnrollAction.class);

    /**
     * 注册接口
     * @param session
     * @param packet
     * @return
     */
    @RequestModule(value = HOpCodeEx.Enroll, needOnline = false)
    public HttpPacket enroll (UserSession session, HttpPacket packet) {
        log.debug("eroll begin...");

        log.debug("eroll request packet:{}",packet);

        String seqno = "first20141025001";

        EnrollMessage.EnrollRet.Builder builder = EnrollMessage.EnrollRet.newBuilder();
        builder.setUserId(seqno);
        builder.setToken("token0001");
        byte[] buff = builder.build().toByteArray();

        packet.setAppBody(buff);
        packet.getPacketHead().retCode = 0;

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
        return packet;
    }
}
