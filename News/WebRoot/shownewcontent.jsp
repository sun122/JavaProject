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
	<style type="text/css">
         body{
    		-webkit-user-select:none;
    		-moz-user-select:none;
    		-ms-user-select:none;
    		user-select:none;
		}
        div.container-fluid{
            width: 73%;
            margin: 0 auto;
        }
        div.lcj_news,div.lcj_tzgg{
            width: 75%;
            margin: 0 auto;
        }
        div.max{
            width: 73%;
            border: 1px solid #ccc;
            margin: 40px auto;
            text-align: center; 
        }
        div.max h2{
        	text-align: center;
        	font-weight: 700;
        	margin: 20px 0;
        	
        }
        div.title{
            text-align: center;

        }
        div.title #title{
            font-weight: 700;
            color: black;
        }
        div.title div.info span{
           line-height: 30px;
        }
        #content img{
            height: 437px;
            border: 0;
        }
        footer.down{
        	width:100%;
        		
        }
		#fenye{
			display: none;
		}
		
		#newslist{
			margin:0 auto;
			border:1px solid #ccc;
			display: none;
			width: 1200px;
			
		}
		div.panel-body{
			position: relative;
			padding: 0;
			margin: 8px;
		}
		div.panel-body img.newspic{
			width: 100px;
			height: 80px;
			margin:0 10px 0 0;
			padding:0;
		}
		div.panel-body span{
			position:absolute;
			padding-top:5px;
			display: inline-block;
		}
		div.panel-body span:first_child{
			position:absolute;
			width:900px;
			padding-top:5px;
			display: inline-block;
			overflow: hidden;
			white-space:nowrap;
			text-overflow:ellipsis;
		}
		div.panel-body span.newsdata{
			position:absolute;
			vertical-align:middle;
			right: 10px;
		}
		div.panel-body p{
			position:absolute;
			width:1005px;
			margin-top:32px;
			display: inline-block;
			overflow: hidden;
			white-space:nowrap;
			text-overflow:ellipsis;
		}
		div.panel-body dl{
		/* 	margin-bottom:20px; */
			margin: 3px;
			padding: 0;
		}
		div.panel-body dl dt span.newsdata{
			color:#428BCA;
			font-weight: 100;
		}
		div.panel-body dl dd{
			 border-bottom: 1px solid #cccccc; 
		}
		div.panel-body dl dd p{
			margin-left: 20px;
		}
		div.panel-footer{
			text-align: center;
			padding: 8px;
			padding: 5px;
			width: 1200px;
			margin: 0 auto;
			display: none;
		}
		div.panel-footer span{
			text-align: center;
			padding: 8px;
			cursor: default;
		}
		#fenye{
			cursor: default;
		}
		#fenye span{
			width: 15px;
			height: 10px;
		}
		#navindex li.choose,#navindex li.choose a{
			 color:red;
			 background-color: rgba(0, 51, 255, 0.69);
		}
		#navindex li.choose:hover a{
			color:red;
		}
		div.content{
			margin-bottom: 25px;
			font-size: 20px;
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
        	width: 73%;
			margin: 10px auto;
			border: 1px solid #ccc;
			padding:0 10px;
        }
	</style>
  </head>
  
<body>
  	<div class="jumu"></div>	<!-- 登录注册的巨幕 -->
    <div class="rigest">
    	<h3>用户注册</h3>
    		<span class="close" id="close"></span>
 			<form action="registerServlet" method="post"> 
 				<!-- <input type="hidden" name="action" value="reginster"/> -->
             	<input type="text" name="name" placeholder="用户名" required">
             	<span class="titleu"></span>
            	<input type="password" name="password" placeholder="密码(6~8位数字与字母的组合)" required  pattern="(?=.*[a-zA-Z])(?=.*[0-9])\S{6,8}">
            	<input type="email" placeholder="邮箱" required name="email"/><span class="titleu1"></span>
				<input type="hidden" name="userClass" value="普通用户">
				<button type="submit">立即注册</button>
 			</form>
 			<span class="ts"></span>
 	</div>
 	<div class="login">
        <h3>用户登录</h3>
        <span class="close" id="close1"></span>
        <form action="ptuserlogin" method="post" name="form1">
        	 <!-- <input type="hidden" name="action" value="userlogin"> -->
             <input type="text" name="name" placeholder="用户名" required">
             <input type="password" name="password" placeholder="密码(6~8位数字与字母的组合)" required pattern="(?=.*[a-zA-Z])(?=.*[0-9])\S{6,8}">
             <input type="password" placeholder="确认密码" required pattern="(?=.*[a-zA-Z])(?=.*[0-9])\S{6,8}">
            <button type="submit">登录</button>
        </form>
        <span class="ts"></span>
 	</div>
 	
