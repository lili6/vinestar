package vine.app.dao.auto;

import vine.app.message.CalendarMessage;
import vine.core.dao.annotation.AutoDao;

import java.util.List;

/**
 * Created by renfj on 2014/11/03.
 */
@AutoDao
public interface CalendarDao {

    List<CalendarMessage.Calendar> findCalendarList(String startTime, String endTime, String keyword, Long calCategoryId, Integer priority);
}
