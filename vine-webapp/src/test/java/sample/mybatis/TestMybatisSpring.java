package sample.mybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vine.app.service.EnrollService;

/**
 * Created by liguofang on 2014/10/13.
 */
public class TestMybatisSpring {

        public static void main(String[] args) {
//            ApplicationContext context = new ClassPathXmlApplicationContext("context/spring.xml"); // runs ok
//            ApplicationContext context = new ClassPathXmlApplicationContext("context/context*.xml") ;
                        ApplicationContext context = new ClassPathXmlApplicationContext("context/spring.xml") ;
            EnrollService userService = (EnrollService)context.getBean("enrollService");
            System.out.println("user=================\n" +
                    userService.findEnrollByMobileNo("13096936483"));
        }
}
