package vine.core.net.packet;

import com.alibaba.fastjson.JSONObject;
import vine.core.net.packet.Packet;
import vine.core.net.packet.PacketConst;
import vine.core.net.packet.enums.RETCODE;
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
public class HttpPacket {

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
                "appBody=" + appBody+
                ", packetId=" + packetId +
                ", packetHead=" + packetHead +
                ", appHead=" + appHead +
                '}';
    }

    /**
     * 组错误包ＲＥＴＣＯＤＥ
     */
    public void setRetCode(RETCODE retcode) {
        this.getPacketHead().retCode = retcode.value();
    }
    public void setStamp() {
        this.getPacketHead().stamp = System.currentTimeMillis();
    }

 public  class PacketHead {
        /*为消息ID 用来路由Action*/
        public int packetId = 0;
        /*客户端消息的唯一标识，通常用客户端的时间毫秒来标示*/
        public long stamp = 0l;
        /*框架层标识的返回代码。0表示正常。其他表示错误代码*/
        public int retCode = 0;
        /*预留，暂时没有作用
        public int flag = 0; */


     public String toJson() {
         JSONObject obj = new JSONObject();
         obj.put(PacketConst.PACKET_KEY_PACKET_ID,packetId);
         obj.put(PacketConst.PACKET_KEY_RET_CODE,retCode);
         obj.put(PacketConst.PACKET_KEY_STAMP,stamp);
         return obj.toJSONString();
     }

     @Override
     public String toString() {
         return "PacketHead{" +
                 "packetId=" + packetId +
                 ", stamp=" + stamp +
                 ", retCode=" + retCode +
                 '}';
     }
 }

    public  class AppHead {
        /*macId*/
        public  String macId;
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
        /*登录地区名称*/
        public String area;
        /*登录国家名称*/
        public String country;
        /*渠道号*/
        public String channelId;
        /*是否越狱*/
        public String prisonBreak;
        /*服务器号*/
        public String serverId;
        /*令牌*/
        public String token;
        //TODO 添加完整。。。
        public String toJson() {
            JSONObject obj = new JSONObject();
            obj.put(PacketConst.APP_KEY_MAC_ID,macId);
            obj.put(PacketConst.APP_KEY_DEVICE_BRAND,deviceBrand);
            obj.put(PacketConst.APP_KEY_DEVICE_NAME,deviceName);
            obj.put(PacketConst.APP_KEY_DEVICE_SYSTEM,deviceSystem);
            obj.put(PacketConst.APP_KEY_DEVICE_TYPE,deviceType);
            obj.put(PacketConst.APP_KEY_NETWORK_TYPE,networkType);
            obj.put(PacketConst.APP_KEY_OPERATOR,operator);
            obj.put(PacketConst.APP_KEY_VERSION_CODE,versionCode);
            obj.put(PacketConst.APP_KEY_AREA,area);
            obj.put(PacketConst.APP_KEY_COUNTRY,country);
            obj.put(PacketConst.APP_KEY_CHANNELID,channelId);
            obj.put(PacketConst.APP_KEY_PRISONBREAK,prisonBreak);
            obj.put(PacketConst.APP_KEY_SERVERID,serverId);
            obj.put(PacketConst.APP_KEY_TOKEN,token);
            return obj.toJSONString();
        }

        @Override
        public String toString() {
            return "AppHead{" +
                    "macId='" + macId + '\'' +
                    ", versionCode='" + versionCode + '\'' +
                    ", deviceSystem='" + deviceSystem + '\'' +
                    ", deviceName='" + deviceName + '\'' +
                    ", networkType='" + networkType + '\'' +
                    ", deviceBrand='" + deviceBrand + '\'' +
                    ", deviceType='" + deviceType + '\'' +
                    ", operator='" + operator + '\'' +
                    ", area='" + area + '\'' +
                    ", country='" + country + '\'' +
                    ", channelId='" + channelId + '\'' +
                    ", prisonBreak='" + prisonBreak + '\'' +
                    ", serverId='" + serverId + '\'' +
                    ", token='" + token + '\'' +
                    '}';
        }
    }
}

