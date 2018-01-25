package com.sf.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sf.Dao.Userdaoinferce;
import com.sf.DaoImpl.Userdaoimpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	public LoginServlet() {
		super();
	}
	@Override
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
		response.setContentType("text/html");
		
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		String typesub = request.getParameter("typesub");
		
		if(typesub.equals("µÇÂ¼")){
			doFindAdministrator(request,response);
		}
//		if(action.equals("userlogin")){
//			doUserLogin(request,response);
//		}
		if(typesub.equals("×¢²á")){
			doAdmReginster(request, response);
		}
		
		
	}
	private void doAdmReginster(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		Userdaoinferce usebean = new Userdaoimpl();
		String username = request.getParameter("name1");
		String password = request.getParameter("password1");
		String userClass = request.getParameter("select");
		int row  = usebean.addUser(username,password,userClass);
		if(row>0){
			 response.sendRedirect("/News/admlogin.html");
//				RequestDispatcher requestdispatcher = request.getRequestDispatcher("/News/admlogin.html");
//				requestdispatcher.forward(request, response);
				
		   
		}else{
			response.sendRedirect("/News/error.jsp");
		}
		
	}
//	private void doUserLogin(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		
//		
//	}
	private void doFindAdministrator(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		
		String username=request.getParameter("name1");
		String password=request.getParameter("password1");
		String select = request.getParameter("select");
		
		Userdaoinferce adm = new Userdaoimpl();
		boolean flag = adm.findAdm(username, password, select);
		if(flag){
			HttpSession session = request.getSession();
			session.setAttribute("name", username);
			request.getRequestDispatcher("/admin/browseAllUser.jsp").forward(request, response);
		}else{
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("/error.jsp");
			requestdispatcher.forward(request, response);
		}
	}

}
