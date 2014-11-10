package vine.app.dao.model.enums;

/**
 * Created by liguofang on 2014/10/27.
 * 0:unread
 * 1:readed
 */
public enum IsRead {
    Unread(0,"未读"),
    Readed(1,"已读");

    private int code;
    private String desc;

    private IsRead(int code, String desc){
        this.code = code;
        this.desc = desc;
    }
    public int getCode(){
        return this.code;
    }

    public String getDesc(){
        return this.desc;
    }

    public static IsRead codeOf(int code){
        for(IsRead type : IsRead.values()){
            if(type.code == code){
                return type;
            }
        }
        return null;
    }

}
