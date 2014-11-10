package vine.app.dao.model.enums;

/**
 * Created by liguofang on 2014/10/27.
 * TODO
 */
public enum NoticeType {
    Praised(1,"赞"),
    Commented(2,"评论"),
    Forward(3,"转发"),
    Favorite(4,"收藏"),
    AIT(5,"@me");

    private int code;
    private String desc;

    private NoticeType(int code, String desc){
        this.code = code;
        this.desc = desc;
    }
    public int getCode(){
        return this.code;
    }

    public String getDesc(){
        return this.desc;
    }

    public static NoticeType codeOf(int code){
        for(NoticeType type : NoticeType.values()){
            if(type.code == code){
                return type;
            }
        }
        return null;
    }

}
