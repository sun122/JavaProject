package com.sf.Dao;

import java.util.List;

import com.sf.bean.NewsSpeakbean;

public interface PingLunDao {
	public Boolean insertPingLun(NewsSpeakbean newspeak); //��� ����
	public List<NewsSpeakbean> findByPingLun(int id);//��������id������������
	public List<NewsSpeakbean> findPicPingLun(int id); //ͼƬ��������
	public Boolean insertPicPingLun(NewsSpeakbean newspeak); //��� ����
}
