package com.sf.Dao;

import java.util.List;

import com.sf.bean.Newsbean;
import com.sf.bean.PageBean;

public interface Newsdao {
	public PageBean findAllNews(PageBean pagebean); //查找所有的新闻
	public List findByTitle(String title);//更据新闻标题查找新闻
	public boolean delByIdNew(int id); //更据新闻Id删除新闻
	public int insertNews(Newsbean newbean);//添加新闻
	public Newsbean findByNewId(int id); //更据新闻id查询该条新闻
	public int updateNews(Newsbean newbean);//更据新闻id更新该条新闻的内容
	public PageBean findByCatelogId(PageBean pagebean ,int id); //更据新闻类别id查找新闻
	public List firstPageNews();//首页新闻显示
}
