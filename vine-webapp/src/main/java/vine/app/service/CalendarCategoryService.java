package vine.app.service;

import org.springframework.stereotype.Service;
import vine.app.dao.auto.CalendarCategoryDao;
import vine.app.message.CalendarMessage;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by renfj on 2014/11/03.
 */
@Service
public class CalendarCategoryService {

    @Resource
    private CalendarCategoryDao calendarCategoryDao;

    public List<CalendarMessage.CalendarCategory> findCalendarCategoryList(String startTime, String endTime, String keyword) {

        return null;
    }

    public CalendarMessage.CalendarCategory findCalendarCategoryById(Long calendarCategoryId) {
        return null;
    }

    public void addCalendarCategory(CalendarMessage.CalendarCategory calendarCategory) {

    }

    public void editCalendarCategoryById(CalendarMessage.CalendarCategory calendarCategory) {
    }

    public void deleteCalendarCategoryById(Long calendarCategoryId) {


    }
}
