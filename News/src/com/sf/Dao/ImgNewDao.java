package com.sf.Dao;

import java.util.List;

import com.sf.bean.PageBean;
import com.sf.bean.PicNewsbean;


public interface ImgNewDao {
	public PageBean showAllImgNews(PageBean pagebean);//浏览所有图片新闻
	
	public int UpdateImgNew(PicNewsbean picbean,int id);//修改新闻
	public int InsertImgNew(PicNewsbean picbean); //添加新闻
	public PicNewsbean findNewById(int id);  //查找新闻
	public List<PicNewsbean> findByAddress();//查找图片路径
	public List<PicNewsbean> findAllpicNews();//查找图片新闻
}
