package vine.app.dao.model.enums;

/**
 * Created by liguofang on 2014/10/27.
 * record enabled
 * 0:used
 * 1:deleted
 */
public enum IsAgree {
    AGREE(1,"同意"),
    REFUSE(2,"拒绝");

    private int code;
    private String desc;

    private IsAgree(int code, String desc){
        this.code = code;
        this.desc = desc;
    }
    public int getCode(){
        return this.code;
    }

    public String getDesc(){
        return this.desc;
    }

    public static IsAgree codeOf(int code){
        for(IsAgree type : IsAgree.values()){
            if(type.code == code){
                return type;
            }
        }
        return null;
    }

}
