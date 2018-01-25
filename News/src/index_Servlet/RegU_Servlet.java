package index_Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.sf.Dao.Userdaoinferce;
import com.sf.DaoImpl.Userdaoimpl;
import com.sf.bean.Userbean;
@WebServlet("/RegU_Servlet")
public class RegU_Servlet extends HttpServlet {
	Userdaoinferce userimp = new Userdaoimpl();//实现接口
	public RegU_Servlet() {
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charsets=utf-8");
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charsets=utf-8");
		
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String userclass = request.getParameter("userclass");
		Userbean ub = new Userbean();
		ub.setName(name);
		ub.setPassword(password);
		ub.setEmail(email);
		ub.setUserClass(userclass);
		
		int row = userimp.insertUser(ub);
		
		List list = new ArrayList();
		list.add(row);
		JSONArray jsonobj = new JSONArray().fromObject(list);
		String jsonStr = jsonobj.toString();
		out.println(jsonStr);

		out.close();
	}

}
