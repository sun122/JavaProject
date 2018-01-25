<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'insert_lunbo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="./script/jquery-2.1.3.js"></script>
	<style>
		 *{
            margin: 0;
            padding: 0;
        }
		div.container{
		width:calc(100% - 230px);
		margin:0 auto;
		position: fixed;
	    right: 0;
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
		div.img1 img{
			width: 250px;
		} 
		h2{
		 text-align: center;
		  line-height:30px;
		}
    </style>
  </head>
  
<body>
 <jsp:include page="/admin/index.jsp"></jsp:include> 
<div class="container">
    <div class="panel panel-default">
        <h2>添加轮播新闻</h2>
        <form action="LunBo_Servlet" method="post">
        <table class="table table-bordered">
            <tbody>
            <tr>
                <td>新闻标题：<input type="text" name="newstitle"/></td>
            </tr>
            <tr>
                <td>新闻内容：<textarea rows="1" cols="23" name="newcontent"></textarea></td>
            </tr>
            <tr>
                <td>发布作者：<input type="text" name="newauthor"/></td>
            </tr>
            <tr>
                <td>发布日期：<input type="date" name="date"/></td>
            </tr>
            <tr>
            	<td>新闻图片：<select name="newpicaddr">
            		<option value="">fsfw</option>
            	</select></td>
            </tr>
            </tbody>
        </table>
        <div class="panel-footer"><input type="submit" value="发布" class="submit"/></div>
        </form>
        <div class="img1">
            <img src="" alt="">
        </div>
    </div>
<template>
       <option value="{name}">"{value}"</option>
</template>
</div>
</body>
<script>
     $('body').ready(function(){/* 获取图片地址 */
        var templatehtml = $('template').html();
        var html = '';
        $.getJSON('AddImgNewServlet',function(data){
       
            for(var i = 0;i<data.length;i++) {
                html += templatehtml.replace('{name}',data[i]).replace('{value}',data[i]);
            };
            $('select').html(html);
        });     
    });
     var $imgadd=null;
   // $imgadd=$('select option').val();
    //$('div.img1 img').attr("src",$imgadd);
    $('select').on('change',function () {
        $imgadd=$(this).val();
        $('div.img1 img').attr("src",$imgadd);
   });
   //插入轮播新闻
   $('form').submit(function(e){
   	e.preventDefault();//取消默认行为
   	   	var title = $('form table tbody tr td input').eq(0).val();//新闻标题
   		var newauthor = $('form table tbody tr td input').eq(1).val();//发布作者
   		var date = $('form table tbody tr td input').eq(2).val();//发布日期
   		var picaddress = $('select').val();//图片地址
   		var newcontent =$('textarea').val();//图片内容
     	$.ajax({
           url:'LunBo_Servlet',
           data:{title:title,newauthor:newauthor,date:date,picaddress:picaddress,newcontent:newcontent},
           type:'post',
           dataType:'JSON',//预期服务器返回的数据类型。如果不指定，jQuery 将自动根据 HTTP 包 MIME 信息来智能判断
           success:function(data){
				if(data.length>0){
					alert('新闻添加成功！');
				}
           },
           error:function(e){
              alert(e);
           }
     });
   });
</script>
</html>
