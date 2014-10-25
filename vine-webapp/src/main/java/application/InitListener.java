package application;

import org.apache.log4j.Logger;
import vine.app.factory.SpringUtil;
import vine.core.net.session.UserSessionManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitListener  implements ServletContextListener  {
    private static final Logger log = Logger.getLogger(InitListener.class);
    /** 服务器关服状态，true－正在关闭，false－服务器正常运行中 */
    public static boolean isServerClosing = false;
   
    public void contextInitialized(ServletContextEvent event) {
    	SpringUtil.init();
    	if (log.isInfoEnabled()) { log.info("初始化Vine服务器成功!!!!! !!!!!!!");   }
    }

    public void contextDestroyed(ServletContextEvent event) {
    	if (log.isInfoEnabled()) { log.info("正在关闭服务器........"); }
    	isServerClosing = true;
    	UserSessionManager.getManager().closeAllSession();
    	if (log.isInfoEnabled()) { log.info("Vine服务器已关闭........"); }
    }
    
}
