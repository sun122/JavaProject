package com.sf.Dao;

import java.util.List;

import com.sf.bean.NewsCatelogbean;
import com.sf.bean.PageBean;

public interface Catelogdao {
	public PageBean findAllcatelog(PageBean pagebean); //�鿴���е��������
	public NewsCatelogbean findeByName(String catename); //��������������Ʋ�ѯ�������
	public int addCatelog(String catelogname,String catelogmiaoshu); //����������
	public int updateCatelog(int cateid,String catelogname,String catelogmiaoshu); //�޸��������
	public int deleteCatelog(int catelogid); //�����������idɾ���������
	public NewsCatelogbean findById(int id);//�����������id��������
	public PageBean findByLike(PageBean pagebean,String title);//ģ����ѯ
	public List findAllcatelog();//�������������������ǰ�˵�������ʾ
}
