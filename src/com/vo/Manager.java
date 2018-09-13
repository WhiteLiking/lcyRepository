package com.vo;

public class Manager {

	//用户编号cid
	private int cid;
	//用户名
	private String cname;
	//密码
	private String cpassword;
	//状态,默认为1
	private int state=1;
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Manager [cid=" + cid + ", cname=" + cname + ", cpassword=" + cpassword + ", state=" + state + "]";
	}
	 
}
