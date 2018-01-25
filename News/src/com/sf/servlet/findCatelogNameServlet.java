package com.sf.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sf.Dao.Catelogdao;
import com.sf.DaoImpl.NewsCatedaoimpl;
import com.sf.bean.NewsCatelogbean;
@WebServlet("/findCatelogNameServlet")
public class findCatelogNameServlet extends HttpServlet {
	Catelogdao catelog = new NewsCatedaoimpl();
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
			doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<NewsCatelogbean> list = catelog.findAllcatelog();
		request.setAttribute("cateloglist", list);
	}

}
