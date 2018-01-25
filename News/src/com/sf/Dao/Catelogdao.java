package com.sf.Dao;

import java.util.List;

import com.sf.bean.NewsCatelogbean;
import com.sf.bean.PageBean;

public interface Catelogdao {
	public PageBean findAllcatelog(PageBean pagebean); //查看所有的新闻类别
	public NewsCatelogbean findeByName(String catename); //更据新闻类别名称查询新闻类别
	public int addCatelog(String catelogname,String catelogmiaoshu); //添加新闻类别
	public int updateCatelog(int cateid,String catelogname,String catelogmiaoshu); //修改新闻类别
	public int deleteCatelog(int catelogid); //更据新闻类别id删除新闻类别
	public NewsCatelogbean findById(int id);//更据新闻类别id查找内容
	public PageBean findByLike(PageBean pagebean,String title);//模糊查询
	public List findAllcatelog();//查找所有新闻类别用于前端导航条显示
}
