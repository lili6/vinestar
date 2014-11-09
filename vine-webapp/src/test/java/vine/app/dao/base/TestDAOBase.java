package vine.app.dao.base;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;
import vine.app.base.TestNGTestBase;
import vine.app.dao.auto.CalendarCategoryDao;
import vine.app.dao.auto.CalendarCommentDao;
import vine.app.dao.auto.CalendarInfoDao;
import vine.app.dao.auto.EnrollDao;

@TransactionConfiguration(transactionManager = "transactionManager")
public abstract class TestDAOBase extends TestNGTestBase {

	protected static String userId = "asdfasdfasd";

    protected static String startTime="2014-10-10 11:11:11";
    protected static String endTime="2014-12-10 11:11:11";

    protected static String mobileNo="13096936483";

    @Autowired
    protected EnrollDao enrollDao;
    @Autowired
    protected CalendarInfoDao calendarInfoDao;
    @Autowired
    protected CalendarCommentDao calendarCommentDao;
    @Autowired
    protected CalendarCategoryDao calendarCategoryDao;

}
