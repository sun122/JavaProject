package index_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.sf.Dao.ImgNewDao;
import com.sf.DaoImpl.ImgNewDaoImpl;
import com.sf.bean.PicNewsbean;
@WebServlet("/picnewsContent_servlet")
public class picnewsContent_servlet extends HttpServlet {

	public picnewsContent_servlet() {
		super();
	}
	ImgNewDao imndi = new ImgNewDaoImpl();
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
		System.out.println("id:"+id);
		
		PicNewsbean pic = new PicNewsbean();
		
		pic = imndi.findNewById(id);
		
		JSONObject jsonobj = new JSONObject().fromObject(pic);
		String jsonstr = jsonobj.toString();
		
		System.out.println(jsonstr);
		
		out.print(jsonstr);
		out.close();
	}

}
