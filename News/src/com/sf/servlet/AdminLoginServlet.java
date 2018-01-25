package com.sf.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sf.Dao.Userdaoinferce;
import com.sf.DaoImpl.Userdaoimpl;
import com.sf.bean.Userbean;
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {

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
		
		String username=request.getParameter("name");
		String password=request.getParameter("password");
		
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		
		Userdaoinferce useradd = new Userdaoimpl();
		
		Userbean userbean=useradd.findUser(username, password);

		if(userbean.getName()!=null && userbean.getPassword() !=null){
			if(userbean.getUserClass().equals("π‹¿Ì‘±")){
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("/admin/index.jsp");
			requestdispatcher.forward(request, response);
		
			session.setAttribute("userbean", userbean);
			}
		}else{
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("/error.jsp");
			requestdispatcher.forward(request, response);
		}
	}

}
