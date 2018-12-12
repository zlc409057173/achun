<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    <c:set var="age" value="21" scope="request"></c:set>
    <c:set var="month" value="4" scope="request"></c:set>
    <c:if test="${age ge 18 }">
    	成年了。
    </c:if>
    <c:if test="${age lt 18 }">
    	未成年。
    </c:if>
    <c:choose>
    	<c:when test="${month eq 1 or month eq 3 }">
    		大月
    	</c:when>
    	<c:when test="${month eq 4 or month eq 6 }">
    		大月
    	</c:when>
    	<c:otherwise>
    		其他月
    	</c:otherwise>
    </c:choose>
    <br/>
    <c:forEach var="i" begin="1" end="9" step="1">
    	<c:forEach var="j" begin="1" end="${i }" step="1">
    		${i } * ${j } = ${i * j} &nbsp;
    	</c:forEach>
    	<br/>
    </c:forEach>
    <jsp:useBean id="userDao" class="com.clear2pay.cn.dao.UserDao" scope="page"></jsp:useBean>
    <c:forEach var="user" items="${userDao.allUsers }" varStatus="i">
    	${i.index mod 2 }${user.name }今年${user.age }岁。<br/>
    </c:forEach>
    <%=request.getHeader("referer") %>
  </body>
</html>
