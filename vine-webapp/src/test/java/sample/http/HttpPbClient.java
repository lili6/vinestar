package sample.http;

import org.apache.poi.util.IOUtils;
import vine.app.message.SampleMessage;
import vine.core.net.packet.PacketConst;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpPbClient {
	private static final String POST_URL = "http://localhost:8081/vineapp/server";
	
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
        //公共部分的报文头,传递的是json字符串
        connection.setRequestProperty(PacketConst.HTTP_KEY_PACKETHEAD, "{ \"name\": \"hello\", \"packetId\": 901 }");
        connection.setRequestProperty(PacketConst.HTTP_KEY_APPHEAD,"{ \"name\": \"hello\"}");
		connection.connect();
		
		
		SampleMessage.CSTest.Builder csTestB = SampleMessage.CSTest.newBuilder();
		csTestB.setId(100);
		csTestB.setName("quebu");
		csTestB.setContent("HelloWorld");
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
            byte tmp[] = csTestB.build().toByteArray();
			os.write(tmp);
			os.flush();
			os.close();
			System.out.println("发送数据：\n"+ csTestB.build());
			
			byte retTmp [] = IOUtils.toByteArray(connection.getInputStream());
			/*
            PbPacket retPacket = (PbPacket) Packet.parseHttpRequest(retTmp, Packet.PacketType.PB);
			SampleMessage.SCTestRet ret = SampleMessage.SCTestRet.parseFrom(retPacket.getData());

			System.out.println("SCTestRet:\n" + ret);
			*/
            System.out.println("SCTestRet:\n" + new String(retTmp));
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
