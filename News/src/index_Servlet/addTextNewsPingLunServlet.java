package index_Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sf.Dao.PingLunDao;
import com.sf.DaoImpl.PingLunDaoImpl;
import com.sf.bean.NewsSpeakbean;
@WebServlet("/addTextNewsPingLunServlet")
public class addTextNewsPingLunServlet extends HttpServlet {

	PingLunDao pinglun = new PingLunDaoImpl();
	public addTextNewsPingLunServlet() {
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

		NewsSpeakbean newspeak = new NewsSpeakbean();
		int newid = Integer.parseInt(request.getParameter("newid"));
		int userid = Integer.parseInt(request.getParameter("userid"));
		
		String speakcontent = request.getParameter("speakcontent");
	
		newspeak.setSpeakContent(speakcontent);
		newspeak.setSpeakDate(new Date());
		newspeak.setNewsId(newid);
		newspeak.setUserId(userid);
		
		Boolean row = pinglun.insertPingLun(newspeak);

	}

}
