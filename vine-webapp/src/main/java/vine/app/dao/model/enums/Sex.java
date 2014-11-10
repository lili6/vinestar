package vine.app.dao.model.enums;

/**
 * Created by liguofang on 2014/10/27.
 * record enabled
 * 0:女
 * 1:男
 */
public enum Sex {
    Female(0,"女"),
    Male(1,"男");

    private int code;
    private String desc;

    private Sex(int code, String desc){
        this.code = code;
        this.desc = desc;
    }
    public int getCode(){
        return this.code;
    }

    public String getDesc(){
        return this.desc;
    }

    public static Sex codeOf(int code){
        for(Sex type : Sex.values()){
            if(type.code == code){
                return type;
            }
        }
        return null;
    }

}
