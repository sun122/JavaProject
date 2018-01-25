package com.sf.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@WebServlet("/DeleteCatelog")
public class DeleteCatelog extends HttpServlet {
	public DeleteCatelog() {
		super();
	}

	String sql="select*from employee";
	String url = "jdbc:mysql://localhost:3306/NewSystem?useUnicode=true&characterEncoding=utf-8";
	String driver = "com.mysql.jdbc.Driver";
	String user ="root";
	String password="123";
	public Connection conn=null;
	public PreparedStatement stmt=null;
	public ResultSet rs = null;
	
	public Connection getConnection(){
	try {
		
		Class.forName(driver);
		conn=DriverManager.getConnection(url,user,password);
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	return conn;
	}
	public void closeAll(){
	try{
		if(rs!=null){
			rs.close();
		}
		if(stmt!=null){
			stmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	}catch(Exception e){
		
	}
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
//////////////
	//批处理删除操作
	conn = this.getConnection();
	String sql =  "delete from t_catelog where catelog_id = ?";
	String ID[] = request.getParameterValues("delid");
	try {
		stmt = conn.prepareStatement(sql);
		if(ID.length>0){
			for(int i=0;i<ID.length;i++){
				stmt.setInt(1, Integer.parseInt(ID[i]));
				stmt.addBatch();
			}
		}
		int row1[] = stmt.executeBatch();
		if(row1.length>0){
			request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		closeAll();
	}
	///////////////////////
	}
}
