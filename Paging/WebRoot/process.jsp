<%@page import="com.clear2pay.cn.entity.EmulatorTimer"%>
<%@page import="com.clear2pay.cn.dao.impl.EmulatorTimerDaoImpl"%>
<%@page import="com.clear2pay.cn.dao.EmulatorTimerDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'process.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    	EmulatorTimerDao etd = new EmulatorTimerDaoImpl();
    	String pageNoStr = (String)request.getParameter("pageNo");
    	String pageSizeStr = (String)request.getParameter("pageSize");
    	if(pageSizeStr == null){
    		pageSizeStr = "10";
    	}
    	int pageSize = Integer.parseInt(pageSizeStr);
    	if(pageNoStr ==null || pageNoStr.equals("0")){
    		pageNoStr = "1";
    	}
    	int	pageNo = Integer.parseInt(pageNoStr);
    	int maxNo = etd.selectMaxPageNo(pageSize);
    	if(pageNo >=maxNo ){
    		pageNo = maxNo;
    	}
    	List<EmulatorTimer> list = etd.findEmulatorTimer(pageNo,pageSize);
    	request.setAttribute("etList", list);
    	request.setAttribute("pageNo", pageNo);
    	request.setAttribute("pageSize", pageSize);
    	request.setAttribute("maxNo", maxNo);
    	request.getRequestDispatcher("show.jsp").forward(request, response);
    %>
  </body>
</html>
