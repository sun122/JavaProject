package index_Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.sf.Dao.LunBoDao;
import com.sf.DaoImpl.LunBoBeanImpl;
import com.sf.bean.LunBoBean;
@WebServlet("/LunBo_Servlet")
public class LunBo_Servlet extends HttpServlet {
	public LunBo_Servlet() {
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

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charsets=utf-8");
		PrintWriter out = response.getWriter();
		
		String newstitle = request.getParameter("title");
		String newcontent = request.getParameter("newcontent");
		String newauthor = request.getParameter("newauthor");
		String date = request.getParameter("date");
		String picaddress = request.getParameter("picaddress");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date datet =null;
		try {
			datet=sdf.parse(date);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LunBoBean lbb = new LunBoBean();
		lbb.setNewstitle(newstitle);
		lbb.setNewcontent(newcontent);
		lbb.setNewauthor(newauthor);
		lbb.setDate(date);
		lbb.setNewpicaddr(picaddress);		
		
		LunBoDao lb = new LunBoBeanImpl();
		int row =lb.insertLbPic(lbb);
		List list = new ArrayList();
		list.add(row);
		JSONArray jsonobj = new JSONArray().fromObject(list);
		String arr=jsonobj.toString();
		out.print(arr);
		
		out.close();
	}

}
