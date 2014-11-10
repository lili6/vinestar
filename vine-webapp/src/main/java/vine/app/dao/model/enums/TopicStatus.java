package vine.app.dao.model.enums;

/**
 * Created by liguofang on 2014/11/10.
 *
 * TODO
 */
public enum TopicStatus {
    Sending(1,"发布中"),
    Success(2,"发布成功"),
    Fail(3,"发布失败");

    private int code;
    private String desc;

    private TopicStatus(int code, String desc){
        this.code = code;
        this.desc = desc;
    }
    public int getCode(){
        return this.code;
    }

    public String getDesc(){
        return this.desc;
    }

    public static TopicStatus codeOf(int code){
        for(TopicStatus type : TopicStatus.values()){
            if(type.code == code){
                return type;
            }
        }
        return null;
    }

}
