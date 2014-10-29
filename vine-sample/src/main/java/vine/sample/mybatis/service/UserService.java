package vine.sample.mybatis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import vine.sample.mybatis.User;
import vine.sample.mybatis.dao.UserDao;

import javax.annotation.Resource;

/**
 * Created by liguofang on 2014/10/28.
 */
@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Resource
    public UserDao userDao;

    public User selectUser(int id) {
        return userDao.selectUser(id);
    }

}
