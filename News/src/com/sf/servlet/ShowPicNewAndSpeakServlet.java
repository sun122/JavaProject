package com.sf.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sf.Dao.ImgNewDao;
import com.sf.Dao.PingLunDao;
import com.sf.DaoImpl.ImgNewDaoImpl;
import com.sf.DaoImpl.PingLunDaoImpl;
import com.sf.bean.NewsSpeakbean;
import com.sf.bean.PicNewsbean;
@WebServlet("/ShowPicNewAndSpeakServlet")
public class ShowPicNewAndSpeakServlet extends HttpServlet {
	ImgNewDao img = new ImgNewDaoImpl();
	/**
      显示图片新闻内容和评论内容
	 */
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
		int id = (Integer) request.getAttribute("id");
		
		PicNewsbean picbean = img.findNewById(id);
		request.setAttribute("newscontent", picbean);	
		
		request.getRequestDispatcher("/showpicnewscontent.jsp").forward(request, response);
	}

}
