package vine.app.service;

import org.springframework.stereotype.Service;
import vine.app.dao.auto.CalendarDao;
import vine.app.message.CalendarMessage;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by renfj on 2014/11/03.
 */
@Service
public class CalendarService {
    @Resource
    private CalendarDao calendarDao;

    public List<CalendarMessage.Calendar> findCalendarList(String startTime, String endTime, String keyword, Long calCategoryId, Integer priority) {
       return calendarDao.findCalendarList(startTime,endTime,keyword,calCategoryId,priority);
    }
}
