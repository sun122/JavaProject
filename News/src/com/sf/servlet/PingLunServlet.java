package com.sf.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sf.Dao.PingLunDao;
import com.sf.DaoImpl.PingLunDaoImpl;
import com.sf.bean.NewsSpeakbean;
@WebServlet("/PingLunServlet")
public class PingLunServlet extends HttpServlet {
	PingLunDao pinglun = new PingLunDaoImpl();
	/**
	显示评论信息
	 */
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
		String action = request.getParameter("action");
		if(action.equals("addpinglun")){
			doAddPingLun(request,response);
		}if(action.equals("addpicpinglun")){
			doAddPicPingLun(request,response);
		}

	}
	private void doAddPicPingLun(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		NewsSpeakbean newspeak = new NewsSpeakbean();
		int newid = Integer.parseInt(request.getParameter("newid"));
		int userid = Integer.parseInt(request.getParameter("userid"));
		
		String speakcontent = request.getParameter("speakcontent");
	
		newspeak.setSpeakContent(speakcontent);
		newspeak.setSpeakDate(new Date());
		newspeak.setNewsId(newid);
		newspeak.setUserId(userid);
		
		Boolean row = pinglun.insertPicPingLun(newspeak);
		request.setAttribute("id", newid);
		request.getRequestDispatcher("/servlet/ShowPicNewAndSpeakServlet").forward(request, response);		
		
	}
	private void doAddPingLun(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		NewsSpeakbean newspeak = new NewsSpeakbean();
		int newid = Integer.parseInt(request.getParameter("newid"));
		int userid = Integer.parseInt(request.getParameter("userid"));
		
		String speakcontent = request.getParameter("speakcontent");
	
		newspeak.setSpeakContent(speakcontent);
		newspeak.setSpeakDate(new Date());
		newspeak.setNewsId(newid);
		newspeak.setUserId(userid);
		
		Boolean row = pinglun.insertPingLun(newspeak);
		request.setAttribute("newID", newid);
		request.getRequestDispatcher("/servlet/ShowNewContentAndSpeakServlet").forward(request, response);
	}

}
