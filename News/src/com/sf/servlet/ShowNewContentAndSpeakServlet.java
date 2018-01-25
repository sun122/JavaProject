package com.sf.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sf.Dao.IndexShowNewContent;
import com.sf.Dao.PingLunDao;
import com.sf.DaoImpl.IndexShowNewContentImp;
import com.sf.DaoImpl.PingLunDaoImpl;
import com.sf.bean.NewsSpeakbean;
import com.sf.bean.Newsbean;
@WebServlet("/ShowNewContentAndSpeakServlet")
public class ShowNewContentAndSpeakServlet extends HttpServlet {
	IndexShowNewContent shownew = new IndexShowNewContentImp();
	PingLunDao pinglun = new PingLunDaoImpl();
	/**
		在用户进行评论后显示新闻内容和评论内容
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
		int newid = (Integer) request.getAttribute("newID");
		Newsbean newbean = shownew.showNewContent(newid);
		request.setAttribute("newscontent", newbean);
		
		//
		//查找评论
		List<NewsSpeakbean> pinglist = pinglun.findByPingLun(newid);
		request.setAttribute("pinglunlist", pinglist);
		
		request.getRequestDispatcher("/shownewcontent.jsp").forward(request, response);
	}

}
