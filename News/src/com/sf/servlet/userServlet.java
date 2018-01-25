package com.sf.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sf.bean.PageBean;
import com.sf.Dao.Userdaoinferce;
import com.sf.DaoImpl.Userdaoimpl;
import com.sf.bean.Userbean;



@WebServlet("/userServlet")
public class userServlet extends HttpServlet {
	Userdaoinferce userimp = new Userdaoimpl();
	public userServlet() {
		super();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charsets=utf-8");

		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charsets=utf-8");
		
		String action = request.getParameter("action");
		String userclass1 = request.getParameter("userClass");
		if(action.equals("findAllUser")){ //���������û�
			doFindAllUser(request, response);
		}
		if(action.equals("findByUserClass")){//�����û��������������������û�
			if(userclass1.equals("��ͨ�û�") || userclass1.equals("����Ա")){
				doFindByUserClass(request, response);
			}
		}
		if(action.equals("updateUser")){//�༭�����û�
			toUpdateUser(request,response);
		}
		if(action.equals("deleteUser")){ //�����û���������ɾ���û�
			doDeleteUser(request,response);
		}
		if(action.equals("toEdit")){
			toEdit(request,response);
		}
		if(action.equals("doEdit")){
			doEdit(request,response);
		}
		if(action.equals("seachUser")){
			doSeachUser(request,response);
		}if(action.equals("adduser")){
			doAddUser(request,response);
		}
			
	}

	
	private void doAddUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
Userdaoinferce usebean = new Userdaoimpl();
		
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		String userClass = request.getParameter("userClass");
		int row  = usebean.addUser(username,password,userClass);
		
		if(row>0){
			doFindAllUser(request, response);
		}else{
			
		}
		
	}

	private void doSeachUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String name = request.getParameter("name");
		List list = userimp.findByName(name);
		request.setAttribute("userList", list);
		
		
		if(list.size()>0){
			request.getRequestDispatcher("/admin/userBrows.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	private void doEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Userbean userb = new Userbean();
		userb.setId(Integer.parseInt(request.getParameter("id")));
		userb.setName(request.getParameter("name")) ;
		userb.setPassword(request.getParameter("password"));
		userb.setUserClass(request.getParameter("userClass"));
		
		int row = userimp.updateUser(userb);
		if(row>0){
			doFindAllUser(request, response);
		}
	}

	private void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Userbean user;
		user =userimp.queryById(id);
		request.setAttribute("userbean", user);
		if(user.getId()==0|| user.getName()==null){
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else{
			//doFindAllUser(request, response);
			request.getRequestDispatcher("/admin/editUser.jsp").forward(request, response);
		}
	}

	private void doDeleteUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {//�����û���������ɾ���û�
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		int id = Integer.parseInt(request.getParameter("id"));
		
		int row = userimp.deleteUser(username, password);
		if(row > 0){
			doFindAllUser(request, response);
		}
	}

	private void toUpdateUser(HttpServletRequest request,HttpServletResponse response) {//�༭�����û�
		
		
		
	}

	private void doFindByUserClass(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{//�����û��������������������û�
		//��ҳ
		String curpage = request.getParameter("curpage");
		if(curpage==null || curpage.equals("")){
			curpage = "1";
		}
		PageBean pagebean = new PageBean();
		
		String userClass = request.getParameter("userClass");
		pagebean.setCurrentPage(Integer.parseInt(curpage));  //���õ�ǰҳ
		pagebean = userimp.findByUserClass(pagebean,userClass);
		request.setAttribute("userList", pagebean.getList());
		request.setAttribute("pagebean", pagebean);
		request.getRequestDispatcher("/admin/userBrows.jsp").forward(request, response);
		
		
		
		//δ��ҳ
		/*List list = userimp.findByUserClass(request.getParameter("userClass"));
		
		request.setAttribute("userList", list);
		if(list.size()>0){
			request.getRequestDispatcher("/admin/userBrows.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}*/
		
		
	}

	private void doFindAllUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//���������û�
		
		
		///
		String curpage = request.getParameter("curpage");
		if(curpage==null || curpage.equals("")){
			curpage = "1";
		}
		PageBean pagebean = new PageBean();
		pagebean.setCurrentPage(Integer.parseInt(curpage));  //���õ�ǰҳ
		pagebean = userimp.findAllUser(pagebean);
		request.setAttribute("userList", pagebean.getList());
		request.setAttribute("pagebean", pagebean);
		request.getRequestDispatcher("/admin/userBrows.jsp").forward(request, response);
		////
		
//		List<Userbean> list = userimp.findAllUser();
//		
//		request.setAttribute("userList", list);
//		
//		
//		try {
//			
//			request.getRequestDispatcher("/admin/userBrows.jsp").forward(request, response);
//			
//		} catch (ServletException e) {
//			
//			e.printStackTrace();
//			
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
		
	}

}
