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
import net.sf.json.JSONObject;

import com.sf.Dao.IndexShowNewContent;
import com.sf.Dao.PingLunDao;
import com.sf.DaoImpl.IndexShowNewContentImp;
import com.sf.DaoImpl.PingLunDaoImpl;
import com.sf.bean.NewsSpeakbean;
import com.sf.bean.Newsbean;
@WebServlet("/textnewspinglunservlet")
public class textnewspinglunservlet extends HttpServlet {

	PingLunDao pinglun = new PingLunDaoImpl();
	public textnewspinglunservlet() {
		super();
	}

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
		
	
		//≤È’“∆¿¬€
		List<NewsSpeakbean> pinglist = pinglun.findByPingLun(id);
		JSONArray jsonarr = new JSONArray().fromObject(pinglist.toArray());
		String jsonarry = jsonarr.toString();
		out.println(jsonarry);
		
		out.close();

	}

}
