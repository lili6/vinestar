package vine.sample.mybatis.dao;

import org.springframework.stereotype.Component;
import vine.core.dao.annotation.AutoDao;
import vine.sample.mybatis.User;

/**
 * Created by liguofang on 2014/10/28.
 */
@AutoDao
public interface UserDao {
    public User selectUser(int id);
    public void insertUser(User user);

}
