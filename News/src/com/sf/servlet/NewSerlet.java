package com.sf.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sf.Dao.Newsdao;
import com.sf.DaoImpl.newsimpl;
import com.sf.bean.Newsbean;
import com.sf.bean.PageBean;
@WebServlet("/NewSerlet")
public class NewSerlet extends HttpServlet {
	Newsdao newdao = new newsimpl();
	public NewSerlet() {
		super();
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		doPost(request, response);
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String action = request.getParameter("action");
	
		if(action.equals("addnews")){
			doAddNew(request,response); //添加新闻
		}
		if(action.equals("tofindcontent")){
			doTofindContent(request,response);
		}
		if(action.equals("toEdit")){
			toEditNews(request,response);
		}if(action.equals("doEideNew")){
			dodoEideNew(request,response);
		}if(action.equals("findbynewid")){
			doFindByNewId(request,response);
		}
	}
	private void doFindByNewId(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {//根据新闻类别查询新闻
		int catelogid = Integer.parseInt(request.getParameter("catelog"));
		
		//分页
		String curpage = request.getParameter("curpage");
		if(curpage==null || curpage.equals("")){
			curpage = "1";
		}
		PageBean pagebean = new PageBean();
		pagebean.setCurrentPage(Integer.parseInt(curpage));  //设置当前页
		pagebean = newdao.findByCatelogId(pagebean,catelogid);
		request.setAttribute("newslist", pagebean.getList());
		request.setAttribute("pagebean", pagebean);
		request.getRequestDispatcher("/admin/newBrows.jsp").forward(request, response);
				
	}
	private void dodoEideNew(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Newsbean newbean = new Newsbean();
		int id = Integer.parseInt(request.getParameter("newid"));
		int catelogid = Integer.parseInt(request.getParameter("catelog_id"));
		String author = request.getParameter("author");
		String datetime = request.getParameter("datetime");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date datet =null;
		try {
			datet=sdf.parse(datetime);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String newtitle = request.getParameter("newtitle");
		String newcontent = request.getParameter("newcontent");
		
		newbean.setCatelogId(catelogid);
		newbean.setNewsTitle(newtitle);
		newbean.setNewsContent(newcontent);
		newbean.setNewsDate(datet);
		newbean.setNewsId(id);
		newbean.setAuthor(author);
		int row = newdao.updateNews(newbean);
		if(row>0){
			request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
		}
	}
	private void toEditNews(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Newsbean newbean = new Newsbean();
		int id = Integer.parseInt(request.getParameter("id"));
		newbean = newdao.findByNewId(id);
		request.setAttribute("newbean", newbean);
		request.getRequestDispatcher("/admin/updatenews.jsp").forward(request, response);
	}
	private void doTofindContent(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Newsbean newbean = new Newsbean();
		int id = Integer.parseInt(request.getParameter("id"));
		newbean = newdao.findByNewId(id);
		request.setAttribute("newsbean", newbean);
		
		request.getRequestDispatcher("/admin/findnewcontent.jsp").forward(request, response);
	}
	private void doAddNew(HttpServletRequest request,  // 添加新闻
			HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("newtitle");
		int catelogid = Integer.parseInt(request.getParameter("catelog_id"));
		String content = request.getParameter("newcontent");
		String datetime = request.getParameter("datetime");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date datet =null;
		try {
			datet=sdf.parse(datetime);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String author = request.getParameter("author");
		
		Newsbean newbean = new Newsbean();
		newbean.setCatelogId(catelogid);
		newbean.setNewsTitle(title);
		newbean.setNewsContent(content);
		newbean.setNewsDate(datet);
		newbean.setAuthor(author);
		int row = newdao.insertNews(newbean);
		if(row>0){
			request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
		}	
	}
}
