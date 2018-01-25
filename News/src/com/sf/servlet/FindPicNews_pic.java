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
@WebServlet("/FindPicNews_pic")
public class FindPicNews_pic extends HttpServlet {
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
		int id = Integer.parseInt(request.getParameter("id"));

		PicNewsbean picbean = img.findNewById(id);
		request.setAttribute("newscontent", picbean);
		
		//≤È’“∆¿¬€
		
		PingLunDao pinglun = new PingLunDaoImpl();
		List<NewsSpeakbean> pinglist = pinglun.findPicPingLun(id);
		request.setAttribute("pinglunlist", pinglist);
		
		request.getRequestDispatcher("/showpicnewscontent.jsp").forward(request, response);
	}

}
