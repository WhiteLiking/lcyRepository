package com.connect.util;
/*
 *��ҳ������ 
 * */
public class PageInfo {
	//��ǰҳ��
	private int currentPage=1;//Ĭ�ϵ�һҳ��ʼ
	//�ܼ�¼
	private int totalRecord;
	//��ҳ��
	private int totalPage;
	//ÿҳ�Ŀ�ʼ�ͽ�β
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
