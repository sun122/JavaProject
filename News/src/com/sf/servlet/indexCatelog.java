package com.sf.servlet;

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

import com.sf.Dao.Catelogdao;
import com.sf.DaoImpl.NewsCatedaoimpl;
import com.sf.bean.NewsCatelogbean;
@WebServlet("/indexCatelog")
public class indexCatelog extends HttpServlet {
	Catelogdao catelog = new NewsCatedaoimpl();
	public indexCatelog() {
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
		PrintWriter out = response.getWriter();
		
		List<NewsCatelogbean> list = catelog.findAllcatelog();
		//
		JSONArray array = JSONArray.fromObject(list);
		String str = array.toString();
        out.println(str);
		//out.close();
		
		//request.setAttribute("cateloglist", list);
		
//		JSONObject jsonObject = new JSONObject();
//		jsonObject .put("",list);
//		JSONArray jsonArray = new JSONArray();
//		jsonArray.add(jsonObject);
//		System.out.println("jsonArrayÊý×é"+jsonArray);
//		PrintWriter out = response.getWriter();
//		out.write(jsonArray.toString());
		
	
		
	}	
}

