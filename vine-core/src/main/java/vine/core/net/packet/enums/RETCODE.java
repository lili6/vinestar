package vine.core.net.packet.enums;

/**
 * Created by liguofang on 2014/10/27.
 * record enabled
 * 0:used
 * 1:deleted
 */
public enum RETCODE {
    SUCCESS(1),//"执行成功"
    FAILED(0), //"执行失败"
    NEEDONLINE(99),//,"需要登录"
    MESSAGE_EMPTY(100),//,"请求消息为空"
    MESSAGE_PARSE_ERROR(101),//,"请求消息解析错误"
    PACKETID_EMPTY(102),//,"请求消息包ID为空"
    PACKETID_NOT_EXIST(103),//,"请求包ID不存在"
    PACKETID_LOCKED(104); //"请求包锁定中"

    private int code;

    private RETCODE(int code){
        this.code = code;
    }
    public int value(){
        return this.code;
    }

    @Override
    public String toString() {
        return String.valueOf ( this.code );
    }
}
