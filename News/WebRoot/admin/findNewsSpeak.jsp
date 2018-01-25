<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="com.sf.bean.NewsSpeakbean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'findNewsSpeak.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript">
		function CheckAll(elementsA,elementsB){
			for(i = 0;i<elementsA.length;i++){
				elementsA[i].checked = true;
			}
			if(elementsB.checked == false){
				for(j=0;j<elementsA.length;j++){
					elementsA[j].checked = false;
				}
			}
		}
		//判断用户是否选择了要删除的记录，如果是，则提示“是否删除”；否则提示“前选择要删除的记录”
		function checkdel(delid,formname){
			var flag = false;
			for(i=0;i<delid.length;i++){
				if(delid[i].checked){
					flag = true;
					break;
				}
			}
			if(!flag){
				alert("请选择要删除的记录!");
				return false;
			}else{
				if(confirm("确定要删除吗？")){
					formname.submit();
				}
			}
		}
	</script>
	<style type="text/css">
		 *{
            margin: 0;
            padding: 0;
        }
		div.max{
		width:calc(100% - 230px);
		margin-right:6px;
		align:center;
		 position: fixed;
		 overflow: auto;
		 right: 0;
		 height: 100%;
		}
		table{
		width:100%;
		border:none;
		align:center;
		cellpadding:0;
		cellspacing:1;
		background: #666666;
		line-height: 25px;
		}
		table tr td{
		align:center;
		}
		td.txlrow{
			border:none;
		}
		h2{
		 text-align: center;
		  line-height:30px;
		}
		body {
			
}
	</style>
  </head>
  
  <body>
  <jsp:include page="/admin/index.jsp"></jsp:include>
     <div class="max">
    	<h2>用户评论信息</h2>
    	    <form action="" method="post" style="float: right;padding-right:30px">
    			<input type="hidden" name="action" value="findByUserClass">
    				  根据新闻标题查询：<select name="userClass">
    	  	
            		<option value="普通用户" >普通用户</option>
            		<option value="管理员">管理员</option>
         		 </select>
        		<input type="submit" value="查询">
    		</form>
    	<form action="DelSpeakServlet" method="post" name="frm">
    		<table>
    			<tr>
    				<td align="center">评论ID</td>
        			<td align="center">评论内容</td>
        			<td align="center">评论日期</td>
        			<td align="center">新闻ID</td>
        			<td align="center">新闻标题</td>
        			<td align="center">用户ID</td>
        			<td align="center">删除</td>
        			
    			</tr>
    			<!-- 获取用户信息集合 -->
    			<%List<NewsSpeakbean> list =(List) request.getAttribute("speakList");
				//判断集合是否有效
				if(list==null || list.size() <1){
					out.print("<tr><td bgcolor='#FFFFFF' colspan='6'>没有任何数据</td></tr>");
				}else{
					//遍历用户集合中的数据
					for(NewsSpeakbean speak:list){
						%>
				<tr bgcolor="#DEE5FA">
		       	<td align="center" class="txlrow"><%=speak.getSpeakId() %></td>
	           	<td align="center" class="txlrow"><%=speak.getSpeakContent() %></td>
	           	<td align="center" class="txlrow"><%=speak.getSpeakDate() %></td>
	           	<td align="center" class="txlrow"><%=speak.getNewsId()%></td>
	           	<td align="center" class="txlrow"><%=speak.getNewstitle()%></td>
	           	<td align="center" class="txlrow"><%=speak.getUserId()%></td>
	           	<td align="center"><input name="delid" type="checkbox" class="noborder" value="<%=speak.getSpeakId()%>"/></td>
	       
		   </tr>
						<%
					}
				}
				%>
    		</table>
    		<footer>
    			<input name="checkbox" type="checkbox" class="noborder" onclick="CheckAll(frm.delid,frm.checkbox)"/>[全选/反选][<a style="color:red;cursor:pointer;"onclick="checkdel(frm.delid,frm)">删除</a>]
    			<div id="ch" style="display:none">
    				<input name="delid" type="checkbox" class="noborder" value="0">
    			</div>
    		</footer>
    	</form>
    	<center>
    		<p>
        ${pagebean.currentPage}/${pagebean.totalPage}页
        <a href="ShowNewSpeakServlet?curpage=1">首页</a>
        <c:if test="${pagebean.currentPage > 1}">
        <a href="ShowNewSpeakServlet?curpage=${pagebean.currentPage-1}">上页</a>
        </c:if>
        <c:if test="${pagebean.currentPage < pagebean.totalPage}">
        <a href="ShowNewSpeakServlet?curpage=${pagebean.currentPage+1}">下页</a>
        </c:if>
        <a href="ShowNewSpeakServlet?curpage=${pagebean.totalPage}">末页</a>
         </p>
    	</center>
    </div>
  </body>
</html>
