package com.sf.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import com.sf.Dao.SpeakDao;
import com.sf.bean.NewsSpeakbean;
import com.sf.bean.PageBean;
import com.sf.database.Db;

public class findAllSpeakImpl extends Db implements SpeakDao{

	@Override
	public PageBean findAllSpeak(PageBean pagebean) {//�鿴������������
		List<NewsSpeakbean> list = new ArrayList<NewsSpeakbean>();
		int rowBegin = 0;  //��ʼλ��
		if(pagebean.getCurrentPage()>1){  //�����ʼҳ����1
			rowBegin = pagebean.getPageSize()*(pagebean.getCurrentPage()-1);//��ҳ��ȡ�ÿ�ʼ����4*2-1			
		}
		try{
			conn = this.getConnection();
			//int endRow = rowBegin+pagebean.getPageSize();//����λ��
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
