package vine.app.dao.model.enums;

/**
 * Created by liguofang on 2014/11/10.
 * TODO 实现指定好友可见的功能
 */
public enum VisibleRange {
    Public(1,"所有人可见"),
    Friend(2,"好友"),
    Private(3,"仅自己"),
    Nominate(4,"指定好友可见");

    private int code;
    private String desc;

    private VisibleRange(int code, String desc){
        this.code = code;
        this.desc = desc;
    }
    public int getCode(){
        return this.code;
    }

    public String getDesc(){
        return this.desc;
    }

    public static VisibleRange codeOf(int code){
        for(VisibleRange type : VisibleRange.values()){
            if(type.code == code){
                return type;
            }
        }
        return null;
    }

}
