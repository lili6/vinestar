package vine.app.factory;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import vine.core.cache.CacheType;
import vine.core.config.Configuration;
import vine.core.config.ResourcePath;
import vine.core.config.ResourcePathType;
import vine.core.net.ServerType;
import vine.core.net.action.ActionRegister;
import vine.core.net.action.ActionType;
import vine.core.net.session.UserSessionManager;
import vine.core.spring.SpringBeanFactory;

public class SpringUtil {
	
	private static Logger log = Logger.getLogger(SpringUtil.class);
	
	private static final ApplicationContext context =  SpringBeanFactory.getContext();

	private SpringUtil(){
	}
	
	public static void init(){
//		String rootPath = SpringUtil.class.getResource("").getPath();
//    	rootPath = rootPath.substring(0, rootPath.indexOf("WEB-INF"));
		Configuration.getInstance().load(
				new ResourcePath(ResourcePathType.CLASSPATH, "/config/database.properties"),
				new ResourcePath(ResourcePathType.CLASSPATH, "/config/project.properties"));

		// 预调用一次，减少初始化时的性能消耗
		//-------modify by liguofang 2014-3-4
		UserSessionManager.init(ServerType.HTTP, CacheType.CLASS);
		SpringBeanFactory.init();
	    AppBeanFactory.init();
        initAction();

	}


	public static void initAction(){
		try {
			// 初始化Action
//			ActionRegister.init();
			// 初始化Action脚本文件
	    	ActionRegister.getRegister(ActionType.CLASS).init("vine.app.action","false");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ApplicationContext getContext(){
		return context;
	}
	
}
