<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.sf.bean.NewsCatelogbean" %>
<%@ page import="com.sf.bean.Newsbean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.sf.bean.IndexPageBean" %>
<%@ page import="com.sf.bean.PicNewsbean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'indexmain.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="CSS/index.css"/>
    <link rel="stylesheet" href="public.css"/>
    <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
    
  </head>
  
  <body>
  	<jsp:include page="/servlet/IndexPicShowServlet"></jsp:include>
    <script src="js/myfocus-2.0.1.min.js"></script>
    <jsp:include page="/servlet/indexCatelog"></jsp:include>
    <jsp:include page="/servlet/FirstPageServlet"></jsp:include>
    <%List<PicNewsbean> listpic = (List)request.getAttribute("piclist");%>
    <%List<Newsbean> listnews = (List)request.getAttribute("newslist"); %>
    <jsp:include page="/servlet/AddImgNewServlet"></jsp:include>
<script>
    myFocus.set({
        id: 'boxID',//焦点图盒子ID
        pattern: 'mF_expo2010',//风格应用的名称
        time: 5,//切换时间间隔(秒)
        trigger: 'click',//触发切换模式:'click'(点击)/'mouseover'(悬停)
        width: 373,//设置图片区域宽度(像素)
        height: 200,//设置图片区域高度(像素)
        txtHeight: 'default'//文字层高度设置(像素),'default'为默认高度，0为隐藏
    });
</script>
    <div class="top">
        <div class="head">
        <% 
         String username =(String) request.getSession().getAttribute("username"); %>
        <% if(username != null){%>
        	<span style="color: red;">欢迎您！[<%=username %>]</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <% } %>
            <a href="login1.html" data-icon="&#xf0da" class="login">登录</a>
           <!--  <a href="" data-icon="&#xf0da" class="login">注册</a> -->
           <span class="rigist">注册</span>
        </div>
    </div><!-- 头部信息 -->
    <div class="nav1">
        <% List<NewsCatelogbean> list =(List) request.getAttribute("cateloglist");
				//判断集合是否有效
				if(list==null || list.size() <1){
					out.print("<tr><td bgcolor='#FFFFFF' colspan='6'>没有任何数据</td></tr>");
				}else{
					//遍历用户集合中的数据
				
					for(NewsCatelogbean catelog:list){
						%>
	           	<a href="indexShowNews?catelogID=<%=catelog.getNewStyleId()%>&curpage=0"><%=catelog.getNewStyleName()%></a>
	    <%
	    	}
	    	}
	    	
	     %>
        <form action="" data-icon="&#xf002"><input type="text"/></form>
    </div>

    <main>
        <div class="up">
            <section class="left">
                <h4>新闻中心 <a href="#">more</a></h4>
                <ul class="list1">
                <%
                for(Newsbean news:listnews){%>
                    <li><a href="ShowNewByIdServlet?newID=<%=news.getNewsId()%>" style="white-space:nowrap;overflow:hidden;text-overflow:ellipsis;">&nbsp;&nbsp;<%= news.getNewsTitle() %></a><span><%=news.getNewsDate() %></span></li>
                   
                 <%} %>
                </ul>
            </section>
 <section class="mid">
  <div id="boxID" class="adv">
        
        <div class="pic">
            <ul class="picjh">
            <% int count =0; 
            for(PicNewsbean piclist:listpic){%>
                <li><a href="?<%=piclist.getPicNewsId()%>"><img src="<%=piclist.getPicNewsAddress() %>" text="<%=piclist.getPicNewsTitle() %>" style="width:373px;height: 100%"/></a></li>
               
               <%
               	count++;
               	if(count==5){
               		break;
               	}
               } %>
            </ul>
        </div>
    </div>
                <h4>图片新闻 <a href="#">more</a><span>&gt;&gt;</span> </h4>
                <figcaption>
                  <%
                  int counts =0;
                  
                  for(PicNewsbean piclist:listpic){counts++;
                  if(counts > 5){
                  
                  %>
                    <a><img src="<%=piclist.getPicNewsAddress() %>" alt="" style="width: 150px;height: 150px;padding:0 5px 10px 5px;"/></a>
                    <a href="news.html" class="aa"><%=piclist.getPicNewsTitle() %></a>
                    <p><%=piclist.getPicNewsContent() %></p> 
                    <%
                    }if(counts==6){break;}
                    } %>
                   
                </figcaption>
                
                <ul class="list2">
                <% int count2=0;for(PicNewsbean piclist:listpic){ count2++;if(count2>6){%>
                <li><a href="FindPicNews_pic?id=<%=piclist.getPicNewsId()%>"><img src="<%=piclist.getPicNewsAddress() %>" style="width:100%;"/></a>
                	<p><%=piclist.getPicNewsTitle() %></p>	<br>
                </li>
               
               <%}} %>
                </ul>
            </section>
        </div>
        <div class="jumu"></div>

    </main>
    <div class="rigest">
 			<form action="registerServlet" method="post">
 				<input type="hidden" name="action" value="reginster"/>
             	<input type="text" name="name" placeholder="用户名">
            	<input type="password" name="password" placeholder="密码">
            	<input type="password" name="password" placeholder="确认密码">
				<input type="hidden" name="userClass" value="普通用户">
            	<button type="submit">立即注册</button>
 			</form>
 	</div>
 	    <div class="login">
        <h3>用户登录</h3>
        <form action="ptuserlogin" method="post" name="form1">
        	 <!-- <input type="hidden" name="action" value="userlogin"> -->
             <input type="text" name="name" placeholder="用户名">
             <input type="password" name="password" placeholder="密码">
            <input type="password" placeholder="确认密码">
            <input type="submit" value="登录">
        </form>
 		</div>
    <div class="footer">
        <div class="bq">
        <dl>
            <dt>关于</dt>
            <a href="javascript:;">品牌故事</a>
            <a href="javascript:;">联系我们</a>
            <a href="javascript:;">版权声明</a>
        </dl>
        <dl>
            <dt>课程</dt>
            <a href="javascript:;">品牌故事</a>
            <a href="javascript:;">联系我们</a>
            <a href="javascript:;">版权声明</a>
        </dl>
        <dl>
            <dt>关注</dt>
            <a href="javascript:;">品牌故事</a>
            <a href="javascript:;">联系我们</a>
            <a href="javascript:;">版权声明</a>
        </dl>
        <dl>
            <dd>

                <span>微信关注</span>
                <img src="images/qrcode.jpg" alt=""/>
            </dd>
        </dl>
            <address>地址：重庆市永川区红河大道319号</address>
        </div>
    </div>
  </body>
  <script type="text/javascript">
  	$('span.rigist').click(function(){
  		$('div.rigest').css({display:"block"});
  		$('div.jumu').css({display:"block"});
  	});
  	$('a.login').click(function(e){
  		e.preventDefault();
  		$('div.login').css({display:"block"});
  		$('div.jumu').css({display:"block"});
  	});
  </script>
</html>
