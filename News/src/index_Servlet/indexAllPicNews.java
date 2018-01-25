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

import com.sf.Dao.ImgNewDao;
import com.sf.DaoImpl.ImgNewDaoImpl;
import com.sf.bean.PicNewsbean;
@WebServlet("/indexAllPicNews")
public class indexAllPicNews extends HttpServlet {

	public indexAllPicNews() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	ImgNewDao imgdao = null;
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
		
		imgdao = new ImgNewDaoImpl();
		List list = imgdao.findAllpicNews();
		JSONArray jsonarry = new JSONArray().fromObject(list);
		String jsonstr = jsonarry.toString();
		out.print(jsonstr);
		
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
