<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.sf.bean.PicNewsbean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'doEditImageNews.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/jquery-3.2.1.js"></script>
  </head>
  	<style>
/*   	*{
  		padding:0;
  		margin:0;
  	}
  	div.max{
		 align:center;
		 right: 0;
		 
		 width:calc(100% - 500px);
		 /* margin-left:calc(100% - 650px); */
		 margin:0 auto;
		 margin-top:-650px
	}
	div.img1 img{
		width: 200px;
		height: 150px;
	} */
  	</style>
  <body>
      <jsp:include page="/admin/index.jsp"></jsp:include>
      <jsp:include page="/servlet/AddImgNewServlet"></jsp:include>
      <%List list =(List)request.getAttribute("imglist"); %>
      <div class="max">
      	<center>
    	<h2>图片新闻修改</h2><br>
    	<% PicNewsbean pic =(PicNewsbean) request.getAttribute("pic");%>
    	<form action="ImageNewServlet" method="post">
    		<input type="hidden" name="action" value="doUpdateimgnew">
    		<span>Id:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><input type="text" name="id" value="<%=pic.getPicNewsId()%>" readonly="readonly"/><br>
    		<span>标题：</span><br><textarea rows="3" cols="100" name="picNews_title"><%=pic.getPicNewsTitle()%></textarea><br>
    		<span>内容：</span><br><textarea rows="8" cols="100" name="picNews_content"><%=pic.getPicNewsContent()%></textarea><br><br>
    		<span>日期：</span><input type="date" name="picNews_date" value="<%=pic.getPicNewsDate()%>"/>
    		<span>作者：</span><input type="text" name="auther" value="<%=pic.getAuthor()%>"/>
    		地址：<select name="address">
		<%		  for (Object s : list) {
	            String str1 = (String) s;
	            %>
	            	<option value="<%=str1%>"><%=str1 %></option>
	        <%} %>
	        </select><br><br>
	    <div class="img1" style="width:80px;margin:0 auto;">
            <img src="" alt="">
        </div>
    		<input type="submit" value="修改" style="padding:7px;margin:5px auto;"/> 
    	</form>
    </center>
   </div>
  </body>
<script>
    var $imgadd=null;
    $imgadd=$('select option').val();
    $('div.img1 img').attr("src",$imgadd);
    $('select').on('change',function () {
        $imgadd=$(this).val();
        $('div.img1 img').attr("src",$imgadd);
   });
</script>
</html>
