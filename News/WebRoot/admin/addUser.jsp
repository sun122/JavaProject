<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addUser.jsp' starting page</title>
    
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
		h2{
		 text-align: center;
		  line-height:50px;
		}
		input{
			text-align:center;
			padding:8px 20px;
			width:150px;
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
  </head>
  
  <body>
<jsp:include page="/admin/index.jsp"></jsp:include>
    <div class="max">
    	
        <h2>添加用户</h2>
        <form action="userServlet" method="post">
          <input type="hidden" name="action" value="adduser"/>
             <input type="text" name="name" placeholder="用户名">
             <input type="password" name="password" placeholder="密码">
            <input type="password" name="password" placeholder="确认密码">
			<select name="userClass">
				<option value="普通用户">普通用户</option>
				<option value="管理员">管理员</option>
			</select>
            <input type="submit" value="添加用户" class="last">
        </form>
    </div>
</body>
</html>
