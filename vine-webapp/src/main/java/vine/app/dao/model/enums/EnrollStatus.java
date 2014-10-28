package vine.app.dao.model.enums;

/**
 * Created by liguofang on 2014/10/27.
 * 用户注册状态
 */
public enum EnrollStatus {

    INITIAL(0,"注册未验证"),
    VERIFIED(1,"已验证"),
    CANCELED(2,"已注销");

    private int code;
    private String desc;

    private EnrollStatus(int code, String desc){
        this.code = code;
        this.desc = desc;
    }
    public int getCode(){
        return this.code;
    }

    public String getDesc(){
        return this.desc;
    }

    public static EnrollStatus codeOf(int code){
        for(EnrollStatus type : EnrollStatus.values()){
            if(type.code == code){
                return type;
            }
        }
        return null;
    }

}
