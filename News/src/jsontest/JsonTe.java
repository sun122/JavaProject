package jsontest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.mysql.jdbc.ResultSetMetaData;
import com.sf.database.Db;

public class JsonTe extends Db {
		public  void TJson() {
			try{
				conn = this.getConnection();
				String sql = "select * from t_catelog";
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				
				java.sql.ResultSetMetaData metaData = rs.getMetaData();// 获取表结构
				int columnCount = metaData.getColumnCount();//返回所有字段的数目
                List  list = new ArrayList();
				while(rs.next()){
				
				//	JSONObject jsonObj = new JSONObject();  // 创建json对象就是一个{name:wp}     
		            for(int i = 1; i<= columnCount;i++){  
		               String columnName = metaData.getColumnName(i);  
		              // System.out.println(columnName);
		               String value =rs.getString(columnName);
		               
		               list.add(value);

		              }  
				}
				JSONArray array = JSONArray.fromObject(list);
				//JSONObject jsonObject = new JSONObject();
				   //jsonObject.put("", array);
				   //System.out.println(jsonObject.toString());
				   System.out.println(array.toString());  
				}catch(Exception e){
				e.printStackTrace();
				}finally{
					this.closeAll();
				}
		}
		public static void main(String[] args) {
			JsonTe j = new JsonTe();
			j.TJson();
		}
}
