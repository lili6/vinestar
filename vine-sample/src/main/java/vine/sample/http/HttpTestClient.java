package vine.sample.http;



import org.apache.poi.util.IOUtils;
import vine.core.utils.StringUtil;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by liguofang on 2014/10/24.
 */
public class HttpTestClient {

    private static final String POST_URL = "http://localhost:8080/vineapp/server";

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
        connection.setRequestProperty("packetHead", "test");
        connection.setRequestProperty("appHead","test");

        connection.connect();
        try {
            OutputStream os = connection.getOutputStream();
//            byte tmp [] = Packet.packHttpResponse(packet, Packet.PacketType.PB);

            byte[] tmp = "I'm appBody".getBytes();
            System.out.println("buff===" + StringUtil.bytes2HexStr(tmp));
            os.write(tmp);
            os.flush();
            os.close();
            System.out.println("发送数据：\n"+  new String(tmp,"UTF-8"));

            byte retTmp [] = IOUtils.toByteArray(connection.getInputStream());
            System.out.println("返回数据:\n" + new String(retTmp));

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