<nav class="navbar navbar-inverse navbar-fixed-top lcj" role="navigation">
 		
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand visible-xs" href="#">重庆文理学院</a>
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <form class="navbar-form navbar-left " role="search">
                <div class="form-group">
                    <input type="text" class="form-control hidden-sm" style="width: 300px; placeholder="搜索新闻内容";>
                </div>
                <span class="glyphicon glyphicon-search hidden-sm"></span>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="javascript:;" class="login">登录</a></li>
                <li><a href="javascript:;" class="rigist">注册</a></li>
                <li><a href="#" class="welcome"></a></li>
            </ul>
        </div>
    </div>
</nav>
<header>
    <div class="head2 hidden-xs hidden-sm">
        <div class="container">
            <nav class="navbar navbar-default lcj" style="z-index: 0;">
            	<div style="inline-block;position: absolute;margin-top:8px;"><a href="index.html" style="color:white;font-size: 20px;text-decoration: none;">首页</a></div>
                <ul class="nav navbar-nav" id="navindex">
                	
                </ul>
            </nav>
        </div>
    </div>
</header>
<template><!-- 导航条模板 -->
	<ul class="nav navbar-nav">
        <li><a href="javascript:;" data-id="{id}">{name}</a></li>
   </ul>
</template>
  
<!-- 新闻列表 -->
<div class="panel panel-primary" id="newslist">
    <div class="panel-body">
		<a href="javascript:;"><img src="img/p.jpg" class="newspic" data/><span>wo</span><span class="newsdata">1994-9-9</span></a>
    </div>
</div>
<div class="panel-footer" id="fenye">总页数：<label class="totalnews"></label>页 &nbsp;&nbsp;当前第:<label class="CurrentPage">1</label>页  <span class="first">首页</span><span class="uppage">上一页</span><span class="nextpage">下一页</span><span class="endpage">末页</span></div>

<template class="panelAllNews">
    <div class="panel-body">
		<a href="FindPicNews_pic?id={id}"><img src="{src}" class="newspic"/><span>{picNews_title}</span><span class="newsdata">{data}</span></a>
		<p>{content}</p>
    </div>  
</template>
<template class="panelAllTextNews">
    <div class="panel-body">
    	<dl style="height: 60px;">
    		<dt><a href="ShowNewByIdServlet?id={id}"><span>{news_title}</span></a><span class="newsdata">{data}</span></dt>
    		<dd><p>{content}</p></dd>
    	</dl>
    </div>  
</template>  
  
 <div class="max">
  	 <%Newsbean newbean = (Newsbean)request.getAttribute("newscontent"); %>
    <h2><%=newbean.getNewsTitle()%></h2>
    <input type="hidden" value="<%=newbean.getNewsId() %>" class="newsid">
    <p class="datep">发布日期：<%=newbean.getNewsDate()%>&nbsp;&nbsp;&nbsp;&nbsp;作者：<%=newbean.getAuthor() %></p>
    <div class="content"><%=newbean.getNewsContent() %></div>
    
 </div><!-- 评论 -->
    <div class="titleh" style="width: 73%;margin: 5px auto;cursor: default;">查看评论</div>
<div class="_pinglun" style="display: none;">
    <div class="pinglun">
        <h5>名称</h5>
        <span class="content"></span>
    </div>
</div>

<div class="pinglunmax" style="margin: 0 auto;width:73%;z-index: 0;"><!-- 发表评论 -->
	<form action="" method="get">
		<textarea rows="3" cols="120" name="pinglunContent" class="pinglunContent" placeholder="请先登录" style="border: 1px solid red;"></textarea>
		<input type="submit" value="发表"style="display: block;margin: 10px 0;border: none">
	</form>
</div>
<template class="pinglun">
	<div class="pinglun">
        <h5>{username}</h5>
        <span class="content">{content}</span>
    </div>
</template>
    
 	<footer class="down">
   		 Copyright © 重庆文理学院软件工程学院 | 渝ICP备05001037号 | 技术支持：023-61162711
	</footer>

