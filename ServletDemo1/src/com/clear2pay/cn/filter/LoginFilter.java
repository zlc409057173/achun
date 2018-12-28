package com.clear2pay.cn.filter;

import java.io.IOException;
import java.security.MessageDigest;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.clear2pay.cn.util.StringUtils;

public class LoginFilter implements Filter{
	private static Logger log =Logger.getLogger(LoginFilter.class);
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		String uri = request.getRequestURI();
		String loginPage = uri.substring(uri.lastIndexOf("/")+1);
		if("login.jsp".equals(loginPage)||"login".equals(loginPage)){
			chain.doFilter(req, resp);
			return;
		}
		Cookie[] cookies = request.getCookies();
		String username = "";
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				String user = cookie.getName();
				if("user".equals(user)){
					username = cookie.getValue();
					break;
				}
			}
			if(StringUtils.isNotEmpty(username)){
				chain.doFilter(req, resp);
				return;
			}
		}
		response.sendRedirect("login.jsp");
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
