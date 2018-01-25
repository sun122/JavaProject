<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.sf.bean.PageBean" %>
<%@ page import="com.sf.bean.LunBoBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title></title>
   <!--  <link href="./CSS/bootstrap.css" rel="stylesheet"> -->
    <script src="js/jquery-3.2.1.js"></script>
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
		 right: 0;
		 margin-left:20px;
		}
		table{
		width:100%;
		border:1px solid #ccc;
		align:center;
		cellpadding:0;
		cellspacing:1;
		line-height: 25px;
		}
		table tr td{
		align:center;
		border-bottom: 1px solid #ccc;
		}
		 tr{
		border-bottom:1px solid #ccc;
		}
		td.txlrow{
			border:none;
		}
		h2{
		 text-align: center;
		  line-height:30px;
		}
    </style>
</head>
<body>
<jsp:include page="/admin/index.jsp"></jsp:include>
<div class="max">
	<div class="container">
    <h2>浏览轮播新闻</h2>
    <div class="table-responsive">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>新闻标题</th>
                <!-- <th>新闻内容</th> -->
                <th>发布时间</th>
                <th>发布人</th>
                <th>图片地址</th>
                <th>删除</th>
                <th>查看</th>
                <th>修改</th>
            </tr>
            </thead>
            <tbody>
            
               <% 
                List list = (List)request.getAttribute("lbnews");
                if(list.size()>0){
                	for(int i=0;i<list.size();i++){
                		LunBoBean lun = (LunBoBean)list.get(i);
                	%>
                	<tr>
                		<td><%=lun.getNewstitle()%></td>
                		<%-- <td><%=lun.getNewcontent()%></td> --%>
                		<td><%=lun.getDate()%></td>
                		<td><%=lun.getNewauthor()%></td>
                		<td><%=lun.getNewpicaddr()%></td>
                		<td><input type="checkbox" name=""/></td>
                		<td><a href="#">查看</a></td>
                		<td><a href="#">修改</a></td>
                	</tr>
                	<%}
                }else{
                	out.print("无数据");
                }
                %>

        
            </tbody>
        </table>
    </div>
        <center>
    		<p>
        ${pagebean.currentPage}/${pagebean.getTotalPage()}页
        <a href="showAllLunBoNews?curpage=1">首页</a>
        <c:if test="${pagebean.currentPage > 1}">
        <a href="showAllLunBoNews?curpage=${pagebean.currentPage-1}">上页</a>
        </c:if>
        <c:if test="${pagebean.currentPage < pagebean.totalPage}">
        <a href="showAllLunBoNews?curpage=${pagebean.currentPage+1}">下页</a>
        </c:if>
        <a href="showAllLunBoNews?curpage=${pagebean.totalPage}">末页</a>
         </p>
    </center>
</div>	
</div>
<template>
       <thead>
          <tr bgcolor="#DEE5FA">
             <th>表格标题</th>
             <th>表格标题</th>
             <th>表格标题</th>
          </tr>
       </thead>
       <tbody>
          <tr bgcolor="#DEE5FA">
             <td>表格单元格</td>
             <td>表格单元格</td>
             <td>表格单元格</td>
          </tr>
       </tbody>
</template>
</body>
<script>
/*      $('body').ready(function(){
        var templatehtml = $('template').html();
        var html = '';
        $.getJSON('showAllLunBoNews',function(data){
            for(var i = 0;i<data.length;i++) {
               // html += templatehtml.replace('{name}',data[i].newStyleName);
            };
           // $('#navindex').html(html);
        });     
    }); */
</script>
</html>