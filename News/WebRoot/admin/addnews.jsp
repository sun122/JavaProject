<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.sf.bean.NewsCatelogbean" %>
<%@ page import="java.util.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addnews.jsp' starting page</title>
    
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
		width:calc(100% - 230px);
		margin:0 auto;
		position: fixed;
	    right: 0;
	    
	    text-align: center;
		}
		p{
		 padding:10px 0;
		}
		h2{
		 text-align: center;
		  line-height:50px;
		}
		input{
			
			text-align:center;
			padding:8px 20px;
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
		input.last{
		text-align:center;
			padding:7px 20px;
			width:100px;
		}
	</style>
	<script language="JavaScript" type="text/javascript" src="admin/My97DatePicker/WdatePicker.js" charset="utf-8"></script>
	<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
  </head>
  <body>
  
    <jsp:include page="/servlet/findCatelogNameServlet"></jsp:include>
    <jsp:include page="/admin/index.jsp"></jsp:include>
    <div class="max">
    	<h2>添加新闻</h2>
    	<form action="servlet/NewSerlet" method="post">
    	<input type="hidden" name="action" value="addnews">
    	<span>新闻标题：</span><input type="text" name="newtitle">
    	<span>作者：</span><input type="text" name="author">
    	<span>新闻类别Id:</span><select name="catelog_id">
    	<% List<NewsCatelogbean> list =(List) request.getAttribute("cateloglist");
    	for(NewsCatelogbean news:list){
		%>
			<option value="<%=news.getNewStyleId()%>"><%=news.getNewStyleId()+" ("+news.getNewStyleName()+")"%></option>		
    	<%} %>
    	</select>
    	<span>请选择年份：</span><input name="datetime" type="date" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/><br>
    	<p>请输入新闻内容:</p><textarea rows="15" cols="120" placeholder="请在这里输入新闻内容" name="newcontent"></textarea><br><br>
    	
    	<input type="submit" value="发布新闻" class="last">
    	</form>
    </div>
  </body>
</html>
