package com.sf.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sf.Dao.ImgNewDao;
import com.sf.DaoImpl.ImgNewDaoImpl;
import com.sf.bean.PicNewsbean;
@WebServlet("/UpdateImgNews")
public class UpdateImgNews extends HttpServlet {
	ImgNewDao img = new ImgNewDaoImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charsets=utf-8");
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charsets=utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		PicNewsbean pic = img.findNewById(id);
		request.setAttribute("pic", pic);
		request.getRequestDispatcher("admin/doEditImageNews.jsp").forward(request, response);
	}

}
