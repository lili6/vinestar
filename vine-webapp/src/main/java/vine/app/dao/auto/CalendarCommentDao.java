package vine.app.dao.auto;

import org.apache.ibatis.annotations.Param;
import vine.app.dao.model.CalendarComment;
import vine.core.dao.annotation.AutoDao;

import java.util.List;

/**
 * Created by renfj on 2014/11/3.
 */
@AutoDao
public interface CalendarCommentDao {
    public List<CalendarComment> findCalendarCommentByCalId(@Param("id") Long id);
}
