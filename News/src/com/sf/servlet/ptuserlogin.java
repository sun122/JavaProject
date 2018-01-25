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

import net.sf.json.JSONObject;

import com.sf.Dao.Userdaoinferce;
import com.sf.DaoImpl.Userdaoimpl;
import com.sf.bean.Userbean;
@WebServlet("/ptuserlogin")
public class ptuserlogin extends HttpServlet {

	@Override
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
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
		PrintWriter out = response.getWriter();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		Userdaoinferce useradd = new Userdaoimpl();
		Userbean userbean=useradd.findUser(username, password);
		
		int userid =userbean.getId();
		session.setAttribute("userID", userid);
		session.setAttribute("username", username);
		
		  /**
	     * Java对象转换为JSON字符串
	     */
		
        JSONObject jsonObj = JSONObject.fromObject(userbean);
        String jsonStr = jsonObj.toString();

		out.println(jsonStr);
		out.close();	
	}
}
