package vine.app.dao.auto;

import org.apache.ibatis.annotations.Param;
import vine.app.dao.model.CalendarInfo;
import vine.core.dao.annotation.AutoDao;

import java.util.List;

/**
 * Created by renfj on 2014/11/03.
 */
@AutoDao
public interface CalendarInfoDao {
    List<CalendarInfo> findCalendarInfoList(@Param("userId") String userId, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("keyword") String keyword, @Param("calCategoryId") Long calCategoryId, @Param("priority") Integer priority);
}
