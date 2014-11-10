package vine.app.dao.model.enums;

/**
 * Created by liguofang on 2014/11/10.
 * 省份 枚举类型，维护进去
 * TODO
 */
public enum Province {
    Beijing(0,"河北"),
    Shanxi(1,"山西"),
    ShangHai(2,"河南");

    private int code;
    private String desc;

    private Province(int code, String desc){
        this.code = code;
        this.desc = desc;
    }
    public int getCode(){
        return this.code;
    }

    public String getDesc(){
        return this.desc;
    }

    public static Province codeOf(int code){
        for(Province type : Province.values()){
            if(type.code == code){
                return type;
            }
        }
        return null;
    }

}
