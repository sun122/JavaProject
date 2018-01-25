<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.sf.bean.Newsbean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'findnewcontent.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	 *{
            margin: 0;
            padding: 0;
        }
		div.max{
		padding-top:15px;
		width:calc(100% - 230px);
		margin-right:6px;
		overflow:auto;
		height:100%;
		align:center;
		 position: fixed;
		 right: 0;
		}
		h3{
		text-align:center;
		}
		p{
		text-align:center;
		line-height: 35px;
		}
		div.content{
			padding:0 10px;
		}
	</style>
  </head>
  
  <body>
    <jsp:include page="/admin/index.jsp"></jsp:include>
    <% Newsbean newbean = (Newsbean)request.getAttribute("newsbean");%>
    <div class="max">
    	<h3><%=newbean.getNewsTitle() %></h3>
    	<p>发布日期：<%=newbean.getNewsDate() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作者：<%=newbean.getAuthor() %></p>
    	<div class="content"><%=newbean.getNewsContent() %>	</div>
    </div>
  </body>
</html>
