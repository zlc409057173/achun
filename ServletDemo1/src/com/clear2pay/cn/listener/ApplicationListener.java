package com.clear2pay.cn.listener;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ApplicationListener implements ServletContextListener{
	private static Logger log = Logger.getLogger(ApplicationListener.class);
	long startServerTime = 0l;
	long stopServerTime = 0l;
	public void contextDestroyed(ServletContextEvent event) {
		stopServerTime = System.currentTimeMillis();
		long time = stopServerTime - startServerTime;
//		log.info("服务器关闭："+time);
	}

	public void contextInitialized(ServletContextEvent event) {
		ServletContext application = event.getServletContext();
		String log4jLocation = application.getInitParameter("log4j-properties-location");  
        if (log4jLocation == null) {  
            System.err.println("*** 没有 log4j-properties-location 初始化的文件, 所以使用 BasicConfigurator初始化");  
            BasicConfigurator.configure();  
        } else {  
            String webAppPath = application.getRealPath("/"); 
            String log4jProp = webAppPath + log4jLocation;
            File yoMamaYesThisSaysYoMama = new File(log4jProp);  
            if (yoMamaYesThisSaysYoMama.exists()) {  
                System.out.println("使用: " + log4jProp+"初始化日志设置信息");  
                PropertyConfigurator.configure(log4jProp);  
            } else {  
                System.err.println("*** " + log4jProp + " 文件没有找到， 所以使用 BasicConfigurator初始化");  
                BasicConfigurator.configure();  
            }  
        }  
		startServerTime = System.currentTimeMillis();
		log.info("服务器启动："+startServerTime);
	}

}
