package com.sf.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sf.Dao.Newsdao;
import com.sf.DaoImpl.newsimpl;
import com.sf.bean.Newsbean;
import com.sf.bean.PageBean;
@WebServlet("/FirstPageServlet")
public class FirstPageServlet extends HttpServlet {
	Newsdao newdao = new newsimpl();
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
		
		List<Newsbean> listnews = newdao.firstPageNews();
		request.setAttribute("newslist", listnews);
	}

}
