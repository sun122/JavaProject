package com.sf.Dao;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

public interface FindAllnews_picnewsDao {
	public JSONArray FindAllnews_picnewsByCateId(int id,int CurrentPage);
}
