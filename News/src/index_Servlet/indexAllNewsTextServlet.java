package index_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sf.Dao.indexShowNewdao;
import com.sf.DaoImpl.indexShowNewdaoimpl;

import net.sf.json.JSONArray;
@WebServlet("/indexAllNewsTextServlet")
public class indexAllNewsTextServlet extends HttpServlet {

	public indexAllNewsTextServlet() {
		super();
	}
	indexShowNewdao idsndi = new indexShowNewdaoimpl();
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
		
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));
		int CurrentPage = Integer.parseInt(request.getParameter("CurrentPage"));
		
		JSONArray jsonarr = idsndi.indexAllNews(id,CurrentPage);
		
		out.println(jsonarr);
		
		out.close();
	}

}
