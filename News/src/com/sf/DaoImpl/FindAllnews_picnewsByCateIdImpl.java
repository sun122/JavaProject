package com.sf.DaoImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.mysql.jdbc.ResultSetMetaData;
import com.sf.Dao.FindAllnews_picnewsDao;
import com.sf.database.Db;

public class FindAllnews_picnewsByCateIdImpl extends Db implements FindAllnews_picnewsDao{

	//@Override
	public JSONArray FindAllnews_picnewsByCateId(int id,int CurrentPage) {
		JSONArray jsonarry = new JSONArray();
		int rowBegin = 0;  //开始位置
		int PageSize = 5;
		int endRow = PageSize;//页面大小
		if(CurrentPage>1){//如果开始页大于1
			rowBegin=PageSize*(CurrentPage-1);//按页数取得开始行数4*2-1	
		}
		conn = this.getConnection();
		String sql = "select picNews_id,picNews_title,picNews_content,picNews_date,picNews_address from t_pic where catelog_id =? order by picNews_id desc limit ?,?";
		String sql1 = "select count(*) from t_pic where catelog_id =?";
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
