<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>信息展示</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		function go(){
			var no = $("#index").val();
			if(no=="" || isNaN(no)) no=1;
			var size =  $("#size").val();
			if(size=="" || isNaN(size)) size=10;
			location.href="process?pageNo="+no+"&&pageSize="+size;
		}
		function filtrate(){
			var filtTxt = $("#filtVal").val();
			if(filtTxt.length <= 0){
				filtTxt = "null";
			}
			var jsonStr = "{\"filtVal\":"+filtTxt+",\"pageSize\":"+${pageSize }+"}";
			console.info(jsonStr);
			<%-- var u = eval("("+jsonStr+")"); 
			var u1 = jsonStr.parseJSON();--%>
			var u1 = JSON.parse(jsonStr);
			<%-- location.href="fileUpload.jsp"; --%>
		}
	</script>
  </head>
  
  <body>
  	当前登录的是：${cookie.user.value}<br/>
    <center>
  	<input type="text" style="width: 150px;" placeholder="请输入你要查的目录" id="filtVal"/><button onclick="filtrate()">查询</button>
    	<table style="border:2px solid #000;">
    		<caption>仿真信息</caption>
    		<tr>
    			<td>编号</td>
    			<td>仿真目录</td>
    			<td>备份目录</td>
    			<td>异常目录</td>
    			<td>QName</td>
    			<td>描述</td>
    			<td>是否有效</td>
    		</tr>
    		<c:forEach var="et" items="${etList }" varStatus="i">
    				<tr>
    					<td>${i.index+1}</td>
    					<td>${et.folderPath }</td>
    					<td>${et.bakfolderPath }</td>
    					<td>${et.errorfolderPath }</td>
    					<td>${et.queueName }</td>
    					<td>${et.description }</td>
    					<td>${et.enableFlag }</td>
    				</tr>
    		</c:forEach>
    	</table>
    </center>
    <center>
	    <a href="process?pageNo=1&&pageSize=${pageSize }" >首页</a>
	    <a href="process?pageNo=${pageNo-1 }&&pageSize=${pageSize }" >上一页</a>
	    <a href="process?pageNo=${pageNo+1 }&&pageSize=${pageSize }" >下一页</a>
	    <a href="process?pageNo=${maxNo }&&pageSize=${pageSize }" >尾页</a>
	        每页显示<input type="text" value="${pageSize }" id="size" >条跳转到<input type="text" value="${pageNo }" id="index"/>页<input type="button" value="Go" onclick="go()"/>
   	</center>
  </body>
</html>
