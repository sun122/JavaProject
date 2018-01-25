<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.sf.bean.PageBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
 PageBean pageBean = (PageBean)request.getAttribute("pagebean");
 %>
<%@ page import="com.sf.bean.PicNewsbean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'imageNewsBrow.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<style type="text/css">
	 *{
            margin: 0;
            padding: 0;
        }
        
		div.max{
		width:calc(100% - 230px);
		margin-right:6px;
		overflow-y:scroll;
		align:center;
		 position: fixed;
		 right: 0;
		}
		table{
		width:100%;
		border:none;
		align:center;
		cellpadding:0;
		cellspacing:1;
		background: #666666;
		line-height: 25px;
		table-layout: fixed;
		}
		table tr td{
		align:center;
		}
		td.txlrow{
			border:none;
		}
		td.content{
			text-overflow: ellipsis;
  			overflow: hidden;
  			white-space: nowrap;
		}
		h2{
		 text-align: center;
		  line-height:30px;
		}
	</style>
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
  </head>
  
  <body>
  
    <%List<PicNewsbean> list = (List)request.getAttribute("imgnewslist"); %>
    <jsp:include page="/admin/index.jsp"></jsp:include>
    <div class="max">
    	<h2>图片新闻</h2>
        	<form action="DeletImageNews" method="post" name="frm">
    		<table>
    			<tr>
    				<td align="center">图片ID</td>
        			<td align="center">图片标题</td>
        			<td align="center">图片内容</td>
        			<td align="center">图片地址</td>
        			<td align="center">日期</td>
        			<td align="center">作者</td>
        			<td align="center">删除</td>
        			<td align="center">修改</td>
    			</tr>
    			<!-- 获取用户信息集合 -->
    			<%
				//判断集合是否有效
				if(list==null || list.size() <1){
					out.print("<tr><td bgcolor='#FFFFFF' colspan='6'>没有任何数据</td></tr>");
				}else{
					//遍历用户集合中的数据
					for(PicNewsbean pic:list){
						%>
				<tr bgcolor="#DEE5FA">
		       	<td align="center" class="txlrow"><%=pic.getPicNewsId() %></td>
	           	<td align="center" class="txlrow"><%=pic.getPicNewsTitle() %></td>
	           	<td align="center" class="content"><%=pic.getPicNewsContent() %></td>
	           	<td align="center" class="txlrow"><%=pic.getPicNewsAddress()%></td>
	           	<td align="center" class="txlrow"><%=pic.getPicNewsDate()%></td>
	           	<td align="center" class="txlrow"><%=pic.getAuthor()%></td>
	           	<td align="center"><input name="delid" type="checkbox" class="noborder" value="<%=pic.getPicNewsId()%>"/></td>
	           	<td align="center" class="txlrow"><a href="UpdateImgNews?id=<%=pic.getPicNewsId()%>">修改</a></td>
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
        <a href="ImageNewServlet?action=findAllimg&curpage=1">首页</a>
        <c:if test="${pagebean.currentPage > 1}">
        <a href="ImageNewServlet?action=findAllimg&curpage=${pagebean.currentPage-1}">上页</a>
        </c:if>
        <c:if test="${pagebean.currentPage < pagebean.totalPage}">
        <a href="ImageNewServlet?action=findAllimg&curpage=${pagebean.currentPage+1}">下页</a>
        </c:if>
        <a href="ImageNewServlet?action=findAllimg&curpage=${pagebean.totalPage}">末页</a>
         </p>
    </center>
    </div>
  </body>
</html>
