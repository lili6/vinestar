package vine.common.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vine.core.net.packet.HttpPacket;
import vine.core.net.session.UserSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用户登录缓存，用于控制用户同一设备重复登陆，或者不同设备重复登陆
 * Created by liguofang on 2014/11/5.
 */
public class UserLoginCache {
    private static final Logger log = LoggerFactory.getLogger(UserLoginCache.class);

    /** 限制再次登录的时间，10秒 */
    private static final int WAIT_TIME = 10000;
    /** Map<机器码，上次登录时间> */
    private static Map<String, Long> deviceNoLocker = new ConcurrentHashMap<String, Long>();
    /** token 的有效性验证 */
    private static Map<String, Long> tokenExpireLocker = new ConcurrentHashMap<String, Long>();
    /**token失效时间，30分钟*/
    private static final int TOKEN_EXPIRE_TIME = 300000;
    /** 用户离线后再次登录的时间，30秒 */
    private static final int EXPIRE_WAIT_TIME = 30000;
    /** 用户离线时登录控制缓存：Map<UserId，离线的时间> */
    private static Map<String, Long> roleExpireLocker = new ConcurrentHashMap<String, Long>();

    /**
     * 检查同一设备重复登录请求
     * @param session
     * @param m
     * @return true－可登录，false－该此不可登录
     */
    public static boolean checkDeviceRepeatLogin(UserSession session, HttpPacket m) {
        String deviceNo = m.getAppHead().deviceNo;
//        Boolean reconnect = m.getData().getBoolean("reconnect");
//        if (reconnect == null || !reconnect) {// 不是重连
            if (deviceNo != null) {
                synchronized (deviceNo) {
                    Long time = deviceNoLocker.get(deviceNo);
                    if (time != null) {
                        if ((time + WAIT_TIME) > System.currentTimeMillis()) {// 上次登录时间至现在不到10秒，不允许再次登录
                            return false;
                        }
                    }
                    deviceNoLocker.put(deviceNo, System.currentTimeMillis());
                }
            }
//        }
        return true;
    }

    /**
     * 更新token
     * @param token
     */
    public static void setToken(String token) {
        tokenExpireLocker.put(token,System.currentTimeMillis());
    }
    /**
     * 校验token的有效性
     * @param  m
     * @return true:有效，false：无效 ，需要重新登录
     */
    public static boolean checkTokenValidate(HttpPacket m) {
        String token = m.getAppHead().token;
        Long time = tokenExpireLocker.get(token);
        if (time != null) {
            if ((time + TOKEN_EXPIRE_TIME) > System.currentTimeMillis()) {// 上次下线的时间至现在超过30分钟，必须再次登陆
                if (log.isDebugEnabled()) { log.debug("上次登陆的时间超过" + (TOKEN_EXPIRE_TIME / 1000) + "秒，需要再次登录"); }
                return false;
            }
        } else {
            log.warn("user need login first!");
            return false;
        }
        return true;
    }

    /**
     * 检查用户下线后，是否可再次登录
     * @param userId
     * @return true－可登录，false－不可登录
     */
    public static boolean checkExpireLoginAgain(String userId) {
        Long time = roleExpireLocker.get(userId);
        if (time != null) {
            if ((time + EXPIRE_WAIT_TIME) > System.currentTimeMillis()) {// 上次下线的时间至现在不到30秒，不允许再次登录
                if (log.isDebugEnabled()) { log.debug("上次下线的时间至现在不到" + (EXPIRE_WAIT_TIME / 1000) + "秒，不允许再次登录"); }
                return false;
            }
        }
        return true;
    }

    /**
     * 添加用户下线的登录限制
     * @param userId
     */
    public static void addExpireLogoutLock(String userId) {
        roleExpireLocker.put(userId, System.currentTimeMillis());
    }

}
