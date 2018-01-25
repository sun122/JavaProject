package index_Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;


import com.sf.Dao.Userdaoinferce;
import com.sf.DaoImpl.Userdaoimpl;

@WebServlet("/CheckN_Servlet")
public class CheckN_Servlet extends HttpServlet {

	public CheckN_Servlet() {
		super();
	}
    /*检测该值是否可用*/
	Userdaoinferce userimp = new Userdaoimpl();//实现接口
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charsets=utf-8");
		PrintWriter out = response.getWriter();
		doPost(request, response);

	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charsets=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		
		List list = userimp.findByName(name);//根据姓名查找
		
		JSONArray jsonobj = new JSONArray().fromObject(list);
		String jsonStr = jsonobj.toString();
		out.println(jsonStr);
		out.close();
	}
	@Override
	public void destroy() {
		
		super.destroy();
	}

}
