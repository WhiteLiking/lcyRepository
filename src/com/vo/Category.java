package com.vo;

public class Category {
	//��Ʒ���е��ֶζ���Java�е�����
	private int cid;//��Ʒ��id���
	private String cname;//��Ʒ����
	private String cdec;//��Ʒ����
	private int price;//��Ʒ�۸�
	private String version;//��Ʒ�ͺ�
	private int ground;//��Ʒ�Ƿ��ϼܣ�0-�¼ܣ�1-�ϼ�
	private int quantity;//��Ʒ�����
	private String psPath;//��ƷͼƬ�ı���·��
	
	//��Ʒ���Եķ�����
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
	