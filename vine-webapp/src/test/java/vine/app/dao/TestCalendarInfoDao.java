package vine.app.dao;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;
import vine.app.dao.base.TestDAOBase;
import vine.app.dao.model.CalendarInfo;

import java.util.List;

/**
 * Created by renfj on 2014/11/05.
 */
public class TestCalendarInfoDao extends TestDAOBase {

    private static final Logger log = LoggerFactory.getLogger(TestCalendarInfoDao.class);
    @Test
    @Transactional
    @Rollback(true)
    public void findCalendarInfoList() {

        List<CalendarInfo>  calendarInfos=calendarInfoDao.findCalendarInfoList(userId,startTime,endTime,"上课",1l,1);

        Assert.assertNotNull(calendarInfos);
        System.out.println(JSON.toJSONString(calendarInfos));

        System.out.println("--------------分隔线---------------");

    }

}
