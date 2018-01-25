package com.sf.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sf.Dao.SpeakDao;
import com.sf.DaoImpl.findAllSpeakImpl;
import com.sf.bean.PageBean;
@WebServlet("/ShowNewSpeakServlet")
public class ShowNewSpeakServlet extends HttpServlet {
	SpeakDao speakdao = new findAllSpeakImpl();
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
		
		//分页
		String curpage = request.getParameter("curpage");
		if(curpage==null || curpage.equals("")){
			curpage = "1";
		}
		PageBean pagebean = new PageBean();
				
		pagebean.setCurrentPage(Integer.parseInt(curpage));  //设置当前页
		pagebean = speakdao.findAllSpeak(pagebean);
		request.setAttribute("speakList", pagebean.getList());
		request.setAttribute("pagebean", pagebean);
		request.getRequestDispatcher("/admin/findNewsSpeak.jsp").forward(request, response);
	}

}
