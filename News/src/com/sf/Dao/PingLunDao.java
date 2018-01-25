package com.sf.Dao;

import java.util.List;

import com.sf.bean.NewsSpeakbean;

public interface PingLunDao {
	public Boolean insertPingLun(NewsSpeakbean newspeak); //添加 评论
	public List<NewsSpeakbean> findByPingLun(int id);//更据新闻id查找所有评论
	public List<NewsSpeakbean> findPicPingLun(int id); //图片新闻评论
	public Boolean insertPicPingLun(NewsSpeakbean newspeak); //添加 评论
}
