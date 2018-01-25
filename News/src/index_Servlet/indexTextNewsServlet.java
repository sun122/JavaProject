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

import com.sf.Dao.Newsdao;
import com.sf.DaoImpl.newsimpl;
@WebServlet("/indexTextNewsServlet")
public class indexTextNewsServlet extends HttpServlet {
	Newsdao newdao = null;
	public indexTextNewsServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		newdao = new newsimpl();
		List list = new ArrayList();
		list = newdao.firstPageNews();
		JSONArray arrylist = new JSONArray().fromObject(list);
		String attr = arrylist.toString();
		out.print(attr);
		
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
