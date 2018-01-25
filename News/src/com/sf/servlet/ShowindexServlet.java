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
		//�����ϴ��ļ������λ��
		String filePath = getServletContext().getRealPath("/")+"images";
		System.out.println("·��"+getServletContext().getRealPath("/")+"images");
		String ts = "�ϴ��ɹ�";
		File file = new File(filePath);
		if(!file.exists()){
			file.mkdir();
		}
		
		SmartUpload su = new SmartUpload();
		//��ʼ������
		su.initialize(getServletConfig(),request,response);
		//�����ϴ��ļ��Ĵ�С
		su.setMaxFileSize(1024*1024*10);
		//���������ļ��Ĵ�С
		su.setTotalMaxFileSize(1024*1024*100);
		//���������ϴ����ļ�����
		su.setAllowedFilesList("txt,jpg,gif");
		
		try {
			su.setDeniedFilesList("rar,jsp,js");
			String myfile = request.getParameter("myfile");
			su.upload();//�ϴ��ļ�
			int count = su.save(filePath);
			System.out.println("�ϴ��ɹ�"+count+"�ļ�");
			if(count>0){
				request.setAttribute("ti", ts);
			}
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//�ϴ��ļ�
 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/////
		File f = new File(getServletContext().getRealPath("/")+"images");
		String str[] = f.list();//�г�����Ŀ¼��������
		List piclist = new ArrayList();
		for(int i=0;i<str.length;i++){
			
			String path = "images/"+str[i];
			piclist.add(path);
		}
		request.setAttribute("imglist", piclist);
		
		request.getRequestDispatcher("/showpictest.jsp").forward(request,response);
	}
}
