<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.sf.bean.Userbean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'browseAllUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script src="js/jquery-3.2.1.js"></script>
    <style type="text/css">
        *{
            margin: 0;
            padding: 0;
        }
        body,html{
        	width: 100%;
        	height: 100%;
        }
        #left{
        	position:absolute;
            padding-left: 15px;;
            width: 200px;
			left:0px;
			bottom:0;
			top:57px;
            background-color: #aaccf6;
            cursor: default;
        }
        dd{
            margin-left:10px;
            border-bottom: 1px dashed #61704b;
        }
        dd a:hover{
            color: red;
        }
        dl{
            padding: 5px 8px;
            border: none;
        }
        dl dd a,dl dd a:visited{
            text-decoration: none;
            color: #0d0e82;
        }
        div.top{
            width: 100%;
            padding-left: 10px;
            color: white;
            background-color: #0066cc;
            line-height: 50px;
            display: flex;
            justify-content: space-between;
        }
        div.top h4{
            display: inline;
            vertical-align: middle;
        }
        div.img{
            display: inline;
            border: none;
        }
        div.img img{
            border-radius: 50px;
            width: 45px;
            height: 45px;
            border: 1px solid red;
            vertical-align: middle;
            margin: 5px 30px 5px 5px;
            right: 0;
        }

        dl dt.show:before{
            content:"";
            border: 5px solid transparent;
            border-bottom: 5px solid red;
            transform: rotate(0deg);
            position: absolute;
            margin-top: 4px;
            margin-left:-15px;
        }
        dl dt.hidle:before{
            content:"";
            border: 5px solid transparent;
            border-bottom: 5px solid red;
            transform: rotate(180deg);
            position: absolute;
            margin-top: 9px;
            margin-left:-15px;
           
        }
        dl dd{
            display: none;
        }
         dl dd.show{
            display:block;
             padding: 3px 0;
        }
    </style>

    <script language="javascript">
        function screenInfo(){
            var  s = "";
            s = window.screen.availHeight;
            document.getElementById("left").style.height=s + "px";

        }
    </script>
  </head>
  
  <body>
 	<div class="top">
    <h4>网站后台管理系统</h4>
    <div class="img">
    <span>
	<% String username =(String) request.getSession().getAttribute("username"); %>
        <% if(username != null){%>
        	<span style=" color: white;">欢迎您！[<%=username %>]</span>
       <% } %>
	</span><img src="img/p.jpg" alt=""></div>
</div>
<div id="left">
    <dl>
        <dt class="show">用户管理</dt>
        <dd> <a href="userServlet?action=findAllUser&curpage=0">浏览所有用户</a></dd>
        <dd><a href="admin/addUser.jsp">增加管理员</a></dd>
    </dl>
    <dl>
        <dt class="show">新闻类别名称</dt>
        <dd> <a href="CatelogServlet?action=findAllcatelog&curpage=0">浏览所有新闻类别名称</a></dd>
        <dd><a href="admin/addcatelog.jsp">添加新闻类别</a></dd>
    </dl>
    <dl>
        <dt class="show">新闻</dt>
        <dd><a href="findAllNewServlet?curpage=0">新闻浏览</a></dd>
        <dd><a href="admin/addnews.jsp">添加新闻</a></dd>
    </dl>
    <dl>
        <dt class="show">新闻评论</dt>
        <dd><a href="ShowNewSpeakServlet?curpage=0">查看新闻评论</a></dd>
    </dl>
    <dl>
        <dt class="show">前端图片新闻管理</dt>
        <dd><a href="ImageNewServlet?action=findAllimg&curpage=0">浏览图片新闻</a></dd>
        <dd><a href="admin/addimagenews.jsp">添加图片新闻</a></dd>
        <dd><a href="admin/AddImg.jsp">添加图片</a></dd>
    </dl>
    <dl>
    	<dt class="show">轮播新闻管理</dt>
    	<dd><a href="showAllLunBoNews?curpage=0">轮播新闻浏览</a></dd>
        <dd><a href="admin/insert_lunbo.jsp">添加轮播新闻</a></dd>
    </dl>
</div>


</body>
<script type="text/javascript">
    var $imgadd=null;
    $imgadd=$('select option').val();
    $('div.img img').attr("src",$imgadd);
    $('select').on('change',function () {
        $imgadd=$(this).val();
        $('div.img img').attr("src",$imgadd);
        console.log($imgadd);
   });
    $(function () {
        $('#left dl dd').addClass('show');
    })
    $('#left dl dt').on('click' ,function (e) {
        e.stopPropagation();
        $(this).nextAll().toggleClass("show");
        $(this).toggleClass("hidle");
    });
</script>
</html>
