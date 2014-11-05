package sample.enroll;

import com.alibaba.fastjson.JSONObject;
import com.google.protobuf.InvalidProtocolBufferException;
import org.apache.poi.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vine.app.message.EnrollMessage;
import vine.app.message.HOpCodeEx;
import vine.app.message.SampleMessage;
import vine.core.net.packet.HttpPacket;
import vine.core.net.packet.PacketConst;
import vine.core.utils.RandomUtil;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 注册客户端
 */
public class EnrollClient {
    private static final Logger log = LoggerFactory.getLogger(EnrollClient.class);
	private static final String POST_URL = "http://localhost:8081/vineapp/server";
//    private static final String POST_URL = "http://vstar.meibu.net:80/vineapp/server";
    private static String checkCode;
	
	private static byte[] sendPacket(String packetHead,String appHead,byte[] buff) {
        try {
            URL postUrl = new URL(POST_URL);
            //打开链接
            HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);//Post请求不能使用缓存
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty(PacketConst.HTTP_KEY_PACKETHEAD,packetHead);
            connection.setRequestProperty(PacketConst.HTTP_KEY_APPHEAD,appHead);
            connection.connect();

			OutputStream os = connection.getOutputStream();
            if (buff != null) { //为null时，不需要写入
                byte tmp[] = buff;
                os.write(tmp);
            }
            os.flush();
            os.close();
			byte retTmp [] = IOUtils.toByteArray(connection.getInputStream());
            log.debug("=============Response==================");
            System.out.println("Packet head :" + connection.getHeaderField(PacketConst.HTTP_KEY_PACKETHEAD));
            System.out.println("App head :" + connection.getHeaderField(PacketConst.HTTP_KEY_APPHEAD));
			connection.disconnect();
            return retTmp;
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
	}

    private static void resetPassword() throws InvalidProtocolBufferException {
        int packetId = HOpCodeEx.ResetPassword;
        JSONObject ph = new JSONObject();
        ph.put(PacketConst.PACKET_KEY_PACKET_ID,packetId);
        ph.put(PacketConst.PACKET_KEY_STAMP,System.currentTimeMillis());

        JSONObject ap = new JSONObject();
        ap.put(PacketConst.APP_KEY_CHANNELID,"02");
        ap.put(PacketConst.APP_KEY_SERVERID,"10");

        EnrollMessage.ResetPassword.Builder enroll = EnrollMessage.ResetPassword.newBuilder();
        enroll.setUserId("6d4120c9047f41f8a7517b7f81a4bb6e");
        enroll.setNewPassword("000000");
        byte[] buff = enroll.build().toByteArray();
        byte[] retTmp = sendPacket(ph.toJSONString(),ap.toJSONString(),buff);

//        EnrollMessage.EnrollRet retPacket = EnrollMessage.EnrollRet.parseFrom(retTmp);
//        log.debug("resetPassword response:userId:[{}]" , retPacket.getUserId());
                log.debug("resetPassword--end!");
    }

    private static  void login() throws InvalidProtocolBufferException {
        int packetId = HOpCodeEx.Enroll;
        JSONObject ph = new JSONObject();
        ph.put(PacketConst.PACKET_KEY_PACKET_ID,packetId);
        ph.put(PacketConst.PACKET_KEY_STAMP,System.currentTimeMillis());

        JSONObject ap = new JSONObject();
        ap.put(PacketConst.APP_KEY_CHANNELID,"09");
        ap.put(PacketConst.APP_KEY_SERVERID,"12");
        ap.put(PacketConst.APP_KEY_USERID,"67cb796f61794f76a2751f9a3fd88545");
        String packetHead =  ph.toJSONString();
        String appHead = ap.toJSONString();
        EnrollMessage.Enroll.Builder enroll = EnrollMessage.Enroll.newBuilder();
//        enroll.setMobileNo(String.valueOf(RandomUtil.nextInt(1856987478)));
        enroll.setMobileNo("13096936483");
//        enroll.setEmail("chengfei@qq.com");
//        getValidateCode();
//        enroll.setCheckCode(checkCode);
        enroll.setPassword("111111");
        enroll.setLoginType(EnrollMessage.LoginType.LOGIN);
//        enroll.setLoginType(EnrollMessage.LoginType.LOGIN);
        byte[] buff = enroll.build().toByteArray();
        byte[] retTmp = sendPacket(packetHead,appHead,buff);
        log.debug("enroll--[login] end!");
//        EnrollMessage.EnrollRet retPacket = EnrollMessage.EnrollRet.parseFrom(retTmp);
//        log.debug("enroll response:userId:[{}],token:[{}]" , retPacket.getUserId(),retPacket.getToken());
    }
    /**
     * 新用户注册
     * 邮箱名和手机号不能重复
     * @throws InvalidProtocolBufferException
     */
    private static void enroll()throws InvalidProtocolBufferException {
        int packetId = HOpCodeEx.Enroll;
        JSONObject ph = new JSONObject();
        ph.put(PacketConst.PACKET_KEY_PACKET_ID,packetId);
        ph.put(PacketConst.PACKET_KEY_STAMP,System.currentTimeMillis());

        JSONObject ap = new JSONObject();
        ap.put(PacketConst.APP_KEY_CHANNELID,"09");
        ap.put(PacketConst.APP_KEY_SERVERID,"12");
        String packetHead =  ph.toJSONString();//"{ \"name\": \"hello\", \"packetId\":" +packetId+" }";
        String appHead = ap.toJSONString();//"{ \"name\": \"hello\"}";
        EnrollMessage.Enroll.Builder enroll = EnrollMessage.Enroll.newBuilder();
//        enroll.setMobileNo(String.valueOf(RandomUtil.nextInt(1856987478)));
        enroll.setMobileNo("13096936485");
//        enroll.setEmail("guofang@qq.com");
//        getValidateCode();
//        enroll.setCheckCode(checkCode);
        enroll.setPassword(String.valueOf(RandomUtil.nextInt(100000)));
//        enroll.setLoginType(1);
        enroll.setLoginType(EnrollMessage.LoginType.ENROLL);
        byte[] buff = enroll.build().toByteArray();
        byte[] retTmp = sendPacket(packetHead,appHead,buff);

        log.debug("enroll end!");
    }

    private static void getValidateCode() throws InvalidProtocolBufferException {
        int packetId = HOpCodeEx.GetValidateCode;
        JSONObject ph = new JSONObject();
        ph.put(PacketConst.PACKET_KEY_PACKET_ID,packetId);
        ph.put(PacketConst.PACKET_KEY_STAMP,System.currentTimeMillis());
        JSONObject ap = new JSONObject();
        ap.put(PacketConst.APP_KEY_CHANNELID,"09");
        ap.put(PacketConst.APP_KEY_SERVERID,"12");
        byte[] retTmp = sendPacket(ph.toJSONString(),ap.toJSONString(),null);
        EnrollMessage.GetValidateCode retPacket =EnrollMessage.GetValidateCode.parseFrom(retTmp);
        checkCode = retPacket.getValidateCode();
        log.debug("getValidateCode, response:[{}]",retPacket);
    }

	 public static void main(String args[]){
		try {
            login();
//            resetPassword();
            getValidateCode();
            enroll();

        } catch (Exception e) {
			e.printStackTrace();
		}
	 }
}
