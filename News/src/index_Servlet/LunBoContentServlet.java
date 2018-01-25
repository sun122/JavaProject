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

import com.sf.Dao.LunBoDao;
import com.sf.DaoImpl.LunBoBeanImpl;
import com.sf.bean.LunBoBean;
@WebServlet("/LunBoContentServlet")
public class LunBoContentServlet extends HttpServlet {
	public LunBoContentServlet() {
		super();
	}
	LunBoDao lb = new LunBoBeanImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charsets=utf-8");
		response.setCharacterEncoding("UTF-8");
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charsets=utf-8");
		
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		
		List<LunBoBean> list = new ArrayList<LunBoBean>();
		list = lb.findById(id);
		
		JSONArray jsonarr = new JSONArray().fromObject(list);
		String str = jsonarr.toString();
		
		out.println(str);
		out.close();
	}

}
