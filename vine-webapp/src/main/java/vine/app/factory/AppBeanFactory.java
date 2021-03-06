/**
 * 
 */
package vine.app.factory;

import org.springframework.context.ApplicationContext;
import vine.app.service.CalendarCategoryService;
import vine.app.service.CalendarCommentService;
import vine.app.service.CalendarInfoService;
import vine.app.service.EnrollService;

/**
 * @author liguofang
 *
 */
public class AppBeanFactory {
/*
	private static PersonDAO personDAO;
	private static RoleService roleService;
	private static HeroService heroService;
	private static ItemService itemService;
	private static GateService gateService;
	private static EmailService emailService;
	private static RobotManager robotManager;
	private static RankManager rankManager;
	private static LoginManager loginManager;
	private static ChatManager chatManager;
*/
    private static EnrollService enrollService;
    private static CalendarInfoService calendarInfoService;
    private static CalendarCategoryService calendarCategoryService;
    private static CalendarCommentService calendarCommentService;
    public static void init(){
		ApplicationContext context = SpringUtil.getContext();
        enrollService =(EnrollService)context.getBean("enrollService");
        calendarInfoService =(CalendarInfoService)context.getBean("calendarInfoService");
        calendarCategoryService =(CalendarCategoryService)context.getBean("calendarCategoryService");
        calendarCommentService = (CalendarCommentService) context.getBean("calendarCommentService");

        /*
		personDAO = context.getBean(PersonDAO.class);
		roleService = context.getBean(RoleService.class);
		heroService = context.getBean(HeroService.class);
		itemService = context.getBean(ItemService.class);
		gateService = context.getBean(GateService.class);
		emailService = context.getBean(EmailService.class);
		robotManager = context.getBean(RobotManager.class);
		rankManager = context.getBean(RankManager.class);
		loginManager = context.getBean(LoginManager.class);
		chatManager = context.getBean(ChatManager.class);
		*/
	}

    public static EnrollService getEnrollService() {
        return enrollService;
    }

    public static void setEnrollService(EnrollService enrollService) {
        AppBeanFactory.enrollService = enrollService;
    }

    public static CalendarInfoService getCalendarInfoService() {
        return calendarInfoService;
    }

    public static void setCalendarInfoService(CalendarInfoService calendarInfoService) {
        AppBeanFactory.calendarInfoService = calendarInfoService;
    }
    public static CalendarCategoryService getCalendarCategoryService() {
        return calendarCategoryService;
    }

    public static void setCalendarCategoryService(CalendarCategoryService calendarCategoryService) {
        AppBeanFactory.calendarCategoryService = calendarCategoryService;
    }

    public static CalendarCommentService getCalendarCommentService() {
        return calendarCommentService;
    }

    public static void setCalendarCommentService(CalendarCommentService calendarCommentService) {
        AppBeanFactory.calendarCommentService = calendarCommentService;
    }

    /*
	public static PersonDAO getPersonDAO() {
		return personDAO;
	}

	public static RoleService getRoleService() {
		return roleService;
	}
	
	public static HeroService getHeroService(){
		return heroService;
	}
	
	public static ItemService getItemService(){
		return itemService;
	}
	
	public static GateService getGateService(){
		return gateService;
	}

	public static RobotManager getRobotManager() {
		return robotManager;
	}

	public static EmailService getEmailService() {
		return emailService;
	}

	public static RankManager getRankManager() {
		return rankManager;
	}

	public static LoginManager getLoginManager() {
		return loginManager;
	}

	public static ChatManager getChatManager() {
		return chatManager;
	}
	*/
}
