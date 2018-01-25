package com.sf.DaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sf.Dao.Userdaoinferce;
import com.sf.bean.PageBean;
import com.sf.bean.Userbean;
import com.sf.database.Db;

public class Userdaoimpl extends Db implements Userdaoinferce{
	

	@Override
	public Userbean findUser(String name,String password) {  //用户登录
		//boolean flag=false;
		Userbean userbean = new Userbean();
		try{
			conn=this.getConnection();
			String sql = "select * from user where name=? and password=?";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, password);
			rs=stmt.executeQuery();
			while(rs.next()){
				userbean.setId(rs.getInt(1));
				userbean.setName(rs.getString(2));
				userbean.setPassword(rs.getString(3));
				userbean.setUserClass(rs.getString(4));
				userbean.setImgaddress(rs.getString(5));

			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return userbean;
	}
	@Override
	public int addUser(String name, String password,String userClass) { //用户注册
		int row = 0;
		try{
			conn = this.getConnection();
			String sql ="insert into user(name,password,userclass) values(?,?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2,password);
			stmt.setString(3, userClass);
			row = stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return row;
	}

	@Override
	public int deleteUser(String name, String password) { //通过用户名及密码删除用户
		int row = 0;
		try{
			conn = this.getConnection();
			String sql =  "delete from user where name = ? and password = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, password);
			row = stmt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return row;
	}

	@Override
	public int updateUser(Userbean user) {  //用户更新
		int row = 0 ;
		try{
			conn = this.getConnection();
			String sql = "update user set name=?,password = ? ,userClass = ? where id= ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getUserClass());
			stmt.setInt(4, user.getId());
			row = stmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return row;
	}

	@Override
	public PageBean findByUserClass(PageBean pagebean,String userClass) {  //通过用户类别（管理员还是普通用户）来查询用户
		List<Userbean> list = new ArrayList<Userbean>();
		int rowBegin = 0;  //开始位置
		if(pagebean.getCurrentPage()>1){  //如果开始页大于1
			rowBegin = pagebean.getPageSize()*(pagebean.getCurrentPage()-1);//按页数取得开始行数4*2-1			
		}
		try{
			conn = this.getConnection();
			//int endRow = rowBegin+pagebean.getPageSize();//结束位置
			int endRow = pagebean.getPageSize();
			String sql = "select * from user where userclass = ? limit ?,?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userClass);
			stmt.setInt(2, rowBegin);
			stmt.setInt(3, endRow);
			rs = stmt.executeQuery();
			while(rs.next()){
				Userbean userbean = new Userbean();
				userbean.setId(rs.getInt("id"));
				userbean.setName(rs.getString("name"));
				userbean.setPassword(rs.getString("password"));
				userbean.setUserClass(rs.getString("userClass"));
				list.add(userbean);
				pagebean.setList(list);
			}
			String sql1 = "select count(*) from user where userclass = ?";
			stmt = conn.prepareStatement(sql1);
			stmt.setString(1, userClass);
			rs = stmt.executeQuery();
			if(rs.next()){
				pagebean.setAllRow(rs.getInt(1));		
			}
			}catch(Exception e){
			e.printStackTrace();
			}finally{
				this.closeAll();
			}
		return pagebean;
	}

	@Override
	public PageBean findAllUser(PageBean pagebean) {  //查找所用用户
		List<Userbean> list = new ArrayList<Userbean>();
		int rowBegin = 0;  //开始位置
		if(pagebean.getCurrentPage()>1){  //如果开始页大于1
			rowBegin = pagebean.getPageSize()*(pagebean.getCurrentPage()-1);//按页数取得开始行数4*2-1			
		}
		try{
			conn = this.getConnection();
			//int endRow = rowBegin+pagebean.getPageSize();//结束位置
			int endRow = pagebean.getPageSize();
			String sql = "select * from user limit ?,?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, rowBegin);
			stmt.setInt(2, endRow);
			rs = stmt.executeQuery();
			while(rs.next()){
				Userbean userbean = new Userbean();
				userbean.setId(rs.getInt("id"));
				userbean.setName(rs.getString("name"));
				userbean.setPassword(rs.getString("password"));
				userbean.setUserClass(rs.getString("userClass"));
				list.add(userbean);
				pagebean.setList(list);
			}
			String sql1 = "select count(*) from user";
			stmt = conn.prepareStatement(sql1);
			rs = stmt.executeQuery();
			if(rs.next()){
				pagebean.setAllRow(rs.getInt(1));		
			}
			}catch(Exception e){
			e.printStackTrace();
			}finally{
				this.closeAll();
			}
		return pagebean;
	}
	@Override
	public int deleteUser(int id) {//更据Id删除用户
		int row = 0;
		try{
			conn = this.getConnection();
			String sql =  "delete from user where id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.addBatch();
			int row1[] = stmt.executeBatch();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return row;
	}
	@Override
	public Userbean queryById(int id) {
		Userbean user = new Userbean();
		try{
			conn = this.getConnection();
			String sql =  "select * from user where id=?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while(rs.next()){
				
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setUserClass(rs.getString("userClass"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return user;
	}
	@Override
	public boolean findAdm(String name, String password, String userclass) {
		boolean flag=false;
		try{
			conn=this.getConnection();
			String sql = "select * from user where name=? and password=? and userclass = ?";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, password);
			stmt.setString(3, userclass);
			rs=stmt.executeQuery();
			if(rs.next()){
				flag=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			this.closeAll();
		}
		return flag;
	}
	@Override
	public List findByName(String name) {//按名称搜索
		List<Userbean> list = new ArrayList<Userbean>();
		conn = this.getConnection();
		String sql =  "select * from user where name=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			while(rs.next()){
				Userbean userbean = new Userbean();
				userbean.setId(rs.getInt("id"));
				userbean.setName(rs.getString("name"));
				userbean.setPassword(rs.getString("password"));
				userbean.setUserClass(rs.getString("userClass"));
				userbean.setEmail(rs.getString("email"));
				list.add(userbean);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return list;
	}
	@Override
	public int insertUser(Userbean userbean) {
		conn = this.getConnection();
		int row=0;
		String sql ="insert into user(name,password,userclass,email) values(?,?,?,?)";
	try{
		stmt=conn.prepareStatement(sql);
		
		stmt.setString(1, userbean.getName());
		stmt.setString(2,userbean.getPassword());
		stmt.setString(3, userbean.getUserClass());
		stmt.setString(4, userbean.getEmail());
		row = stmt.executeUpdate();
	}catch(Exception e){
		e.printStackTrace();
	}
	finally{
		this.closeAll();
	}
	return row;
	}

}
