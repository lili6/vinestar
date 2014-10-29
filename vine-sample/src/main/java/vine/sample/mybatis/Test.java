package vine.sample.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import vine.core.utils.UUIDGenerator;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.UUID;

/**
 * Created by liguofang on 2014/10/10.
 * simple test for single table
 */
public class Test {

    public static void main(String[] args) throws IOException {

        String resource = "mybatis/mybatis-config.xml";

        Reader reader = Resources.getResourceAsReader(resource);

        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);

        SqlSession session = ssf.openSession();
        try{

            User user2 = new User();
            user2.setUserId(UUIDGenerator.getUUID());
            user2.setName("liguofang");
            user2.setPassword("000000");
//            session.insert("insertUser",user2);
            user2.setComment("测试插入数据返回主键功能");
            System.out.println("before id=" + user2.getId());
            int insertRet = session.insert("insertAndGetId",user2);
            System.out.println("--------------分隔线---插入并返回Id------------");
            System.out.println("after id=" + user2.getId());

            session.commit();
            System.out.println("insertRet:" + insertRet);
            User user = session.selectOne("selectUser", 1);
            System.out.println(user.getName());

            System.out.println(user);

            System.out.println("--------------分隔线---------------");



            List<User> users = session.selectList("selectUsers");

            for(int i=0; i<users.size(); i++) {

                System.out.println(users.get(i).getName());
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            session.close();

        }

    }

}
