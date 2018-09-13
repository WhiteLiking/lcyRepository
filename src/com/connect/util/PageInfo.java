package com.connect.util;
/*
 *分页工具类 
 * */
public class PageInfo {
	//当前页数
	private int currentPage=1;//默认第一页开始
	//总记录
	private int totalRecord;
	//总页数
	private int totalPage;
	//每页的开始和结尾
	private int perPageStart;
	private int perPageEnd;
	
/****************************************************/	
	public int getTotalPage() {
		if(this.totalRecord%7==0){
			return this.totalRecord/7;
		}else{
			return (this.totalRecord/7)+1;
		}
	}
/***********************************************************/
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
/*************************************************************/
	public int getCurrentPage() {
		return this.currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	
/****************************************************************/
	public int getPerPageStart() {
		return (this.currentPage*7)-6;
	}
	
	public int getPerPageEnd() {
		if(this.currentPage*7>this.totalRecord){
			return this.totalRecord;
		}else{
			return this.currentPage*7;
		}
	}
	
	
		public static void main(String[] args) {
		PageInfo in = new PageInfo();
		System.out.println(in.getPerPageStart());
		System.out.println(in.getPerPageEnd());
	}
}
