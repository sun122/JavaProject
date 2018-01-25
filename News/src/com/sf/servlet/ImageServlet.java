package com.sf.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {

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
	
		String filePath = getServletContext().getRealPath("/")+"Indeximage";
	System.out.println("图片地址："+filePath);
		String ts = "成功";
		File file = new File(filePath);
		if(!file.exists()){
			file.mkdir();
		}
		
		SmartUpload su = new SmartUpload();
		
		su.initialize(getServletConfig(),request,response);
	
		su.setMaxFileSize(1024*1024*10);
		
		su.setTotalMaxFileSize(1024*1024*100);
	
		su.setAllowedFilesList("txt,jpg,gif");
		
		try {
			su.setDeniedFilesList("rar,jsp,js");
			String myfile = request.getParameter("myfile");
			su.upload();
			int count = su.save(filePath);
			System.out.println("成功上传"+count+"个文件");
			if(count>0){
				request.setAttribute("ti", ts);
			}
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("admin/AddImg.jsp").forward(request,response);
	}

}
