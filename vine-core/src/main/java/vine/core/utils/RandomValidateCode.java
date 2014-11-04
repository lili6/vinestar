package vine.core.utils;

import java.util.Random;

/**
 * Created by liguofang on 2014/11/4.
 * 用户登陆时随机校验码的生成
 */
public class RandomValidateCode {

    private static Random random = new Random();
    /** 验证码字符个数 */
    private static int codeCount = 4;

    private static char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };


    /**
    *获取随机的字符
    */
    public static String getRandomString(){
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
        StringBuffer randomCode = new StringBuffer();
        for (int i = 0; i < codeCount; i++) {
            // 得到随机产生的验证码数字。
            String strRand = String.valueOf(codeSequence[random.nextInt(36)]);
            // 将产生的四个随机数组合在一起。
            randomCode.append(strRand);
        }
        return randomCode.toString();
    }

    public static void main(String[] args) {
        System.out.println (getRandomString());
    }

}
