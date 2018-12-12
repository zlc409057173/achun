<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ajax.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		var xmlHttpReq="";
		function createXmlHttpRequest(){
			if(window.XMLHttpRequest){
				xmlHttpReq = new XMLHttpRequest();
			}else if(window.ActiveXObject){
				try{
					xmlHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
				}catch(e){
					try{
						xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
					}catch(e){
					}
				}
			}
		}
		function sendMSGByGet(){
			createXmlHttpRequest();
			var uname = document.getElementById("uname").value;
			var upass = document.getElementById("upass").value;
			xmlHttpReq.open("GET", "ajaxprocess.jsp?uname="+uname+"&&upass="+upass, true);
			xmlHttpReq.onreadystatechange=callback;
			xmlHttpReq.send(null);
		}
		function sendMSGByPost(){
		
		}
		function callback(){
			if(xmlHttpReq.readyState=="4"){
				if(xmlHttpReq.status=="200"){
					var text=xmlHttpReq.responseText;
					text = text.replace(/\s/g,"");
					if(text=="ok"){
						document.getElementById("result").innerHTML="<span style='color:green'>"+text+"</span>";
					}else{
						document.getElementById("result").innerHTML="<span style='color:red'>"+text+"</span>";
					}
				}
			}
		}
	</script>

  </head>
  
  <body>
    <form>
    	用户名：<input type="text" name="uname" id="uname"/><br/>
    	密    码：<input type="text" name="upass" id="upass"/>	<br/>
    	<input type="button" value="get提交" onclick="sendMSGByGet()">
    	<input type="button" value="post提交" onclick="sendMSGByPost()">
    </form>
    <div id="result"></div>
  </body>
</html>
