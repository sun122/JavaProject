package index_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sf.Dao.LunBoDao;
import com.sf.DaoImpl.LunBoBeanImpl;
import com.sf.bean.LunBoBean;
import com.sf.bean.PageBean;
@WebServlet("/showAllLunBoNews")
public class showAllLunBoNews extends HttpServlet {
	public showAllLunBoNews() {
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
		//分页
		String curpage = request.getParameter("curpage");
		if(curpage==null || curpage.equals("")){
			curpage = "1";
		}
		LunBoDao lb = new LunBoBeanImpl();
		PageBean pagebean = new PageBean();		
		pagebean.setCurrentPage(Integer.parseInt(curpage));  //设置当前页
		
		pagebean = lb.findAllNews(pagebean);
		request.setAttribute("lbnews", pagebean.getList());
		request.setAttribute("pagebean", pagebean);
		request.getRequestDispatcher("/admin/showlunbonews.jsp").forward(request, response);
	}

}
