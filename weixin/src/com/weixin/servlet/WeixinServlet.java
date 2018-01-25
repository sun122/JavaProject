package com.weixin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weixin.entity.TextMessage;
import com.weixin.util.CheckUtil;
import com.weixin.util.MessageUtil;

/**
 * Servlet implementation class WeixinServlet1
 */
//@WebServlet("/WeixinServlet")
public class WeixinServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       
    public WeixinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");
		
		PrintWriter out = resp.getWriter();
		if(CheckUtil.checkSignature(signature, timestamp, nonce)){
			System.out.println(echostr);
			out.print(echostr);
		}else{
			//out.print(echostr);
			System.out.println("error");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		try {
			Map<String,String> map = MessageUtil.xmlToMap(request);
			String fromUserName = map.get("FromUserName");
			String toUserName = map.get("ToUserName"); 
			String msgType = map.get("MsgType");
			String content = map.get("Content");
			String message = null;
			if("text".equals(msgType)){
				TextMessage text = new TextMessage();
				text.setFromUserName(toUserName);
				text.setToUserName(fromUserName);
				text.setMsgType("text");
				text.setCreateTime(new Date().getTime());
				text.setContent("ฤ๚บร"+content);
				message = MessageUtil.textMessageToXml(text);
				System.out.println(message);
			}
			out.print(message);
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			out.close();
		}
		//doGet(request, response);
	}

}
