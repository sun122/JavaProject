<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addcatelog.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<style type="text/css">
		form{
		margin:50px 0;
		}
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
		h2{
		 text-align: center;
		  line-height:50px;
		}
		input{
			
			text-align:center;
			padding:8px 20px;
			width:200px;
		}
		input.last{
		text-align:center;
			padding:7px 20px;
			width:100px;
		}
	</style>
  </head>
  
  <body>
  <jsp:include page="/admin/index.jsp"></jsp:include>
  
   <div class="max">
   <h2>添加新闻类别</h2>
    <form action="CatelogServlet" method="post" name="frm">
    	<input type="hidden" name="action" value="addcatelog">
    	新闻类别名称：<input type="text" name="name">
    	新闻类别描述：<input type="text" name="miaoshu">
    	<input type="submit" value="添加" class="last">
    </form>
   </div>
  </body>
</html>
