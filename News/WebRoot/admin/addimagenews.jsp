<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.sf.bean.PicNewsbean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PU0BLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addimagenews.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="./script/jquery-2.1.3.js"></script>
	
	<style type="text/css">
/* 		div.max{
		 align:center;
		 right: 0;
		 
		 width:1000px;
		 margin:0 auto;
		 margin-top:-650px
		}*/
		div.img1 img{
			width: 250px;
		} 
	</style>
  </head>
  
  <body>
     <jsp:include page="/admin/index.jsp"></jsp:include>
      <!-- <jsp:include page="/servlet/AddImgNewServlet"></jsp:include> -->
      <%List list =(List)request.getAttribute("imglist"); %>
      <div class="max">
     <center>
    	<h2>添加图片新闻</h2><br>
    	<% PicNewsbean pic =(PicNewsbean) request.getAttribute("imgnewslist");%>
    	<form action="ImageNewServlet" method="post">
    		<input type="hidden" name="action" value="addimgnews">
    		<span>Id:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><input type="text" name="id" readonly="readonly"/><br>
    		<span>标题：</span><br><textarea cols="100" rows="2"  name="picNews_title"></textarea><br>
    		<span>内容：</span><br><textarea  rows="8" cols="100" name="picNews_content"></textarea><br><br>
    		<span>日期：</span><input type="datetime" text" name="date"/>
    		<span>作者：</span><input type="text" name="auther"/>
    		 <tr>
                <td>新闻类型：<select name="newscatelog" class="newcatelog">
            		<option value="" id="newcatelog"></option>
            	</select></td>
            </tr>       
	                         新闻图片：<select name="address">
            		<option value=""></option>
            	</select>
	    <div class="img1">
            <img src="" alt="">
        </div>
    		<input type="submit" value="添加" style="padding:7px;margin:5px auto;background:#ccc;border:none"/> 
    	</form>
    </<center>
   
    
     <template>
       <option value="{name}">"{value}"</option>
	</template>
	<template class="catelogname">
		<option value="{id}" id="newcatelog">{content}</option>
	</template>
  </body>
<script>   
     $('body').ready(function(){/* 获取图片地址 */
         var templatehtml = $('template').html();
        var html = '';
        $.getJSON('AddImgNewServlet',function(data){
       		console.log(data.length);
            for(var i = 0;i<data.length;i++) {
                html += templatehtml.replace('{name}',data[i]).replace('{value}',data[i]);/* 取得新闻类别名称 */
            };
            $('select').html(html);
        });
        
        //预览图片
    var $imgadd=null;
    $imgadd=$('select option').val();
    $('select').eq(1).on('change',function () {
    $imgadd=$(this).val();
    $('div.img1 img').attr("src",$imgadd);
    });
   
           ////
        var temp = $('template.catelogname').html();
        var htmlca ='';	
        $.getJSON('indexCatelog',function(data){/* 获取新闻类别名称 */
            for(var i = 0;i<data.length;i++) {
            	
                htmlca += temp.replace('{id}',data[i].newStyleId).replace('{content}',data[i].newStyleName);/* 取得新闻类别名称 */
            };
            $('select.newcatelog').html(htmlca);
        });    
});

</script>
</html>
