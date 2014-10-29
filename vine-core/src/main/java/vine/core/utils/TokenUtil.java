package vine.core.utils;

import net.iharder.Base64;

import java.util.UUID;

/**
 * Created by liguofang on 2014/10/29.
 */
public class TokenUtil {

    /**
     * 生成token
     * @param param String seqno,String userId,long stamp
     * @return
     */
    public static String generateToken(String param) {
        String token = Base64.encodeBytes(param.getBytes());
        return token;
    }


    /**
     * 对token进行比对
      * @param srcToken
     * @param destToken
     * @return
     */
    public static boolean compare(String srcToken,String destToken) {
        if (srcToken.equals(destToken)) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        UUID uid = UUID.randomUUID();
//        String uid = getUUID();
        System.out.println("uid=" + uid);
        String token = net.iharder.Base64.encodeBytes(uid.toString().getBytes());
        System.out.println("token=" + token);

    }
 }
