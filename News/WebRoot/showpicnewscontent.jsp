<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.sf.bean.Newsbean" %>
<%@ page import="com.sf.bean.PicNewsbean" %>
<%@ page import="com.sf.bean.NewsSpeakbean" %>
<%@ page import="com.sf.bean.Userbean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'shownewcontent.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="CSS/bootstrap.min.css">
    <link rel="stylesheet" href="CSS/index.css">
	<script src="script/jquery-2.1.3.js"></script>
	<script src="script/bootstrap.min.js"></script>
	<style type="text/css">
		body{
			overflow:auto;
		}
		div.max{
			width: 70%;
			margin: 10px auto;
			border: 1px solid #ccc;
			padding: 10px;
			overflow:auto;
		}
		h2,p.datep{
			text-align: center;
			margin: 15px 0 15px 0;
		}
		img{
			display: block;
			margin: 0 auto;
		}
		div.content{
			padding:5px 0; font-family:宋体,黑体;font-size: 16px;
			margin: 15px 0 0 0;
			color : #000;
		}
		footer.down{
        	width:100%;
        	font-size: 15px;
        }

      div.pinglun{
            width: 100%;
            margin: 0 auto;
            border-bottom: 1px solid #ccc;
            padding-bottom: 10px;
            
            position: relative;
        }
        div.pinglun span:last-child{
           position:absolute
            right: 0;
            margin: 0 10px;
        }
        div._pinglun{
        	width: 70%;
			margin: 10px auto;
			border: 1px solid #ccc;
			padding:0 10px;
        }
	</style>
  </head>
  
  <body>
  <div class="max">
  	<% PicNewsbean newpicbean =(PicNewsbean) request.getAttribute("newscontent");%>
    <h2><%=newpicbean.getPicNewsTitle()%></h2>
    <input type="hidden" value="<%=newpicbean.getPicNewsId() %>" class="newsid"/>
    <p class="datep">发布日期：<%=newpicbean.getPicNewsDate()%>&nbsp;&nbsp;&nbsp;&nbsp;作者：<%=newpicbean.getAuthor() %></p>
    <img alt="" src="<%=newpicbean.getPicNewsAddress()%>">
    <div class="content">&nbsp;&nbsp;<%=newpicbean.getPicNewsContent() %></div> 
  </div>
  
  <div class="titleh" style="width: 70%;margin: 5px auto;cursor: default;">查看评论</div>
<div class="_pinglun" style="display: block; display: none;">
    <div class="pinglun">
        <h5>名称</h5>
        <span class="content"></span>
        <span>时间</span>
    </div>
</div>

<div class="pinglunmax" style="margin: 0 auto;width:70%;z-index: 0;"><!-- 发表评论 -->
	<form action="" method="get">
		<textarea rows="3" cols="120" name="pinglunContent" class="pinglunContent" placeholder="请先登录" style="border: 1px solid red;"></textarea>
		<input type="submit" value="发表"style="display: block;margin: 10px 0;border: none">
	</form>
</div>
<template>
	<div class="pinglun">
        <h5>{username}</h5>
        <span class="content">{content}</span>
    </div>
</template>

<footer class="down">
    	Copyright © Copyright © 重庆文理学院软件工程学院 | 渝ICP备05001037号 | 技术支持：023-61162711 | 渝ICP备05001037号 | 技术支持：023-61162711
	</footer> 

</body>
<script type="text/javascript">
    $('div.titleh').click(function(){//当点击查看评论是显示所有评论
    	$('div._pinglun').toggle();
    	
    });
    
    function showpinglun(){
    	var id = $('input.newsid').val().trim();
		var templatehtml = $('template').html();
    	var html = '';
		$.post('newscommentServlet',{id:id},function(data){/* 获取新闻类别名称 */	
        	for(var i = 0;i<data.length;i++) {
          	 html += templatehtml.replace('{username}',data[i].userName).replace('{content}',data[i].speakContent);
        	};
        	$('div._pinglun').html(html);
    	},"JSON");
    }
    showpinglun();
 	//取得用户名称和用户ID
	var userName="<%=session.getAttribute("username")%>"; 
	var userId = "<%=session.getAttribute("userID")%>";
	 var id = $('input.newsid').val().trim();//新闻ID
	if(userName != "" && userName != "null"){
		$('a.rigist').css({display:"none"});
		$('a.login').css({display:"none"});
		$('a.welcome').text("欢迎你！"+userName);
	}
	//编辑评论框
	var textarea = $('textarea.pinglunContent');
	textarea.click(function(){
		if((userName != "" && textarea != "null")){
			
		}else{
			alert("请登录或注册");
		}
	});
	$('form').submit(function(e){
		e.preventDefault();//阻止默认行为（表单提交）
		if((userName != "null" && textarea.val() != "")){
				var pingluncontent = $('textarea.pinglunContent').val();//评论内容
				$.post('addPicNewspinglunservlet',{newid:id,userid:userId,speakcontent:pingluncontent},function(){
				showpinglun();
			});	
			
		}else{
			alert("请输入内容");
		}
	});
</script>
</html>
