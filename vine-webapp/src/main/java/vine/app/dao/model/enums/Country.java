package vine.app.dao.model.enums;

/**
 * Created by liguofang on 2014/11/10.
 * 国家 枚举类型，维护进去
 * TODO
 */
public enum Country {
    CHN(0,"中国"),
    USA(1,"美国");

    private int code;
    private String desc;

    private Country(int code, String desc){
        this.code = code;
        this.desc = desc;
    }
    public int getCode(){
        return this.code;
    }

    public String getDesc(){
        return this.desc;
    }

    public static Country codeOf(int code){
        for(Country type : Country.values()){
            if(type.code == code){
                return type;
            }
        }
        return null;
    }

}
