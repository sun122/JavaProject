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
	<style type="text/css">
		 *{
            margin: 0;
            padding: 0;
        }
		div.max{
		width:calc(100% - 230px);
		margin-right:6px;
		align:center;
		 position: fixed;
		 right: 0;
		}
		
		h2{
		 text-align: center;
		  line-height:30px;
		}
	</style>
  </head>
  
  <body>
   <jsp:include page="/admin/index.jsp"></jsp:include>
  <jsp:include page="/servlet/AddImgNewServlet"></jsp:include>
  <%List list =(List)request.getAttribute("imglist"); %>
  
<div class="max">
    	<h2>添加图片</h2><br>
	<form action="AddImgNewServlet" enctype="multipart/form-data" method="post">
		<input type="hidden" name="action" value="addpicnews">
		<input type="text" name="pictitle" placeholder="图片标题">
		<input type="text" name="picdate" placeholder="日期">
		<input type="text" name="author" placeholder="作者">
		 <select name="pic">
		<%		  for (Object s : list) {
	            String str1 = (String) s;
	            %>
	           
	            	<option value="<%=str1%>"><%=str1 %></option>
	            
	        <%} %>
	        </select>
		<textarea rows="25" cols="150" name="content" placeholder="图片内容"></textarea><br><br>
		
	    <input type="submit" value="添加">
	</form>
</div>
  </body>
</html>
