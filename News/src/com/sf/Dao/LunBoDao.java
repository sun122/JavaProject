package com.sf.Dao;

import java.util.List;
import java.util.Set;

import com.sf.bean.LunBoBean;
import com.sf.bean.PageBean;

public interface LunBoDao {
	public int insertLbPic(LunBoBean lunbo);//添加轮播新闻
	public PageBean findAllNews(PageBean pagebean);//浏览轮播图片新闻
	public List<LunBoBean> indexFindAllLunBoNews();//前台轮播区
	public List<LunBoBean> findById(int id);//前台页面通过点击图片后向数据库查询详细新闻
}
