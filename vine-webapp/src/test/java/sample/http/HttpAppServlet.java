package sample.http.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vine.app.message.SampleMessage;
import vine.core.net.packet.PacketConst;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by liguofang on 2014/10/24.
 */
public class HttpAppServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(HttpAppServlet.class);
    private static final int BUFFER_SIZE = 1024;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log.debug("HttpAppServer 启动...");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String ip = req.getRemoteAddr();


       log.debug("packetHead:::" + req.getHeader(PacketConst.PACKET_HEAD));
       log.debug("appHead:::" + req.getHeader(PacketConst.APP_HEAD));
        //读取请求数据流
        byte[] buff = readContent(req);
        log.debug("buff:",buff.length);
        if (buff != null) {
            SampleMessage.CSTest csTest = null;
            csTest.parseFrom(buff);
            log.debug("Id=" + csTest.getId());
            log.debug("name=" + csTest.getName());
        }


    }


    /**
     * 读取消息包信息流
     * @param req
     * @return
     */
    private byte[] readContent(HttpServletRequest req) {
        try {
            InputStream is = req.getInputStream();
            int bufSize = req.getContentLength();//数据流长度
            log.debug("bufSize={}",bufSize);
            byte[] buffer = new byte[bufSize];
            int size = is.read(buffer);
            int readedSize = size;
            if (size != bufSize) {
                while(size >-1) {
                    size = is.read(buffer, readedSize,bufSize-readedSize);
                    readedSize += size;
                }
            }
            return buffer;
        } catch(Exception e) {
            log.error("读取Http请求数据流错误\n:{}",e);
            e.printStackTrace();
            return null;
        }
    }

}
