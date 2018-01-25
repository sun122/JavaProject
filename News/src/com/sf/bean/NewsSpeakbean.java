package com.sf.bean;

import java.util.Date;

public class NewsSpeakbean {//新闻评论bean
	private int speakId;
	private String speakContent;
	private Date speakDate;
	private int newsId; //新闻id
	private int userId;
	private String newstitle;
	private String userName;
	private String userclass;
	private String userImgAdd;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserclass() {
		return userclass;
	}
	public void setUserclass(String userclass) {
		this.userclass = userclass;
	}
	public String getUserImgAdd() {
		return userImgAdd;
	}
	public void setUserImgAdd(String userImgAdd) {
		this.userImgAdd = userImgAdd;
	}
	public String getNewstitle() {
		return newstitle;
	}
	public void setNewstitle(String newstitle) {
		this.newstitle = newstitle;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getSpeakId() {
		return speakId;
	}
	public void setSpeakId(int speakId) {
		this.speakId = speakId;
	}
	public String getSpeakContent() {
		return speakContent;
	}
	public void setSpeakContent(String speakContent) {
		this.speakContent = speakContent;
	}
	public Date getSpeakDate() {
		return speakDate;
	}
	public void setSpeakDate(Date speakDate) {
		this.speakDate = speakDate;
	}
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	

}
