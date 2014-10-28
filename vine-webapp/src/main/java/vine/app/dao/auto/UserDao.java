package vine.app.dao.auto;

import vine.app.dao.model.User;
import vine.core.dao.annotation.AutoDao;

/**
 * Created by liguofang on 2014/10/28.
 */
@AutoDao
public interface UserDao {
    public User selectUser(int id);
    public void insertUser(User user);

}
