<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String uname = request.getParameter("uname");
	String upass = request.getParameter("upass");
	System.out.print(uname);
	System.out.print(upass);
	if("zs".equals(uname)&&"123".equals(upass)){
		out.print("ok");
	}else{
		out.print("error");
	}
%>