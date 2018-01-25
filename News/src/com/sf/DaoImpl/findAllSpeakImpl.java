package com.sf.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import com.sf.Dao.SpeakDao;
import com.sf.bean.NewsSpeakbean;
import com.sf.bean.PageBean;
import com.sf.database.Db;

public class findAllSpeakImpl extends Db implements SpeakDao{

	@Override
	public PageBean findAllSpeak(PageBean pagebean) {//查看所有新闻评论
		List<NewsSpeakbean> list = new ArrayList<NewsSpeakbean>();
		int rowBegin = 0;  //开始位置
		if(pagebean.getCurrentPage()>1){  //如果开始页大于1
			rowBegin = pagebean.getPageSize()*(pagebean.getCurrentPage()-1);//按页数取得开始行数4*2-1			
		}
		try{
			conn = this.getConnection();
			//int endRow = rowBegin+pagebean.getPageSize();//结束位置
			int endRow = pagebean.getPageSize();
			String sql = "select t_speak.*,t_news.news_title from t_speak inner join t_news on t_news.news_id=t_speak.news_id limit ?,?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, rowBegin);
			stmt.setInt(2, endRow);
			rs = stmt.executeQuery();
			while(rs.next()){
				NewsSpeakbean speakbean = new NewsSpeakbean();
				speakbean.setSpeakId(rs.getInt(1));
				speakbean.setSpeakContent(rs.getString(2));
				speakbean.setSpeakDate(rs.getDate(3));
				speakbean.setNewsId(rs.getInt(4));
				speakbean.setUserId(rs.getInt(5));
				speakbean.setNewstitle(rs.getString(6));
				list.add(speakbean);
				pagebean.setList(list);
			}
			String sql1 = "select count(*) from t_speak";
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

}
