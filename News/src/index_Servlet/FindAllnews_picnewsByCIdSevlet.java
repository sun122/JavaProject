package index_Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.junit.Test;

import com.sf.Dao.FindAllnews_picnewsDao;
import com.sf.DaoImpl.FindAllnews_picnewsByCateIdImpl;
@WebServlet("/FindAllnews_picnewsByCIdSevlet")
public class FindAllnews_picnewsByCIdSevlet extends HttpServlet {
	public FindAllnews_picnewsByCIdSevlet() {
		super();
	}
	FindAllnews_picnewsDao fapcid = new FindAllnews_picnewsByCateIdImpl();
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
		
		JSONArray jsonarr = fapcid.FindAllnews_picnewsByCateId(id,CurrentPage);
		
		out.println(jsonarr);
		
		out.close();
	}

}
