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
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;

import com.sf.Dao.LunBoDao;
import com.sf.DaoImpl.LunBoBeanImpl;
@WebServlet("/indexLunBoNews")
public class indexLunBoNews extends HttpServlet {

	public indexLunBoNews() {
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
		
		LunBoDao lbn = new LunBoBeanImpl();
		
		List list =new ArrayList();
		list = lbn.indexFindAllLunBoNews();
		
		JSONArray jsonarry = new JSONArray().fromObject(list);
		String attr = jsonarry.toString();
		out.println(attr);
		out.close();
	}

}
