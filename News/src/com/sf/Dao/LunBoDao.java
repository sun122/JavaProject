package com.sf.Dao;

import java.util.List;
import java.util.Set;

import com.sf.bean.LunBoBean;
import com.sf.bean.PageBean;

public interface LunBoDao {
	public int insertLbPic(LunBoBean lunbo);//����ֲ�����
	public PageBean findAllNews(PageBean pagebean);//����ֲ�ͼƬ����
	public List<LunBoBean> indexFindAllLunBoNews();//ǰ̨�ֲ���
	public List<LunBoBean> findById(int id);//ǰ̨ҳ��ͨ�����ͼƬ�������ݿ��ѯ��ϸ����
}
