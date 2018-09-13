package com.vo;

public class Category {
	//商品表中的字段对用Java中的属性
	private int cid;//商品的id编号
	private String cname;//商品名称
	private String cdec;//商品描述
	private int price;//商品价格
	private String version;//商品型号
	private int ground;//商品是否上架：0-下架，1-上架
	private int quantity;//商品库存量
	private String psPath;//商品图片的保存路径
	
	//商品属性的访问器
	public int getCid() {
		return this.cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return this.cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCdec() {
		return this.cdec;
	}
	public void setCdec(String cdec) {
		this.cdec = cdec;
	}
	public int getPrice() {
		return this.price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getVersion() {
		return this.version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	public int getGround() {
		return this.ground;
	}
	public void setGround(int ground) {
		this.ground = ground;
	}
	public int getQuantity() {
		return this.quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPsPath() {
		return psPath;
	}
	public void setPsPath(String psPath) {
		this.psPath = psPath;
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", cdec=" + cdec + ", price=" + price + ", version="
				+ version + ", ground=" + ground + ", quantity=" + quantity + ", psPath=" + psPath + "]";
	}
	
}
	