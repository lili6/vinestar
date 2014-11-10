package vine.app.dao.model.enums;

/**
 * Created by liguofang on 2014/10/27.
 * 好友关系
 * 可以根据需要进行添加，缺省是好友
 * TODO
 */
public enum Relationship {
    Friend(0,"好友"),
    Workmate(1,"同事"),
    Classmate(2,"同学"),
    BlackList(9,"黑名单");

    private int code;
    private String desc;

    private Relationship(int code, String desc){
        this.code = code;
        this.desc = desc;
    }
    public int getCode(){
        return this.code;
    }

    public String getDesc(){
        return this.desc;
    }

    public static Relationship codeOf(int code){
        for(Relationship type : Relationship.values()){
            if(type.code == code){
                return type;
            }
        }
        return null;
    }

}
