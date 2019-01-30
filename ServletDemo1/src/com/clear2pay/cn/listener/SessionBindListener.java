package com.clear2pay.cn.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
/**
 * 唯一不需要配置的监听器
 * 是session存/移出值的监听器
 * @author root
 *
 */
public class SessionBindListener implements HttpSessionBindingListener{
	private String key = "";
	private String value = "";
	
	public SessionBindListener(String key, String value){
		this.key = key;
		this.value = value;
	}
	
	public void valueBound(HttpSessionBindingEvent event) {
		event.getSession().setAttribute(key, value);
	}

	public void valueUnbound(HttpSessionBindingEvent event) {
		event.getSession().removeAttribute(key);
	}

}
