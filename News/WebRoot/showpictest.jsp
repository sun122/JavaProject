<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showpictest.jsp' starting page</title>
    
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
  <jsp:include page="/servlet/AddImgNewServlet"></jsp:include>
  <%List list =(List)request.getAttribute("imglist"); %>
	<form action="ShowindexServlet" enctype="multipart/form-data" method="post">
		<input type="file" id="myfile" name="myfile">
		<input type="submit" value="上传">
	</form>
	<form action="AddImgNewServlet" enctype="multipart/form-data" method="post">
		<input type="hidden" name="action" value="addpicnews">
		 <select name="pic">
		<%		  for (Object s : list) {
	            String str1 = (String) s;
	            %>
	           
	            	<option value="<%=str1%>"><%=str1 %></option>
	            
	        <%} %>
	        </select>
	        <input type="submit" value="添加">
	</form>
	 <%= request.getAttribute("ti") %>
  </body>
</html>
