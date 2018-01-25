<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.sf.bean.Userbean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'editUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style>
/* 		div.max{
		 align:center;
		 right: 0;
		 
		 width:calc(100% - 500px);
		 /* margin-left:calc(100% - 650px); */
		 margin:0 auto;
		 margin-top:-650px
		} */
	</style>
  </head>
  
  <body>
  <jsp:include page="/admin/index.jsp"></jsp:include>
  <div class="max">
    <center>
    	<h2>用户信息修改</h2>
    	<% Userbean user =(Userbean) request.getAttribute("userbean");%>
    	用户名：<% user.getName();%>
    	<form action="userServlet?action=doEdit" method="post">
    		<input type="text" name="id" value="<%=user.getId()%>" readonly="readonly"/><br>
    		<input type="text" name="name" value="<%=user.getName()%>"/><br>
    		<input type="text" name="password" value="<%=user.getPassword()%>"/><br>
    		<input type="text" name="userClass" value="<%=user.getUserClass()%>"/><br>
    		<input type="submit" value="修改"/> 
    	</form>
    </center>
    </div>
  </body>
</html>
