package vine.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vine.app.dao.model.UserEnroll;
import vine.core.utils.UUIDGenerator;

/**
 * Created by liguofang on 2014/11/5.
 * 测试注册的所有服务接口
 */
public class TestEnrollService {
    private static final Logger log = LoggerFactory.getLogger(TestEnrollService.class);
    private static EnrollService service = null;
    private  static  void findEnrollByMobileNo() {
        service.findEnrollByMobileNo("18511248226");
    }

    private  static  void findEnrollByEmail() {
        service.findEnrollByEmail("18511248226");
    }


    private  static  void findEnrollByUserId() {
        service.findEnrollByUserId("71c7e2d8c3a74674bcdd70bd5402b103");
    }
    private static void insertEnroll() {
        UserEnroll user2 = new UserEnroll();
        String userId = UUIDGenerator.getUUID();
        user2.setUserId(userId);
        user2.setMobileNo("13096936482");
        user2.setPassword("111111");
        user2.setCreator("admin");
        log.debug("insert data: {}", user2);
        service.enroll(user2);
    }
    private  static void  checkPassword() {
        service.checkPassword("111","","222");
    }
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context/spring.xml") ;
        service = (EnrollService)context.getBean("enrollService");
//        findEnrollByMobileNo();
//        findEnrollByUserId();
//        insertEnroll();
//        insertHistory();
//        queryBuyHistoryByOrderId();
        checkPassword();

    }
}
