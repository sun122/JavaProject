<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testedit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
  </head>
  
  <body>
    This is my JSP page. <br>
       <form action="" method="post">
       标题：<input id="subject" tabIndex="3" size="45" name="title">
        <textarea rows="10" cols="50" name="content" id="editor1"></textarea>
       <ckeditor:replace replace="content" basePath="ckeditor/"/>
       <input type="submit" value="发表评论"/>
    </form>
  </body>
</html>
