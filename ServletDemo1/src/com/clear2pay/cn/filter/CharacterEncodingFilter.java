package com.clear2pay.cn.filter;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clear2pay.cn.util.StringUtils;

public class CharacterEncodingFilter implements Filter{
	private String oldEncoding = "";
	private String newEncoding = "";
	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		String method = request.getMethod();
		if("GET".equalsIgnoreCase(method)){
			Map map = request.getParameterMap();
			Collection colls = map.values();
			Iterator<String[]> it = colls.iterator();
			while(it.hasNext()){
				String[] strs = (String[])it.next();
				for (String str : strs) {
					str = new String(str.getBytes(oldEncoding),newEncoding);
				}
			}
		}else{
			request.setCharacterEncoding(newEncoding);
		}
		//给响应设置编码
		response.setCharacterEncoding(newEncoding);
		chain.doFilter(req, resp);
	}

	public void init(FilterConfig config) throws ServletException {
		oldEncoding = config.getInitParameter("oldEncoding");
		oldEncoding = StringUtils.isEmpty(oldEncoding)?"ISO8859-1":oldEncoding;
		newEncoding = config.getInitParameter("newEncoding");
		newEncoding = StringUtils.isEmpty(oldEncoding)?"UTF-8":newEncoding;
	}

}
