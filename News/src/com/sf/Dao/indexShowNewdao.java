package com.sf.Dao;

import net.sf.json.JSONArray;

import com.sf.bean.IndexPageBean;

public interface indexShowNewdao {
	public IndexPageBean findAllNewsByCatelogId(IndexPageBean pagebean,int catelogid); //ǰ��������ʾ
	public JSONArray indexAllNews(int id,int CurrentPage);
}
