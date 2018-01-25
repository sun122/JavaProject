package com.sf.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class PageBean implements Serializable{
	private List list = new ArrayList(); //返回结果
	private int allRow = 0;   //总共多少行
	private int totalPage = 0 ;    //总数页
	private int currentPage = 1;   //当前页
	private int pageSize = 6;    //分页大小
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getAllRow() {
		return allRow;
	}
	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}
	public int getTotalPage() {
		return allRow % pageSize==0 ? allRow/pageSize:allRow/pageSize+1;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		if(currentPage>0){
			this.currentPage = currentPage;
		}else{
			this.currentPage = 1;
		}
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
