package com.sf.Dao;

import java.util.List;

import com.sf.bean.PageBean;
import com.sf.bean.PicNewsbean;


public interface ImgNewDao {
	public PageBean showAllImgNews(PageBean pagebean);//�������ͼƬ����
	
	public int UpdateImgNew(PicNewsbean picbean,int id);//�޸�����
	public int InsertImgNew(PicNewsbean picbean); //�������
	public PicNewsbean findNewById(int id);  //��������
	public List<PicNewsbean> findByAddress();//����ͼƬ·��
	public List<PicNewsbean> findAllpicNews();//����ͼƬ����
}
