package vine.core.net.http;

import com.alibaba.fastjson.JSONObject;
import vine.core.net.packet.Packet;
import vine.core.net.packet.PacketConst;
import vine.core.utils.StringUtil;

import java.util.Arrays;

/**
 * Created by liguofang on 2014/10/24.
 * Http协议的报文格式：
 * Message=packet head + app Head + app body
 * 为了方便扩充，packetHead和appHead采用json格式串放到http的参数中
 * packetHead : packetId, stamp,retCode,flag， json格式串
 * appHead : 业务应用的公共报文头部分，json格式串
 * appBody：protobuf格式byte[]流
 */
public class HttpPacket implements Packet {

    /*应用体，protobuf 的byte[]*/
    private byte[] appBody ;

    private int packetId;
    /*报文包头*/
    private PacketHead packetHead ;
    /*应用头*/
    private AppHead appHead ;

    public int getPacketId() {
        return packetId;
    }

    public void setPacketId(int packetId) {
        this.packetId = packetId;
    }

    public PacketHead getPacketHead() {
        return packetHead;
    }

    public void setPacketHead(PacketHead packetHead) {
        this.packetHead = packetHead;
    }

    public AppHead getAppHead() {
        return appHead;
    }

    public void setAppHead(AppHead appHead) {
        this.appHead = appHead;
    }

    public byte[] getAppBody() {
        return appBody;
    }

    public void setAppBody(byte[] appBody) {
        this.appBody = appBody;
    }

    @Override
    public String toString() {
        return "HttpPacket{" +
                "packetHead=" + packetHead +
                ", appHead=" + appHead +
                ", appBody=" + StringUtil.bytes2HexStr(appBody) +
                '}';
    }
    /**
     * 组错误包
     */
    public HttpPacket packErrorResp() {
        HttpPacket p = new HttpPacket();

        return p;
    }

 public  class PacketHead {
        /*为消息ID 用来路由Action*/
        public int packetId = 0;
        /*客户端消息的唯一标识，通常用客户端的时间毫秒来标示*/
        public long stamp = 0l;
        /*框架层标识的返回代码。0表示正常。其他表示错误代码*/
        public int retCode = 0;
        /*预留，暂时没有作用*/
        public int flag = 0;

     @Override
     public String toString() {
         return "PacketHead{" +
                 "packetId=" + packetId +
                 ", stamp=" + stamp +
                 ", retCode=" + retCode +
                 ", flag=" + flag +
                 '}';
     }
 }

    public  class AppHead {
        /*apk version*/
        public String versionCode;
        /* 操作系统版本 */
        public String deviceSystem;
        /* 设备名称  */
        public String deviceName;
        /* 网络类型*/
        public String networkType ;
        /*设备厂商*/
        public String deviceBrand;
        /*机型*/
        public String deviceType;
        /*网络运营商*/
        public String operator;

        @Override
        public String toString() {
            return "AppHead{" +
                    "versionCode='" + versionCode + '\'' +
                    ", deviceSystem='" + deviceSystem + '\'' +
                    ", deviceName='" + deviceName + '\'' +
                    ", networkType='" + networkType + '\'' +
                    ", deviceBrand='" + deviceBrand + '\'' +
                    ", deviceType='" + deviceType + '\'' +
                    ", operator='" + operator + '\'' +
                    '}';
        }
    }
}

