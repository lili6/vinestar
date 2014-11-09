package vine.app.dao;

import junit.framework.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;
import vine.app.dao.base.TestDAOBase;
import vine.app.dao.model.UserEnroll;
import vine.app.dao.model.enums.Enabled;
import vine.core.utils.UUIDGenerator;

import java.util.Date;
import java.util.List;

/**
 * Created by liguofang on 2014/10/27.
 * Updated by renfj on 2014/11/05
 */
public class TestEnrollDao extends TestDAOBase {

    private static final Logger log = LoggerFactory.getLogger(TestEnrollDao.class);

    @Test
    @Transactional
    @Rollback(true)
    public void insertEnroll() {
        UserEnroll user2 = new UserEnroll();
        String userId = UUIDGenerator.getUUID();
        user2.setUserId(userId);
        user2.setMobileNo("13096936482");
        user2.setPassword("111111");
        user2.setCreator("admin");
        int result=enrollDao.insertEnroll(user2);
        Assert.assertTrue(result>0);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void deleteEnrollBySeqno() {
        insertEnroll();
        UserEnroll userEnroll = enrollDao.findEnrollByMobileNo(mobileNo);
        userEnroll.setUpdater("李国芳");
        userEnroll.setUpdateTime(new Date());
        userEnroll.setEnabled(Enabled.DELETED);
        enrollDao.deleteEnrollBySeqno(userEnroll);
        UserEnroll userEnrollUpdate = enrollDao.findEnrollByMobileNo(mobileNo);
        Assert.assertEquals(Enabled.DELETED, userEnrollUpdate.getEnabled());
    }
    @Test
    @Transactional
    @Rollback(true)
    public void selectOne() {
        insertEnroll();
        UserEnroll user =  enrollDao.findEnrollByMobileNo(mobileNo);
        Assert.assertEquals(mobileNo,user.getMobileNo());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void selectList() {
        insertEnroll();
        List<UserEnroll> users= enrollDao.selectAllEnroll();
        Assert.assertTrue(users.size()>0);
    }

}
