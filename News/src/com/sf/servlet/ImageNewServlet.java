package com.sf.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.sf.Dao.ImgNewDao;
import com.sf.DaoImpl.ImgNewDaoImpl;
import com.sf.bean.PageBean;
import com.sf.bean.PicNewsbean;
@WebServlet("/ImageNewServlet")
public class ImageNewServlet extends HttpServlet {
	ImgNewDao img = new ImgNewDaoImpl();
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
		String action = request.getParameter("action");
		System.out.println(action);
		if(action.equals("findAllimg")){
			doFindAllImageNew(request,response);
		}
		if(action.equals("toEdit")){
			doToEdit(request,response);
		}
		if(action.equals("addimg")){
			doAddImg(request,response);
		}if(action.equals("addimgnews")){
			doAddImageNews(request,response);
		}if(action.equals("doUpdateimgnew")){
			doUpdateImgNew(request,response);
		}
		
	}

	private void doUpdateImgNew(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {//����ͼƬ����
		PicNewsbean picbean = new PicNewsbean();
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("picNews_title");
		String content = request.getParameter("picNews_content");
		String auther = request.getParameter("auther");
		String address = request.getParameter("address");
		String picNews_date = request.getParameter("picNews_date");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date datet =null;
		try {
			datet=sdf.parse(picNews_date);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		picbean.setPicNewsId(id);
		picbean.setPicNewsTitle(title);
		picbean.setPicNewsContent(content);
		picbean.setPicNewsDate(picNews_date);
		picbean.setAuthor(auther);
		picbean.setPicNewsAddress(address);
		int row = img.UpdateImgNew(picbean,id);
		request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
	}

	private void doAddImageNews(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String picNews_title = request.getParameter("picNews_title");
		String picNews_content = request.getParameter("picNews_content");
		String auther = request.getParameter("auther");
		String address = request.getParameter("address");
		int newscatelog = Integer.parseInt(request.getParameter("newscatelog"));
		String picNews_date = request.getParameter("date");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date datet =null;
		try {
			datet=sdf.parse(picNews_date);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		PicNewsbean picbean = new PicNewsbean();
		picbean.setPicNewsTitle(picNews_title);
		picbean.setPicNewsContent(picNews_content);
		picbean.setPicNewsDate(picNews_date);
		picbean.setAuthor(auther);
		picbean.setPicNewsAddress(address);
		picbean.setCatelog_id(newscatelog);
		int row = img.InsertImgNew(picbean);
		if(row>0){
			request.getRequestDispatcher("admin/index.jsp").forward(request,response);
		}
	}

	private void doAddImg(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//�����ϴ��ļ������λ��
				String filePath = getServletContext().getRealPath("/")+"Indeximage";
				
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
				request.getRequestDispatcher("admin/AddImg.jsp").forward(request,response);
		
	}

	private void doToEdit(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, NumberFormatException {
		String curpage = request.getParameter("curpage");
		if(curpage==null || curpage.equals("")){
			curpage = "1";
		}
		PageBean pagebean = new PageBean();
						
		pagebean.setCurrentPage(Integer.parseInt(curpage));  //���õ�ǰҳ
		pagebean = img.showAllImgNews(pagebean);
		request.setAttribute("imgnewslist", pagebean.getList());
		request.setAttribute("pagebean", pagebean);
		request.getRequestDispatcher("/admin/doEditImageNews.jsp").forward(request, response);
	}

	private void doFindAllImageNew(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//��ҳ
				String curpage = request.getParameter("curpage");
				if(curpage==null || curpage.equals("")){
					curpage = "1";
				}
				PageBean pagebean = new PageBean();
								
				pagebean.setCurrentPage(Integer.parseInt(curpage));  //���õ�ǰҳ
				pagebean = img.showAllImgNews(pagebean);
				request.setAttribute("imgnewslist", pagebean.getList());
				request.setAttribute("pagebean", pagebean);
				request.getRequestDispatcher("/admin/imageNewsBrow.jsp").forward(request, response);
		
	}
}
