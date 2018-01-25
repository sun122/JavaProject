package com.sf.DaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sf.Dao.Catelogdao;
import com.sf.bean.NewsCatelogbean;
import com.sf.bean.PageBean;
import com.sf.bean.Userbean;
import com.sf.database.Db;

public class NewsCatedaoimpl extends Db implements Catelogdao{
	
	@Override
	public PageBean findAllcatelog(PageBean pagebean) { //查找所有新闻类别名
		List<NewsCatelogbean> list = new ArrayList<NewsCatelogbean>();
		int rowBegin = 0;  //开始位置
		if(pagebean.getCurrentPage()>1){  //如果开始页大于1
			rowBegin = pagebean.getPageSize()*(pagebean.getCurrentPage()-1);//按页数取得开始行数4*2-1			
		}
		try{
			conn = this.getConnection();
			//int endRow = rowBegin+pagebean.getPageSize();//结束位置
			int endRow = pagebean.getPageSize();
			String sql = "select * from t_catelog limit ?,?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, rowBegin);
			stmt.setInt(2, endRow);
			rs = stmt.executeQuery();
			while(rs.next()){
				NewsCatelogbean catelog = new NewsCatelogbean();
				catelog.setNewStyleId(rs.getInt(1));
				catelog.setNewStyleName(rs.getString(2));
				catelog.setMiaoShu(rs.getString(3));
				list.add(catelog);
				pagebean.setList(list);
			}
			String sql1 = "select count(*) from t_catelog";
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
	public NewsCatelogbean findeByName(String catename) {  //更据新闻类别名查找该类的信息
		NewsCatelogbean catelog = new NewsCatelogbean();
		conn = this.getConnection();
		String sql ="select * from  t_catelog where catelog_name=?";
		try {
			stmt = conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()){
				catelog.setNewStyleId(rs.getInt("catelog_id"));
				catelog.setNewStyleName(rs.getString("catelog_name"));
				catelog.setMiaoShu(rs.getString("catelog_miaoshu"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return catelog;
	}

	@Override
	public int addCatelog(String catelogname, String catelogmiaoshu) {//添加新闻类别名
		int row = 0;
		conn = this.getConnection();
		String sql = "insert into t_catelog(catelog_name,catelog_miaoshu) values(?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, catelogname);
			stmt.setString(2, catelogmiaoshu);
			row = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return row;
	}
	@Override
	public int updateCatelog(int cateid,String catelogname, String catelogmiaoshu) {//更新新闻类别名
		conn = this.getConnection();
		int row = 0;
		String sql = "update t_catelog set catelog_name=?,catelog_miaoshu=? where catelog_id=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, catelogname);
			stmt.setString(2, catelogmiaoshu);
			stmt.setInt(3, cateid);
			row = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return row;
	}

	@Override
	public int deleteCatelog(int catelogid) {//删除新闻类别名
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NewsCatelogbean findById(int id) {
		NewsCatelogbean catelog = new NewsCatelogbean();
		conn = this.getConnection();
		String sql = "select * from t_catelog where catelog_id=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
			while(rs.next()){
				catelog.setNewStyleId(rs.getInt("catelog_id"));
				catelog.setNewStyleName(rs.getString("catelog_name"));
				catelog.setMiaoShu(rs.getString("catelog_miaoshu"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return catelog;
	}
	@Override
	public PageBean findByLike(PageBean pagebean,String title) {
		List<NewsCatelogbean> list = new ArrayList<NewsCatelogbean>();
		int rowBegin = 0;  //开始位置
		if(pagebean.getCurrentPage()>1){  //如果开始页大于1
			rowBegin = pagebean.getPageSize()*(pagebean.getCurrentPage()-1);//按页数取得开始行数4*2-1			
		}
		try{
			conn = this.getConnection();
			//int endRow = rowBegin+pagebean.getPageSize();//结束位置
			int endRow = pagebean.getPageSize();
			String sql = "select * from t_catelog where catelog_name like ? limit ?,?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,"%"+title+"%");
			stmt.setInt(2, rowBegin);
			stmt.setInt(3, endRow);
			rs = stmt.executeQuery();
			while(rs.next()){
				NewsCatelogbean catelog = new NewsCatelogbean();
				catelog.setNewStyleId(rs.getInt(1));
				catelog.setNewStyleName(rs.getString(2));
				catelog.setMiaoShu(rs.getString(3));
				list.add(catelog);
				pagebean.setList(list);
			}
			String sql1 = "select count(*) from t_catelog";
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
	public List findAllcatelog() {
		List<NewsCatelogbean> list = new ArrayList<NewsCatelogbean>();
		conn =this.getConnection();
		String sql = "select * from t_catelog";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				NewsCatelogbean catelog = new NewsCatelogbean();
				catelog.setNewStyleId(rs.getInt(1));
				catelog.setNewStyleName(rs.getString(2));
				catelog.setMiaoShu(rs.getString(3));
				list.add(catelog);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return list;
	}

}
