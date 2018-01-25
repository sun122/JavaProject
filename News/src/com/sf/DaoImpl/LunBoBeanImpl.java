package com.sf.DaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sf.Dao.LunBoDao;
import com.sf.bean.LunBoBean;
import com.sf.bean.PageBean;
import com.sf.database.Db;

public class LunBoBeanImpl extends Db implements LunBoDao{

	@Override
	public int insertLbPic(LunBoBean lunbo) {
		int row =0;
		conn = this.getConnection();
		String sql = "insert into carousel(newstitle,newcontent,date,newauthor,newpicaddr) values(?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, lunbo.getNewstitle());
			stmt.setString(2, lunbo.getNewcontent());
			stmt.setString(3, lunbo.getDate());
			stmt.setString(4, lunbo.getNewauthor());
			stmt.setString(5, lunbo.getNewpicaddr());
			row = stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		System.out.println(row);
		return row;
	}

	@Override
	public PageBean findAllNews(PageBean pagebean) {
		List<LunBoBean> list = new ArrayList<LunBoBean>();
		int rowBegin = 0;  //开始位置
		if(pagebean.getCurrentPage()>1){  //如果开始页大于1
			rowBegin = pagebean.getPageSize()*(pagebean.getCurrentPage()-1);//按页数取得开始行数4*2-1			
		}
		try{
			conn = this.getConnection();
			
			int endRow = pagebean.getPageSize();
			String sql = "select * from carousel order by id desc limit ?,?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, rowBegin);
			stmt.setInt(2, endRow);
			rs = stmt.executeQuery();
			while(rs.next()){
				LunBoBean pic = new LunBoBean();
				
				pic.setNewstitle(rs.getString(2));
				pic.setNewcontent(rs.getString(3));
				String data = rs.getDate(4).toString();
				pic.setDate(data);
				pic.setNewauthor(rs.getString(5));
				pic.setNewpicaddr(rs.getString(6));
				list.add(pic);
				pagebean.setList(list);
			}
			String sql1 = "select count(*) from carousel";
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
	public List<LunBoBean> indexFindAllLunBoNews() {//前台轮播区
		List<LunBoBean> list = new ArrayList<LunBoBean>();
		try{
			conn = this.getConnection();
			String sql = "select * from carousel order by id desc limit 6";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				LunBoBean lbn = new LunBoBean();
				lbn.setId(rs.getInt(1));
				lbn.setNewstitle(rs.getString(2));
				lbn.setNewcontent(rs.getString(3));
				//lbn.setDate(rs.getDate(4));
				lbn.setNewauthor(rs.getString(5));
				lbn.setNewpicaddr(rs.getString(6));
				list.add(lbn);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return list;
	}

	@Override
	public List<LunBoBean> findById(int id) {
		List<LunBoBean> list = new ArrayList<LunBoBean>();
		try{
			conn = this.getConnection();
			String sql = "SELECT id, newstitle, newcontent, date, newauthor ,newpicaddr FROM carousel WHERE id=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while(rs.next()){
				LunBoBean lbn = new LunBoBean();
				lbn.setId(rs.getInt(1));
				lbn.setNewstitle(rs.getString(2));
				lbn.setNewcontent(rs.getString(3));
				String data = rs.getDate(4).toString();
				lbn.setDate(data);
				lbn.setNewauthor(rs.getString(5));
				lbn.setNewpicaddr(rs.getString(6));
				list.add(lbn);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return list;
	}
}
