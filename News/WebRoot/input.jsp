<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'input.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link type="text/css" href="CSS/smohan.face.css">
	<style type="text/css">
	</style>
	<script type="text/javascript">
		
	</script>
  </head>
  
  <body>
  <div class="max" id="max">
	<form action="" method="post">
		<input type="hidden" name="action" value="addpinglun"/>
		<textarea rows="8" cols="100" style="margin-top:20px; "></textarea><br>
		<input type="submit" value="评论" style="padding:5px; width: 80px;margin-left:640px;margin-top:10px;"/>
	</form>
  </div>
  </body>
</html>
