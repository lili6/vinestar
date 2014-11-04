package sample.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vine.app.dao.model.UserEnroll;
import vine.app.dao.model.enums.Enabled;
import vine.core.utils.UUIDGenerator;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by liguofang on 2014/10/27.
 */
public class TestEnrollDao {
    private static final Logger log = LoggerFactory.getLogger(TestEnrollDao.class);
    private  static SqlSession session = null;
    private static void insertEnroll() {
        UserEnroll user2 = new UserEnroll();
        String userId = UUIDGenerator.getUUID();
        user2.setUserId(userId);
        user2.setMobileNo("13096936482");
        user2.setPassword("111111");
        user2.setCreator("admin");
        log.debug("insert data: {}" ,user2);
//       int ret =  session.insert("insertEnroll",user2);
//        log.debug("ret:",ret);
//        session.commit();
    }

    private static void deleteEnrollBySeqno() {
        UserEnroll userEnroll = new UserEnroll();
        userEnroll.setUpdater("liguofang");
        userEnroll.setSeqno(2);
        userEnroll.setEnabled(Enabled.DELETED);
        session.update("deleteEnrollBySeqno",userEnroll);
        session.commit();
    }
    private static void selectOne() {
//        UserEnroll user = session.selectOne("selectEnrollBySeqno", 1l);
        UserEnroll user = session.selectOne("findEnrollByMobileNo", "13096936483");

        System.out.println(user.getSeqno());

        System.out.println(user);

        System.out.println("--------------分隔线---------------");


    }
    private static void selectList() {
        List<UserEnroll> users = session.selectList("selectAllEnroll");

        for(int i=0; i<users.size(); i++) {

            //    System.out.println(users.get(i).getSeqno()+"::::");
            //  System.out.println(users.get(i));
        }

    }
    private void init() {

    }

    public static void main(String[] args) throws IOException {
//        SpringUtil.init();
        String resource = "mybatis/mybatis-test.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
        session = ssf.openSession();
        try{
            UserEnroll user2 = new UserEnroll();
            String userId = UUIDGenerator.getUUID();
            user2.setUserId(userId);
            user2.setMobileNo("13096936482");
            user2.setPassword("111111");
            user2.setCreator("admin");
            log.debug("insert data: {}" ,user2);
            int ret =  session.insert("insertEnroll",user2);
            log.debug("ret:",ret);
            session.commit();
//            insertEnroll();
        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            session.close();

        }

    }
}
