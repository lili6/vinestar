/**
 * 
 */
package vine.common.constant;

/**
 * 业务请求结果常量
 * @author liguofang
 */
public class MessageResult {
    /*-------系统错误码0-50-------------------------------------------------------------------------------------*/
    /* 执行成功 */
    public static final int SUCCESS = 1;
    /* 执行失败 */
    public static final int FAIL = 0;
    /* 执行异常 */
    public static final int EXCEPTION = 2;
    //,"需要登录"
    public static final int NEED_LOGIN = 11;
    //,"请求消息为空"
//    public static final int MESSAGE_EMPTY = 12;
    //,"请求消息解析错误"
//    public static final int MESSAGE_PARSE_ERROR = 13;
    //,"请求消息包ID为空"
//    public static final int PACKET_ID_EMPTY = 14;
    //"请求包锁定中"
//    public static final int PACKET_ID_LOCKED = 15;

    /*---------应用公共错误码51--100-------------*/
    public static final int MESSAGE_PARSE_ERROR = 13;
    /*-------Enroll错误码101-200-------------------------------------------------------------------------------------*/
    public static final int ENROLL_MOBILE_OR_EMAIL_EXIST = 101;
    /*密码错误*/
    public static final int ENROLL_PASSWORD_ERROR = 102;
    /*邮箱已注册*/
    public static final int ENROLL_EMAIL_EXIST = 103;
    /*手机已注册*/
    public static final int ENROLL_MOBILE_EXIST = 104;
//    mobileNo or email must input
    public static final int ENROLL_EMAIL_OR_MOBILE_EMPTY = 105;

    /*密码错误*/
//    public static final int

/*-------Calendar错误码201-300-------------------------------------------------------------------------------------*/

}
