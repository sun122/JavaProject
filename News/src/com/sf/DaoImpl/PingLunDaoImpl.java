package com.sf.DaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sf.Dao.PingLunDao;
import com.sf.bean.NewsSpeakbean;
import com.sf.database.Db;

public class PingLunDaoImpl extends Db implements PingLunDao{

	@Override
	public Boolean insertPingLun(NewsSpeakbean newspeak) {//添加评论
		conn = this.getConnection();
		boolean falg =false;
		String sql = "insert into t_speak(speak_content,speak_date,news_id,uid) values(?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, newspeak.getSpeakContent());
			System.out.println(newspeak.getSpeakDate().getTime());
			stmt.setDate(2, new java.sql.Date(newspeak.getSpeakDate().getTime()));
			stmt.setInt(3, newspeak.getNewsId());
			stmt.setInt(4, newspeak.getUserId());
			falg = stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return falg;
	}

	@Override
	public List<NewsSpeakbean> findByPingLun(int id) {//显示评论
		// TODO Auto-generated method stub
		List<NewsSpeakbean> list = new ArrayList<NewsSpeakbean>();
		
		conn = this.getConnection();
		String sql = "select t_speak.*,user.name,user.userclass,user.imgaddress from t_speak inner join user on t_speak.uid = user.id where t_speak.news_id = ? order by speak_id desc";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while(rs.next()){
				NewsSpeakbean newspeak = new NewsSpeakbean();
				newspeak.setSpeakId(rs.getInt(1));
				newspeak.setSpeakContent(rs.getString(2));
				//newspeak.setSpeakDate(rs.getDate(3));
				newspeak.setSpeakDate(new java.util.Date(rs.getDate(3).getTime()));
				newspeak.setNewsId(rs.getInt(4));
				newspeak.setUserId(rs.getInt(5));
				newspeak.setUserName(rs.getString(6));
				newspeak.setUserclass(rs.getString(7));
				newspeak.setUserImgAdd(rs.getString(8));
				list.add(newspeak);
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
	public List<NewsSpeakbean> findPicPingLun(int id) {
		// TODO Auto-generated method stub
		List<NewsSpeakbean> list = new ArrayList<NewsSpeakbean>();
		
		conn = this.getConnection();
		String sql = "select picspeak.*,user.name,user.userclass,user.imgaddress from picspeak inner join user on picspeak.uid1 = user.id where picspeak.news_id1 = ? order by speak_id desc";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while(rs.next()){
				NewsSpeakbean newspeak = new NewsSpeakbean();
				newspeak.setSpeakId(rs.getInt(1));
				newspeak.setSpeakContent(rs.getString(2));
				//newspeak.setSpeakDate(rs.getDate(3));
				newspeak.setSpeakDate(new java.util.Date(rs.getDate(3).getTime()));
				newspeak.setNewsId(rs.getInt(4));
				newspeak.setUserId(rs.getInt(5));
				newspeak.setUserName(rs.getString(6));
				newspeak.setUserclass(rs.getString(7));
				newspeak.setUserImgAdd(rs.getString(8));
				list.add(newspeak);
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
	public Boolean insertPicPingLun(NewsSpeakbean newspeak) {
		conn = this.getConnection();
		boolean falg =false;
		String sql = "insert into picspeak(speak_content,speak_date,news_id1,uid1) values(?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, newspeak.getSpeakContent());
			
			stmt.setDate(2, new java.sql.Date(newspeak.getSpeakDate().getTime()));
			stmt.setInt(3, newspeak.getNewsId());
			stmt.setInt(4, newspeak.getUserId());
			falg = stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return falg;
	}
	
}
