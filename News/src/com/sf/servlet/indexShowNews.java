package com.sf.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sf.Dao.indexShowNewdao;
import com.sf.DaoImpl.indexShowNewdaoimpl;
import com.sf.bean.IndexPageBean;
import com.sf.bean.PageBean;
@WebServlet("/indexShowNews")
public class indexShowNews extends HttpServlet {

	indexShowNewdao indexnew = new indexShowNewdaoimpl();
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
		
		int catelogID=Integer.parseInt(request.getParameter("catelogID"));
		
		//分页
				String curpage = request.getParameter("curpage");
				if(curpage==null || curpage.equals("")){
					curpage = "1";
				}
				IndexPageBean pagebean = new IndexPageBean();
				
				pagebean.setCurrentPage(Integer.parseInt(curpage));  //设置当前页
				pagebean = indexnew.findAllNewsByCatelogId(pagebean,catelogID);
				request.setAttribute("newslist", pagebean.getList());
				request.setAttribute("pagebean", pagebean);
				request.getRequestDispatcher("/showcatelognews.jsp").forward(request, response);
	}

}
