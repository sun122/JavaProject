package com.sf.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Db {
	
		String sql="select*from employee";
		String url = "jdbc:mysql://localhost:3306/NewSystem?useUnicode=true&characterEncoding=utf-8";
		String driver = "com.mysql.jdbc.Driver";
		String user ="root";
		String password="";
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
}

