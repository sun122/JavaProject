<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.sf.bean.Newsbean" %>
<%@ page import="com.sf.bean.NewsCatelogbean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updatenews.jsp' starting page</title>
    
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
		text-align:center;
		align:center;
		 position: fixed;
		 right: 0;
		}
		h3{
		text-align:center;
		padding-bottom:15px;
		}
		p{
		text-align:center;
		line-height: 35px;
		}
		div.content{
			padding:0 10px;
		}
		input{
			
			text-align:center;
			padding:8px 10px;
			width:150px;
		}
		span{
		align:top;
		padding:0 10px;
		}
		textarea{
			padding:8px 13px;
		}
		select{
			text-align:center;
			padding:8px 20px;
		}
	</style>
	<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
  </head>
  
  <body>
     <jsp:include page="/admin/index.jsp"></jsp:include>
     <jsp:include page="/servlet/findCatelogNameServlet"></jsp:include>
    <% Newsbean newbean = (Newsbean)request.getAttribute("newbean");%>
    <div class="max">
    	<h3>新闻修改</h3>
    	<form action="servlet/NewSerlet" method="post">
    	<input type="hidden" name="action" value="doEideNew">
    	<span>新闻id号：</span><input type="text" name="newid" value="<%=newbean.getNewsId()%>" readonly="readonly">
    	<span>作者：</span><input type="text" name="author" value="<%=newbean.getAuthor()%>">
    	<span>新闻类别Id:</span><select name="catelog_id">
    	
    	<% List<NewsCatelogbean> list =(List) request.getAttribute("cateloglist");
    	for(NewsCatelogbean news:list){
		%>
			<option value="<%=news.getNewStyleId()%>"><%=news.getNewStyleId()+" ("+news.getNewStyleName()+")"%></option>		
    	<%} %>
    	</select>
    	<span>发布日期:</span><input type="date" name="datetime" value="<%=newbean.getNewsDate()%>"><br>
    	<p>新闻标题：</p><textarea rows="1" cols="120" name="newtitle"><%=newbean.getNewsTitle() %></textarea>
    	<p>新闻内容：</p><textarea rows="25" cols="120" name="newcontent"><%=newbean.getNewsContent() %></textarea><br><br>
    	<ckeditor:replace replace="newcontent" basePath="./ckeditor/"/>
    	<input type="submit" value="修改">
    	</form>
    </div>
  </body>
</html>
