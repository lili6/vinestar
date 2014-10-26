package sample.enroll;

import org.apache.poi.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vine.app.message.EnrollMessage;
import vine.app.message.HOpCodeEx;
import vine.app.message.SampleMessage;
import vine.core.net.packet.PacketConst;

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
	
	private static void sendPbPacket() throws Exception{
		URL postUrl = new URL(POST_URL);
		//打开链接
		HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
		
		connection.setRequestMethod("POST");
		
		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setUseCaches(false);//Post请求不能使用缓存
		connection.setInstanceFollowRedirects(true);
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        int packetId = HOpCodeEx.Enroll;
        connection.setRequestProperty(PacketConst.HTTP_KEY_PACKETHEAD, "{ \"name\": \"hello\", \"packetId\":" +packetId+" }");
        connection.setRequestProperty(PacketConst.HTTP_KEY_APPHEAD,"{ \"name\": \"hello\"}");
		connection.connect();
		
		
		EnrollMessage.Enroll.Builder enroll = EnrollMessage.Enroll.newBuilder();
        enroll.setMobileNo("13096936482");
        enroll.setEmail("34793278@qq.com");
        enroll.setCheckCode("TESTCode");
        enroll.setPassword("passwordXX");

		/*
		PbPacket packet = new PbPacket();
		packet.setPacketId(HOpCodeEx.CSTest);
		packet.setFlag(1);
		packet.setRetCode(PacketConst.RETCODE_SUCCESS); //必须为0
		packet.setStamp(System.currentTimeMillis());
		packet.setData(csTestB.build().toByteArray());
		*/
		try {
			OutputStream os = connection.getOutputStream();
//			byte tmp [] = Packet.packHttpResponse(packet, Packet.PacketType.PB);
            byte tmp[] = enroll.build().toByteArray();
			os.write(tmp);
			os.flush();
			os.close();
			System.out.println("发送数据：\n"+ enroll.build());
			
			byte retTmp [] = IOUtils.toByteArray(connection.getInputStream());

            EnrollMessage.EnrollRet retPacket = EnrollMessage.EnrollRet.parseFrom(retTmp);
//            SampleMessage.SCTestRet ret = SampleMessage.SCTestRet.parseFrom(retPacket.getData());
            log.debug("=============Response==================");
            System.out.println("Packet head :" + connection.getHeaderField(PacketConst.HTTP_KEY_PACKETHEAD));
            System.out.println("App head :" + connection.getHeaderField(PacketConst.HTTP_KEY_APPHEAD));
			System.out.println("SCTestRet:\n" + retPacket.getUserId());


//            System.out.println("EnrollRet:\n" + new String(retTmp));
			connection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	 public static void main(String args[]){
		try {
			sendPbPacket();
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
}
