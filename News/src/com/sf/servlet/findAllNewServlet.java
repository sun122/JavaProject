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
@WebServlet("/findAllNewServlet")
public class findAllNewServlet extends HttpServlet {
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
		
		//分页
		String curpage = request.getParameter("curpage");
		if(curpage==null || curpage.equals("")){
			curpage = "1";
		}
		PageBean pagebean = new PageBean();
				
		pagebean.setCurrentPage(Integer.parseInt(curpage));  //设置当前页
		pagebean = newdao.findAllNews(pagebean);
		request.setAttribute("newslist", pagebean.getList());
		request.setAttribute("pagebean", pagebean);
		request.getRequestDispatcher("/admin/newBrows.jsp").forward(request, response);
		
		//未分页
//		List<Newsbean> list = newdao.findAllNews();
//		request.setAttribute("newslist", list);
	}

}
