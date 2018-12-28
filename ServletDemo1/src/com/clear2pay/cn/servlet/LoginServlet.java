package com.clear2pay.cn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class LoginServlet extends HttpServlet{
	private static Logger log = Logger.getLogger(LoginServlet.class);
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String upass = request.getParameter("upass");
		if("zhangsan".equals(username)&&"123".equals(upass)){
			log.info("登录成功！"+username);
			Cookie cookie = new Cookie("user", username);
			cookie.setMaxAge(120);
			response.addCookie(cookie); 
			response.sendRedirect("index.jsp");
		}else{
			log.info("登录失败！"+username);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
}
