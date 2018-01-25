package com.sf.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.mysql.jdbc.ResultSetMetaData;
import com.sf.Dao.indexShowNewdao;
import com.sf.bean.IndexPageBean;
import com.sf.bean.Newsbean;
import com.sf.database.Db;

public class indexShowNewdaoimpl extends Db implements indexShowNewdao{

	@Override
	public IndexPageBean findAllNewsByCatelogId(IndexPageBean pagebean,int catelogid) {
		List<Newsbean> list = new ArrayList<Newsbean>();
		int rowBegin = 0;  //开始位置
		if(pagebean.getCurrentPage()>1){  //如果开始页大于1
			rowBegin = pagebean.getPageSize()*(pagebean.getCurrentPage()-1);//按页数取得开始行数4*2-1			
		}
		try{
			conn = this.getConnection();
			//int endRow = rowBegin+pagebean.getPageSize();//结束位置
			int endRow = pagebean.getPageSize();
			String sql = "select news_id,news_title,news_date from t_news where catelog_id=? limit ?,?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, catelogid);
			stmt.setInt(2, rowBegin);
			stmt.setInt(3, endRow);
			rs = stmt.executeQuery();
			while(rs.next()){
				Newsbean newbean = new Newsbean();
				newbean.setNewsId(rs.getInt(1));
				newbean.setNewsTitle(rs.getString(2));
				newbean.setNewsDate(rs.getDate(3));
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
	public JSONArray indexAllNews(int id,int CurrentPage) {
		JSONArray jsonarry = new JSONArray();
		int rowBegin = 0;  //开始位置
		int PageSize = 3;
		int endRow = PageSize;//页面大小
		if(CurrentPage>1){//如果开始页大于1
			rowBegin=PageSize*(CurrentPage-1);//按页数取得开始行数4*2-1	
		}
		
		conn = this.getConnection();
		String sql = "select news_id,news_title,news_content,news_date,author from t_news where catelog_id =? order by news_id desc limit ?,?";
		String sql1="select  count(*) from t_news where catelog_id =?";//求总数
		try{
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setInt(2, rowBegin);
			stmt.setInt(3, endRow);
			rs = stmt.executeQuery();

			ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();
			int columnCount = md.getColumnCount();
			
			while(rs.next()){
				JSONObject jsonobj  = new JSONObject();
	            for (int i = 1; i <= columnCount; i++) {
	            	jsonobj.put(md.getColumnName(i), rs.getObject(i));// 添加键值对，比如说{name:Wp}通过name找到wp
	            }
	            jsonarry.add(jsonobj);
	            
			}	
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		try{
			conn = this.getConnection();
			stmt = conn.prepareStatement(sql1);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while(rs.next()){
				jsonarry.add(rs.getObject(1));
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		
		return jsonarry;
	}

}
