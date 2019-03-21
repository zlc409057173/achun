package com.clear2pay.cn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpHeaderSecurityFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
    	response.setHeader("Access-Control-Allow-Methods", "POST, GET");//允许跨域的请求方式
    	response.setHeader("Access-Control-Max-Age", "3600");//预检请求的间隔时间
    	response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token,Access-Control-Allow-Headers");//允许跨域请求携带的请求头
    	response.setHeader("Access-Control-Allow-Credentials","true");//若要返回cookie、携带seesion等信息则将此项设置我true
 
    	response.setHeader("strict-transport-security","max-age=16070400; includeSubDomains");//简称为HSTS。它允许一个HTTPS网站，要求浏览器总是通过HTTPS来访问它
    	response.setHeader("Content-Security-Policy","default-src 'self'");//这个响应头主要是用来定义页面可以加载哪些资源，减少XSS的发生
    	response.setHeader("X-Content-Type-Options","nosniff");//互联网上的资源有各种类型，通常浏览器会根据响应头的Content-Type字段来分辨它们的类型。通过这个响应头可以禁用浏览器的类型猜测行为
    	response.setHeader("X-XSS-Protection","1; mode=block");//1; mode=block：启用XSS保护，并在检查到XSS攻击时，停止渲染页面
    	response.setHeader("X-Frame-Options","SAMEORIGIN");//SAMEORIGIN：不允许被本域以外的页面嵌入；
    	chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
