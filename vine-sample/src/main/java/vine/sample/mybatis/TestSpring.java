package vine.sample.mybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vine.sample.mybatis.service.UserService;

/**
 * Created by liguofang on 2014/10/13.
 */
public class TestSpring {

        public static void main(String[] args) {
            ApplicationContext context = new ClassPathXmlApplicationContext("context/spring.xml");
            UserService userService = (UserService)context.getBean("userService");
            System.out.println("user=================\n" + userService.selectUser(7));
        }
}
