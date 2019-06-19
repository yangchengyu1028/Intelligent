package com.novo.util;

import java.util.List;


public class PageBean {
		//当前页数
	   private int pageNo;
	   	//获取行数
	   private int pageSize;
	   //获取目标的所有数量
	   private int totalNum;
	   //总页数
	   private int totalPage;
	   //返回的对象集合
	   private List<?> list;
	   //起始位置
	   private int  num;
	   
	   public PageBean() {
	}

	public PageBean(int pageNo, int pageSize, int totalNum, List<?> list) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalNum = totalNum;
		this.list = list;
		this.num = (pageNo-1)*pageSize;
		if(totalNum%pageSize==0){
			this.totalPage = totalNum%pageSize;
		}else{
				this.totalPage = (int)(totalNum/pageSize)+1;
		}
	}
	   
	public PageBean(int pageNo, int pageSize, int totalNum) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalNum = totalNum;
		this.num = (pageNo-1)*pageSize;
		if(totalNum%pageSize==0){
			this.totalPage = totalNum/pageSize;
		}else{
				this.totalPage = (int)(totalNum/pageSize)+1;
		}
	}

	public List<?> getList() {
	      return list;
	   }

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public int getTotalPage() {
		return totalPage;
	}


	public void setList(List<?> list) {
		this.list = list;
	}

	public int getNum() {
		return num;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "PageBean [pageNo=" + pageNo + ", pageSize=" + pageSize + ", totalNum=" + totalNum + ", totalPage="
				+ totalPage + ", list=" + list + ", num=" + num + "]";
	}

	   
}
