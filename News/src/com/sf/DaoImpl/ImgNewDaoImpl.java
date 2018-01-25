package com.sf.DaoImpl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sf.Dao.ImgNewDao;
import com.sf.bean.PageBean;
import com.sf.bean.PicNewsbean;
import com.sf.database.Db;

public class ImgNewDaoImpl extends Db implements ImgNewDao{

	@Override
	public PageBean showAllImgNews(PageBean pagebean) {//浏览所有图片新闻
		List<PicNewsbean> list = new ArrayList<PicNewsbean>();
		int rowBegin = 0;  //开始位置
		if(pagebean.getCurrentPage()>1){  //如果开始页大于1
			rowBegin = pagebean.getPageSize()*(pagebean.getCurrentPage()-1);//按页数取得开始行数4*2-1			
		}
		try{
			conn = this.getConnection();
			//int endRow = rowBegin+pagebean.getPageSize();//结束位置
			int endRow = pagebean.getPageSize();
			String sql = "select * from t_pic limit ?,?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, rowBegin);
			stmt.setInt(2, endRow);
			rs = stmt.executeQuery();
			while(rs.next()){
				PicNewsbean pic = new PicNewsbean();
				pic.setPicNewsId(rs.getInt(1));
				pic.setPicNewsTitle(rs.getString(2));
				pic.setPicNewsContent(rs.getString(3));
				pic.setPicNewsAddress(rs.getString(4));
				pic.setPicNewsDate(rs.getString(5));
				pic.setAuthor(rs.getString(6));
				pic.setCatelog_id(rs.getInt(7));
				list.add(pic);
				pagebean.setList(list);
				//System.out.println(rs.getString(2)+"   "+rs.getString(3));
			}
			String sql1 = "select count(*) from t_pic";
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
	public int UpdateImgNew(PicNewsbean picbean,int id) {
		PicNewsbean pic = new PicNewsbean();
		int row = 0;
		conn = this.getConnection();
		String sql = "update t_pic set picNews_title=?,picNews_content=?,picNews_address=?,picNews_date=?,auther =? where picNews_id=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, picbean.getPicNewsTitle());
			stmt.setString(2, picbean.getPicNewsContent());
			stmt.setString(3, picbean.getPicNewsAddress());
			stmt.setString(4, picbean.getPicNewsDate());
			stmt.setString(5, picbean.getAuthor());
			stmt.setInt(6, picbean.getPicNewsId());
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
	public int InsertImgNew(PicNewsbean picbean) {
		int row =0;
		conn = this.getConnection();
		String sql = "insert into t_pic(picNews_title,picNews_content,picNews_address,picNews_date,auther,catelog_id) values(?,?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, picbean.getPicNewsTitle());
			stmt.setString(2, picbean.getPicNewsContent());
			stmt.setString(3, picbean.getPicNewsAddress());
			stmt.setString(4, picbean.getPicNewsDate());
			stmt.setString(5, picbean.getAuthor());
			stmt.setInt(6, picbean.getCatelog_id());
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
	public PicNewsbean findNewById(int id) {
		PicNewsbean pic = new PicNewsbean();
		conn = this.getConnection();
		String sql = "select * from t_pic where picNews_id =?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while(rs.next()){
				pic.setPicNewsId(rs.getInt(1));
				pic.setPicNewsTitle(rs.getString(2));
				pic.setPicNewsContent(rs.getString(3));
				pic.setPicNewsAddress(rs.getString(4));
				pic.setPicNewsDate(rs.getString(5));
				pic.setAuthor(rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return pic;
	}

	@Override
	public List<PicNewsbean> findByAddress() {//查找图片地址
		List<PicNewsbean> list = new ArrayList<PicNewsbean>();
		conn = this.getConnection();
		String sql ="select * from t_pic";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				PicNewsbean pic = new PicNewsbean();
				pic.setPicNewsId(rs.getInt(1));
				pic.setPicNewsTitle(rs.getString(2));
				pic.setPicNewsContent(rs.getString(3));
				pic.setPicNewsAddress(rs.getString(4));
				pic.setPicNewsDate(rs.getString(5));
				pic.setAuthor(rs.getString(6));
				list.add(pic);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return list;
	}

	@Override
	public List<PicNewsbean> findAllpicNews() {
		List<PicNewsbean> list = new ArrayList<PicNewsbean>();
		conn = this.getConnection();
		String sql ="select * from t_pic ORDER BY picNews_id desc limit 6";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				PicNewsbean pic = new PicNewsbean();
				pic.setPicNewsId(rs.getInt(1));
				pic.setPicNewsTitle(rs.getString(2));
				pic.setPicNewsContent(rs.getString(3));
				pic.setPicNewsAddress(rs.getString(4));
				pic.setPicNewsDate(rs.getString(5));
				pic.setAuthor(rs.getString(6));
				list.add(pic);
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
