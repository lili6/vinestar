package vine.app.dao.model.enums;

/**
 * Created by liguofang on 2014/11/10.
 * 城市 枚举类型，维护进去
 * TODO
 */
public enum City {
    Beijing(0,"北京"),
    ShangHai(1,"上海");

    private int code;
    private String desc;

    private City(int code, String desc){
        this.code = code;
        this.desc = desc;
    }
    public int getCode(){
        return this.code;
    }

    public String getDesc(){
        return this.desc;
    }

    public static City codeOf(int code){
        for(City type : City.values()){
            if(type.code == code){
                return type;
            }
        }
        return null;
    }

}
