package com.sf.bean;

public class PicNewsbean {
	private int picNewsId;
	private String picNewsTitle;
	private String picNewsContent;
	private String picNewsAddress;
	private String picNewsDate;
	private String author;
    private String caolianjie;
    private int catelog_id;
    
	public int getCatelog_id() {
		return catelog_id;
	}
	public void setCatelog_id(int catelog_id) {
		this.catelog_id = catelog_id;
	}
	public String getCaolianjie() {
		return caolianjie;
	}
	public void setCaolianjie(String caolianjie) {
		this.caolianjie = caolianjie;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPicNewsId() {
		return picNewsId;
	}
	public void setPicNewsId(int picNewsId) {
		this.picNewsId = picNewsId;
	}
	public String getPicNewsTitle() {
		return picNewsTitle;
	}
	public void setPicNewsTitle(String picNewsTitle) {
		this.picNewsTitle = picNewsTitle;
	}
	public String getPicNewsContent() {
		return picNewsContent;
	}
	public void setPicNewsContent(String picNewsContent) {
		this.picNewsContent = picNewsContent;
	}
	public String getPicNewsAddress() {
		return picNewsAddress;
	}
	public void setPicNewsAddress(String picNewsAddress) {
		this.picNewsAddress = picNewsAddress;
	}
	public String getPicNewsDate() {
		return picNewsDate;
	}
	public void setPicNewsDate(String picNewsDate) {
		this.picNewsDate = picNewsDate;
	}
	
	
}
