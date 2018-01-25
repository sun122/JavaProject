package com.sf.DaoImpl;

import java.sql.SQLException;

import com.sf.Dao.IndexShowNewContent;
import com.sf.bean.Newsbean;
import com.sf.database.Db;
public class IndexShowNewContentImp extends Db implements IndexShowNewContent{

	@Override
	public Newsbean showNewContent(int newid) {//根据新闻id显示新闻内容
		Newsbean newbean = new Newsbean();
		conn = this.getConnection();
		String sql ="select * from t_news where news_id=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, newid);
			rs=stmt.executeQuery();
			while(rs.next()){
				newbean.setNewsId(rs.getInt(1));
				newbean.setNewsTitle(rs.getString(2));
				newbean.setNewsContent(rs.getString(3));
				newbean.setNewsDate(rs.getDate(4));
				newbean.setCatelogId(rs.getInt(5));
				newbean.setAuthor(rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return newbean;
	}

}
