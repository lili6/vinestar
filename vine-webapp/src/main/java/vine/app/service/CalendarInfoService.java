package vine.app.service;

import org.springframework.stereotype.Service;
import vine.app.dao.auto.CalendarCommentDao;
import vine.app.dao.auto.CalendarInfoDao;
import vine.app.dao.model.CalendarComment;
import vine.app.dao.model.CalendarInfo;
import vine.app.message.CalendarMessage;
import vine.core.utils.BeanUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by renfj on 2014/11/03.
 */
@Service
public class CalendarInfoService {
    @Resource
    private CalendarInfoDao calendarInfoDao;
    @Resource
    private CalendarCommentDao calendarCommentDao;

    public List<CalendarMessage.Calendar> findCalendarList(String userId,String startTime, String endTime, String keyword, Long calCategoryId, Integer priority) {
        List<CalendarMessage.Calendar> calendarList=new ArrayList<CalendarMessage.Calendar>();
        List<CalendarInfo> calendarInfoList= calendarInfoDao.findCalendarInfoList(userId,startTime, endTime, keyword, calCategoryId, priority);

        for(CalendarInfo calendarInfo:calendarInfoList){
            List<CalendarComment> calendarCommentList=calendarCommentDao.findCalendarCommentByCalId(calendarInfo.getSeqno());
            calendarInfo.setCalendarComments(calendarCommentList);
            for(CalendarMessage.Calendar calendar:calendarList){
                BeanUtil.copyProperties(calendarInfo, calendar);
            }
        }

        return calendarList;

    }

    public void addCalendar(CalendarMessage.Calendar calendar) {
    }

    public void editCalendarById(CalendarMessage.Calendar calendar) {
    }

    public void deleteCalendarById(Long calendarId) {
    }

    public CalendarMessage.Calendar findCalendarById(Long calendarId) {

        return null;
    }
}
