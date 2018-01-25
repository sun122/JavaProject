package com.sf.servlet;

import java.io.File;
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
import net.sf.json.JSONObject;

import com.sf.Dao.ImgNewDao;
import com.sf.DaoImpl.ImgNewDaoImpl;
import com.sf.bean.PageBean;
import com.sf.bean.PicNewsbean;
@WebServlet("/AddImgNewServlet")
public class AddImgNewServlet extends HttpServlet {
	ImgNewDao img = new ImgNewDaoImpl();
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
		
		File f = new File(getServletContext().getRealPath("/")+"Indeximage");
		
		//System.out.println("getRealPath:"+getServletContext().getRealPath("/")+"Indeximage");
		
		String str[] = f.list();//遍历文件
		
		List piclist = new ArrayList();
		
		for(int i=0;i<str.length;i++){
			
			String path = "Indeximage/"+str[i];
			piclist.add(path);
		}
		
		JSONArray jsonarry = new JSONArray().fromObject(piclist);
		String arry = jsonarry.toString();	
		out.print(arry);
		//out.close();
	}
}
