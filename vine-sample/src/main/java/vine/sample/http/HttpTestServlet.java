package vine.sample.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vine.core.utils.StringUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by liguofang on 2014/10/24.
 */
public class HttpTestServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(HttpTestServlet.class);
    private static final int BUFFER_SIZE = 1024;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String ip = req.getRemoteAddr();
        System.out.println("map size :" + req.getParameterMap().size());

        System.out.println ("packetHead:::: " + req.getHeader("packetHead"));
        System.out.println("appHead::::" + req.getHeader("appHead"));

        //读取请求数据流
        byte[] buff = readContent(req);
        System.out.println("buff===" + StringUtil.bytes2HexStr(buff));
        if (buff != null) {
            System.out.println("appBody:::" + new String(buff,"UTF-8"));
        }
        byte[] tmp = "I'm return!".getBytes();
        resp.getOutputStream().write(tmp);

        resp.getOutputStream().close();



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
            byte[] buffer = new byte[bufSize];
            int size = is.read(buffer);
            System.out.println("read buffer:" + new String(buffer));
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
