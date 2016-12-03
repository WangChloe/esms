package com.plan.a.es.webapp.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.plan.a.es.EsConstants;

/**
 * 用于项目启动时，预装载部分信息
 * 
 * @author jimmy.zhou
 *
 */
public class StartupListener implements ServletContextListener {
	private static final Logger log = Logger.getLogger(StartupListener.class);

    public void contextInitialized(ServletContextEvent event) {
        log.debug("Initializing context...");

        ServletContext context = event.getServletContext();
        ApplicationContext ctx =
                WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        EsConstants.ctx = ctx;
        for(String name : ctx.getBeanDefinitionNames()) {
        	log.info("load bean : " + name);
        }
        
        // do some initialized work ...
        
    }

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// Shutdown servlet context
		
	}

}
