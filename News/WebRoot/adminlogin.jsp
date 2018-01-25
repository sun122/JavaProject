<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminlogin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="CSS/login1.css">

  </head>
  
  <body>
    <div>
        <h3>基于JSP的新闻发布系统后台登录</h3>
        <form action="AdminLoginServlet" method="post" name="form1">
             <input type="text" name="name" placeholder="用户名">
             <input type="password" name="password" placeholder="密码">
            <input type="password" placeholder="确认密码">
            <input type="submit" value="登录" class="denglu">
        </form>
    </div>
  </body>
</html>
