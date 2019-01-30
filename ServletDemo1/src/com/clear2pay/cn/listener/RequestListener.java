package com.clear2pay.cn.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class RequestListener implements ServletRequestListener{
	private static Logger log = Logger.getLogger(RequestListener.class);
	public void requestDestroyed(ServletRequestEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void requestInitialized(ServletRequestEvent event) {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest)event.getServletRequest();
	}

}
