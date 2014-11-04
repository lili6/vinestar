package vine.core.net.packet;
/**
 * 与客户端交互通讯数据时使用的常量
 * 
 * @author liguofang
 *
 */
public class PacketConst {

    //======================框架报文结构定义==开始====================================================
    /** 向客户端发送的消息中包含的消息ID变量名称 */
    public static final String HTTP_KEY_PACKETHEAD 		= "packetHead";
    public static final String HTTP_KEY_APPHEAD 		= "appHead";
//    public static final String APP_BODY 		= "appBody";

    //======================框架报文结构定义==结束====================================================

	//======================框架报文头定义==开始====================================================
	/** 向客户端发送的消息中包含的消息ID变量名称 */
	public static final String PACKET_KEY_PACKET_ID		= "packetId";
	/** 时间戳key名称*/
	public static final String PACKET_KEY_STAMP	 	= "stamp";
	/** 通讯响应码key名称*/
	public static final String PACKET_KEY_RET_CODE  = "retCode";
	/** 标识位key名称, 预留*/
	public static final String PACKET_KEY_FLAG		= "flag";

	//======================应用报文头定义==开始====================================================
    public static final String  APP_KEY_MAC_ID = "macId";
    /*apk version*/
    public static final String APP_KEY_VERSION_CODE = "versionCode";
    /* 操作系统版本 */
    public static final String APP_KEY_DEVICE_SYSTEM = "deviceSystem";
    /* 设备名称  */
    public static final String APP_KEY_DEVICE_NAME = "deviceNAME";
    /* 网络类型*/
    public static final String APP_KEY_NETWORK_TYPE = "networkType";
    /*设备厂商*/
    public static final String APP_KEY_DEVICE_BRAND = "deviceBrand";
    /*机型*/
    public static final String APP_KEY_DEVICE_TYPE = "deviceType";
    /*网络运营商*/
    public static final String APP_KEY_OPERATOR = "operator";

    /*登录地区名称*/
    public static final String APP_KEY_AREA = "area";
    /*登录国家名称*/
    public static final String APP_KEY_COUNTRY="country";
    /*渠道号*/
    public static final String APP_KEY_CHANNELID="channelId";
    /*是否越狱*/
    public static final String APP_KEY_PRISONBREAK="prisonBreak";
    /*服务器号*/
    public static final String APP_KEY_SERVERID="serverId";
    /*服务器下发令牌，每次要进行验证*/
    public static final String APP_KEY_TOKEN="token";

    //======================应用报文头定义==结束====================================================

    public static final String MESSAGE_DEFAULT_ENCODING = "UTF-8";
}
