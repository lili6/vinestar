package vine.app.service;

import org.springframework.stereotype.Service;
import vine.app.message.CalendarMessage;

import java.util.List;

/**
 * Created by renfj on 2014/11/3.
 */
@Service
public class CalendarCommentService {

    public List<CalendarMessage.CalendarComment> findCalendarCommentListByCalId(Long calendarId) {
        return null;
    }

    public void addCalendarComment(CalendarMessage.CalendarComment calendarComment) {
    }


    public void deleteCalendarCommentById(Long calendarId, Long calendarCommentId) {

    }
}
