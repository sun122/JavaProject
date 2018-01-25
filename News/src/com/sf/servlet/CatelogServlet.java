package com.sf.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sf.Dao.Catelogdao;
import com.sf.DaoImpl.NewsCatedaoimpl;
import com.sf.bean.NewsCatelogbean;
import com.sf.bean.PageBean;
@WebServlet("/CatelogServlet")
public class CatelogServlet extends HttpServlet {

	Catelogdao catelog = new NewsCatedaoimpl();
	public CatelogServlet() {
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
		
		if(action.equals("findAllcatelog")){
			doFindAllcatelog(request,response);
		}	
		if(action.equals("findByCatelogName")){
			dofindByCatelogName(request,response);
		}if(action.equals("toEdit")){
			doToEdit(request,response);
		}
		if(action.equals("doEdit")){
			doEditCatelog(request,response);
		}
		if(action.equals("seachtitle")){
			doSeachtitle(request,response);
		}
		if(action.equals("addcatelog")){
			doAddCatelog(request,response);
		}
	}
	private void doAddCatelog(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String miaoshu = request.getParameter("miaoshu");
		int row = catelog.addCatelog(name, miaoshu);
		if(row>0){
			doFindAllcatelog(request, response);
		}else{
			System.out.println("新闻类别添加失败！");
		}
		
	}
	private void doSeachtitle(HttpServletRequest request,  //模糊查询
			HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("name");
		
		String curpage = request.getParameter("curpage");
		if(curpage==null || curpage.equals("")){
			curpage = "1";
		}
		PageBean pagebean = new PageBean();
		
		pagebean.setCurrentPage(Integer.parseInt(curpage));  //设置当前页
		pagebean = catelog.findByLike(pagebean,title);
		request.setAttribute("cateloglist", pagebean.getList());
		request.setAttribute("pagebean", pagebean);
		request.getRequestDispatcher("/admin/catelogbrows.jsp").forward(request, response);
		
		//为分页
		/*List<NewsCatelogbean> list = catelog.findByLike(title);
		request.setAttribute("cateloglist", list);
		try {
			
			request.getRequestDispatcher("/admin/catelogbrows.jsp").forward(request, response);
			
		} catch (ServletException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}*/
	}
	private void doEditCatelog(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		NewsCatelogbean newscatelog = new NewsCatelogbean();
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String miaoshu = request.getParameter("miaoshu");
//		newscatelog.setNewStyleId(id);
//		newscatelog.setNewStyleName(title);
//		newscatelog.setMiaoShu(miaoshu);
		//System.out.println(id+title+miaoshu);
		int row = catelog.updateCatelog(id, title, miaoshu);
		if(row>0){
			doFindAllcatelog(request,response);
		}
	}
	private void doToEdit(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		NewsCatelogbean catelogbean = catelog.findById(id);
		request.setAttribute("catelogbean", catelogbean);
		request.getRequestDispatcher("/admin/doEditCatelog.jsp").forward(request, response);
	}
	private void dofindByCatelogName(HttpServletRequest request,
			HttpServletResponse response) {
		NewsCatelogbean newscatelog = new NewsCatelogbean();
		
		String catelogname = request.getParameter("catelogname");
				
		newscatelog = catelog.findeByName(catelogname);
		
		request.setAttribute("catelogbean", newscatelog);
		
	}

	private void doFindAllcatelog(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//分页
		String curpage = request.getParameter("curpage");
		if(curpage==null || curpage.equals("")){
			curpage = "1";
		}
		PageBean pagebean = new PageBean();
		
		pagebean.setCurrentPage(Integer.parseInt(curpage));  //设置当前页
		pagebean = catelog.findAllcatelog(pagebean);
		
		
		request.setAttribute("cateloglist", pagebean.getList());
		request.setAttribute("pagebean", pagebean);
		request.getRequestDispatcher("/admin/catelogbrows.jsp").forward(request, response);
		
		//未分页
		/*List<NewsCatelogbean> list = catelog.findAllcatelog();
		request.setAttribute("cateloglist", list);
		try {
			
			request.getRequestDispatcher("/admin/catelogbrows.jsp").forward(request, response);
			
		} catch (ServletException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}*/
	}
}