</body>
<script src="script/jquery-2.1.3.js"></script>
<script src="script/bootstrap.min.js"></script>
<script charset="utf-8" src="script/login_regist.js"></script>
<script>
	$('body').ready(function() {
	var templatehtml = $('template').html();
	var html = '';
	$.getJSON('indexCatelog',function(data){/* 获取新闻类别名称 */	
	    for(var i = 0;i<data.length;i++) {
	        html += templatehtml.replace('{name}',data[i].newStyleName).replace('{id}',data[i].newStyleId);/* 取得新闻类别名称 */
	   	};
	   	 $('#navindex').html(html);
		});
	});
	
	//查看指定新闻类别下的新闻列表内容
	var id = 0;
	var CurrentPage = 1;
	var pictotal = 0;//总的图片新闻记录
	var texttotal = 0;//总的文本新闻
	var totalnews = 0;//指定id下的所有新闻记录
	var totalpage =0; //总页数
	//子页面查询所有新闻
	function queryallnews(){	
		$('div.max').css({display:"none"});
		 $('div._pinglun').css({display:"none"});
		 $('div.titleh').css({display:"none"});
		 $('div.pinglunmax').css({display:"none"});
		$('#newslist').css({display:"block"});
		$('div.panel-footer').css({display:"block"});
		
		var temphtml = $('template.panelAllNews').html();/* 图片新闻 */
		var temtextnewhtml = $('template.panelAllTextNews').html();/* 文本新闻 */
		var temtexthtml = '';/* 文本新闻 */
		var temhtml ='';	/* 图片新闻 */
		
		if(id !=null || id != "" || id != "idundefined"){
/* 			$.post('FindAllnews_picnewsByCIdSevlet',{id:id,CurrentPage:CurrentPage},function(data){
				for(var i=0;i<data.length-1;i++){
					temhtml += temphtml.replace('{id}',data[i].picNews_id).replace('{picNews_title}', data[i].picNews_title).replace('{data}',data[i].picNews_date).replace('{src}',data[i].picNews_address).replace('{content}',data[i].picNews_content);
				}
			},"JSON"); */
			$.ajax({
				type:'post',
				url:'FindAllnews_picnewsByCIdSevlet',
				//async:true,
				dataType:'JSON',
				data:{id:id,CurrentPage:CurrentPage},
				success:function(data){
					
					for(var i=0;i<data.length-1;i++){
						temhtml += temphtml.replace('{id}',data[i].picNews_id).replace('{picNews_title}', data[i].picNews_title).replace('{data}',data[i].picNews_date).replace('{src}',data[i].picNews_address).replace('{content}',data[i].picNews_content);
					}
					for(var i = data.length;i>=data.length;i--){
						var len = data.length-1;
						pictotal = data[len];//总的图片新闻记录
						
					}				
				},
				complete:function(info){
					$.post('indexAllNewsTextServlet',{id:id,CurrentPage:CurrentPage},function(data){
						for(var i=0;i<data.length-1;i++){
							temtexthtml += temtextnewhtml.replace('{id}',data[i].news_id).replace('{news_title}', data[i].news_title).replace('{data}',data[i].news_date).replace('{content}',data[i].news_content);
						}
						for(var i = data.length;i>=data.length;i--){
							var leng = data.length-1;
							texttotal = data[leng];//总的文本新闻记录
							
							totalnews = (texttotal+pictotal);//总的新闻记录
							$('label.totalnews').text(totalnews);
							
							totalpage =Math.ceil((totalnews/8));//总页数
							$('label.totalnews').text(totalpage);
						}
						var thtml = temhtml + temtexthtml;
						$('#newslist').html(thtml);
					},"JSON");
				}
			});
		}
	}
	//导航条单击事件
	$('#navindex').on('click','a',function(){
		CurrentPage = $('label.CurrentPage').text();//获取当前页
		var li =$(this);
		id = li.attr("data-id");
		queryallnews();
		
		li.parent().addClass("choose");
 		$("li").each(function(index){
            $(this).click(function(){
                $("li").removeClass("choose");
                $("li").eq(index).addClass("choose");
            });
        }); 
	});
//////////////////分页
		$('#fenye').on('click','span',function(){
		var classname = $(this).attr('class');
		switch(classname){
			case 'first':
			if(CurrentPage>1){
				CurrentPage = 1;
				queryallnews();
			}
			break;
			case 'uppage':
			if(CurrentPage>1){
				CurrentPage=(CurrentPage-1);
				queryallnews();		
			}
			break;
			case 'nextpage':
			
			if(CurrentPage<totalpage){
				CurrentPage=(parseInt(CurrentPage)+1);
				queryallnews();
			}
			break;
			case 'endpage':
			if(CurrentPage<=totalpage){
				CurrentPage=totalpage;
				queryallnews();
			}
			break;
		}
		$('label.CurrentPage').text(CurrentPage);//当前在地几条记录
	});	
	
	//评论
    $('div.titleh').click(function(){//当点击查看评论是显示所有评论
    	$('div._pinglun').toggle();
    });
    var id = $('input.newsid').val().trim();//新闻ID
    function showpinglun(){
    	
		var templatehtmlpinglun = $('template.pinglun').html();

    	var htmlpl = '';
		$.post('textnewspinglunservlet',{id:id},function(data){/* 获取新闻类别名称 */	
       	for(var i = 0;i<data.length;i++) {
         	htmlpl += templatehtmlpinglun.replace('{username}',data[i].userName).replace('{content}',data[i].speakContent);
       	};
         	$('div._pinglun').html(htmlpl);
    	},"JSON");
    }
    showpinglun();
	//取得用户名称和用户ID
	var userName="<%=session.getAttribute("username")%>"; 
	var userId = "<%=session.getAttribute("userID")%>";
	
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
				$.post('addTextNewsPingLunServlet',{newid:id,userid:userId,speakcontent:pingluncontent},function(){
				showpinglun();
			});	
			
		}else{
			alert("请输入内容");
		}
	});

</script>
</html>