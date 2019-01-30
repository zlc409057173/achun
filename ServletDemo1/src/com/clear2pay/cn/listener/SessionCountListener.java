package com.clear2pay.cn.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCountListener implements HttpSessionListener{
	
	private static int count = 0;
	
	public void sessionCreated(HttpSessionEvent arg0) {
		count++;
		arg0.getSession().getServletContext().setAttribute("usercount", count);
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		count--;
		arg0.getSession().getServletContext().setAttribute("usercount", count);
	}

}
