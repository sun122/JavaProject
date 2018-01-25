 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%-- <%@ page import="com.tools.*" %> --%>
<%@ page import="com.sf.bean.PageBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
 PageBean pageBean = (PageBean)request.getAttribute("pagebean");
 %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'page.jsp' starting page</title>
    
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
    <p>
        ${pagebean.currentPage}/${pagebean.totalPage}页
        <a href="userServlet?action=findAllUser&curpage=1">首页</a>
        <c:if test="${pagebean.currentPage > 1}">
        <a href="userServlet?action=findAllUser&curpage=${pagebean.currentPage-1}">上页</a>
        </c:if>
        <c:if test="${pagebean.currentPage < pagebean.totalPage}">
        <a href="userServlet?action=findAllUser&curpage=${pagebean.currentPage+1}">下页</a>
        </c:if>
        <a href="userServlet?action=findAllUser&curpage=${pagebean.totalPage}">末页</a>
    </p>
  </body>
</html>
