package com.sf.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
@WebServlet("/ShowindexServlet")
public class ShowindexServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//设置上传文件保存的位置
		String filePath = getServletContext().getRealPath("/")+"images";
		System.out.println("路径"+getServletContext().getRealPath("/")+"images");
		String ts = "上传成功";
		File file = new File(filePath);
		if(!file.exists()){
			file.mkdir();
		}
		
		SmartUpload su = new SmartUpload();
		//初始化对象
		su.initialize(getServletConfig(),request,response);
		//设置上传文件的大小
		su.setMaxFileSize(1024*1024*10);
		//设置所有文件的大小
		su.setTotalMaxFileSize(1024*1024*100);
		//设置允许上传的文件类型
		su.setAllowedFilesList("txt,jpg,gif");
		
		try {
			su.setDeniedFilesList("rar,jsp,js");
			String myfile = request.getParameter("myfile");
			su.upload();//上传文件
			int count = su.save(filePath);
			System.out.println("上传成功"+count+"文件");
			if(count>0){
				request.setAttribute("ti", ts);
			}
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//上传文件
 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/////
		File f = new File(getServletContext().getRealPath("/")+"images");
		String str[] = f.list();//列出给定目录的内容名
		List piclist = new ArrayList();
		for(int i=0;i<str.length;i++){
			
			String path = "images/"+str[i];
			piclist.add(path);
		}
		request.setAttribute("imglist", piclist);
		
		request.getRequestDispatcher("/showpictest.jsp").forward(request,response);
	}
}
