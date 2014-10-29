package vine.core.utils;

import java.util.UUID;

/**
 * Created by liguofang on 2014/10/29.
 */
public class UUIDGenerator {
    /**
     * 去掉符号"-"的uuid
     * @return
     */
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // 去掉"-"符号
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
        return temp;
    }
    /**
     *获得指定数量的UUID
     * @param  number
     */
    public static String[] getUUID(int number) {
        if (number < 1) {
            return null;
        }
        String[] ss = new String[number];
        for (int i = 0; i < number; i++) {
            ss[i] = getUUID();
        }
        return ss;
    }

    public static void main(String[] args) {
//        UUID uuid = UUID.randomUUID();
        String uid = getUUID();
        System.out.println("uid=" + uid);
        String token = net.iharder.Base64.encodeBytes(uid.getBytes());
        System.out.println("token=" + token);

        /*
        String[] ss = getUUID(10);
        for (int i = 0; i < ss.length; i++) {
            System.out.println("ss["+i+"]==="+ss[i]);
        }
        */
    }
}
