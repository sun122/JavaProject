package com.sf.bean;

import java.util.Date;

public class Newsbean {//新闻bean
	private int newsId;
	private String newsTitle;
	private String newsContent;
	private Date newsDate;
	private int catelogId;
	private String catelog;//类别名
	private String author;
	private String newsdata;
	
	
	public String getNewsdata() {
		return newsdata;
	}
	public void setNewsdata(String newsdata) {
		this.newsdata = newsdata;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCatelog() {
		return catelog;
	}
	public void setCatelog(String catelog) {
		this.catelog = catelog;
	}
//	public int getSpeadId() {
//		return speadId;
//	}
//	public void setSpeadId(int speadId) {
//		this.speadId = speadId;
//	}
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getNewsContent() {
		return newsContent;
	}
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	
	public Date getNewsDate() {
		return newsDate;
	}
	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}
	
	public int getCatelogId() {
		return catelogId;
	}
	public void setCatelogId(int catelogId) {
		this.catelogId = catelogId;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

}
