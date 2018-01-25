package com.sf.Dao;

import java.util.List;

import com.sf.bean.Newsbean;
import com.sf.bean.PageBean;

public interface Newsdao {
	public PageBean findAllNews(PageBean pagebean); //�������е�����
	public List findByTitle(String title);//�������ű����������
	public boolean delByIdNew(int id); //��������Idɾ������
	public int insertNews(Newsbean newbean);//�������
	public Newsbean findByNewId(int id); //��������id��ѯ��������
	public int updateNews(Newsbean newbean);//��������id���¸������ŵ�����
	public PageBean findByCatelogId(PageBean pagebean ,int id); //�����������id��������
	public List firstPageNews();//��ҳ������ʾ
}
