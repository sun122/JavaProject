<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.sf.bean.NewsCatelogbean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'doEditCatelog.jsp' starting page</title>
    
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
    	<h2>新闻类别名称修改</h2>
    	<% NewsCatelogbean catelog =(NewsCatelogbean) request.getAttribute("catelogbean");%>
    	<form action="CatelogServlet?action=doEdit" method="post">
    		<input type="text" name="id" value="<%=catelog.getNewStyleId()%>" readonly="readonly"/><br>
    		<input type="text" name="title" value="<%=catelog.getNewStyleName()%>"/><br>
    		<input type="text" name="miaoshu" value="<%=catelog.getMiaoShu()%>"/><br>
    		<input type="submit" value="修改"/> 
    	</form>
    </center>
    </div>
  </body>
</html>
