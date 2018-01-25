package com.sf.DaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sf.Dao.Newsdao;
import com.sf.bean.Newsbean;
import com.sf.bean.PageBean;
import com.sf.database.Db;

public class newsimpl extends Db implements Newsdao{
	@Override
	public PageBean findAllNews(PageBean pagebean) {//查找所有新闻信息
		List<Newsbean> list = new ArrayList<Newsbean>();
		int rowBegin = 0;  //开始位置
		if(pagebean.getCurrentPage()>1){  //如果开始页大于1
			rowBegin = pagebean.getPageSize()*(pagebean.getCurrentPage()-1);//按页数取得开始行数4*2-1			
		}
		try{
			conn = this.getConnection();
			//int endRow = rowBegin+pagebean.getPageSize();//结束位置
			int endRow = pagebean.getPageSize();
			String sql = "select t_news.*,t_catelog.* from t_news inner join t_catelog on t_news.catelog_id=t_catelog.catelog_id limit ?,?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, rowBegin);
			stmt.setInt(2, endRow);
			rs = stmt.executeQuery();
			while(rs.next()){
				Newsbean newbean = new Newsbean();
				newbean.setNewsId(rs.getInt(1));
				newbean.setNewsTitle(rs.getString(2));
				newbean.setNewsContent(rs.getString(3));
				newbean.setNewsDate(rs.getDate(4));
				newbean.setCatelogId(rs.getInt(5));
				newbean.setAuthor(rs.getString(6));
				newbean.setCatelog(rs.getString(8));
				list.add(newbean);
				pagebean.setList(list);
			}
			String sql1 = "select count(*) from t_news";
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
	public List findByTitle(String title) {//更据新闻标题查找新闻信息
		List<Newsbean> list = new ArrayList<Newsbean>();
		conn = this.getConnection();
		String sql = "select * from t_news where news_title like ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,"%"+title+"%");
			rs = stmt.executeQuery();
			while(rs.next()){
				Newsbean newbean = new Newsbean();
				newbean.setNewsId(rs.getInt(1));
				newbean.setNewsTitle(rs.getString(2));
				newbean.setNewsContent(rs.getString(3));
				newbean.setNewsDate(rs.getDate(4));
				newbean.setCatelogId(rs.getInt(5));
				newbean.setAuthor(rs.getString(6));
				list.add(newbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return list;
	}

	@Override
	public boolean delByIdNew(int id) {//更据新闻id删除该条新闻
	    boolean flag = false;
		conn = this.getConnection();
		String sql =  "delete from t_news where news_id=?";
		try {
			stmt = this.conn.prepareStatement(sql);
			flag = stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return flag;
	}

	@Override
	public int insertNews(Newsbean newbean) {
		int row = 0;
		conn = this.getConnection();
		String sql = "insert into t_news(news_title,news_content,news_date,catelog_id,author) values(?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, newbean.getNewsTitle());
			stmt.setString(2, newbean.getNewsContent());
			stmt.setDate(3, new java.sql.Date(newbean.getNewsDate().getTime()));
			stmt.setInt(4, newbean.getCatelogId());
			stmt.setString(5, newbean.getAuthor());
			row = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return row;
	}

	@Override
	public Newsbean findByNewId(int id) {
		conn = this.getConnection();
		Newsbean newb = new Newsbean();
		String sql = "select * from t_news where news_id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while(rs.next()){
				
				newb.setNewsId(rs.getInt(1));
				newb.setNewsTitle(rs.getString(2));
				newb.setNewsContent(rs.getString(3));
				newb.setNewsDate(rs.getDate(4));
				newb.setCatelogId(rs.getInt(5));
				newb.setAuthor(rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return newb;
	}

	@Override
	public int updateNews(Newsbean newbean) {//更新该条新闻
		int row = 0;
		conn = this.getConnection();
		String sql = "update t_news set news_title=?,news_content = ? ,news_date = ?,catelog_id = ?,author=? where news_id= ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, newbean.getNewsTitle());
			stmt.setString(2, newbean.getNewsContent());
			stmt.setDate(3, new java.sql.Date(newbean.getNewsDate().getTime()));
			stmt.setInt(4, newbean.getCatelogId());
			stmt.setString(5, newbean.getAuthor());
			stmt.setInt(6, newbean.getNewsId());
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
	public PageBean findByCatelogId(PageBean pagebean ,int id) {//更据新闻类别id查找新闻
		List<Newsbean> list = new ArrayList<Newsbean>();
		int rowBegin = 0;  //开始位置
		if(pagebean.getCurrentPage()>1){  //如果开始页大于1
			rowBegin = pagebean.getPageSize()*(pagebean.getCurrentPage()-1);//按页数取得开始行数4*2-1			
		}
		try{
			conn = this.getConnection();
			//int endRow = rowBegin+pagebean.getPageSize();//结束位置
			int endRow = pagebean.getPageSize();
			String sql = "select t_news.*,t_catelog.* from t_news inner join t_catelog on t_news.catelog_id=t_catelog.catelog_id and t_news.catelog_id = ? limit ?,?";
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, id);
			stmt.setInt(2, rowBegin);
			stmt.setInt(3, endRow);
			rs = stmt.executeQuery();
			while(rs.next()){
				Newsbean newbean = new Newsbean();
				newbean.setNewsId(rs.getInt(1));
				newbean.setNewsTitle(rs.getString(2));
				newbean.setNewsContent(rs.getString(3));
				newbean.setNewsDate(rs.getDate(4));
				newbean.setCatelogId(rs.getInt(5));
				newbean.setAuthor(rs.getString(6));
				newbean.setCatelog(rs.getString(8));
				list.add(newbean);
				pagebean.setList(list);
			}
			String sql1 = "select count(*) from t_news where catelog_id = ?";
			stmt = conn.prepareStatement(sql1);
			stmt.setInt(1, id);
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
	public List firstPageNews() {//首页新闻显示
		List<Newsbean> list = new ArrayList<Newsbean>();
		conn = this.getConnection();
		String sql = "select * from t_news order by news_id desc limit 10";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Newsbean newbean = new Newsbean();
				newbean.setNewsId(rs.getInt(1));
				newbean.setNewsTitle(rs.getString(2));
				newbean.setNewsContent(rs.getString(3));
				//newbean.setNewsDate(rs.getDate(4));
				newbean.setNewsdata(rs.getDate(4).toString());
				newbean.setCatelogId(rs.getInt(5));
				newbean.setAuthor(rs.getString(6));
				list.add(newbean);
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
