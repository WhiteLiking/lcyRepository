package com.vo;

public class Orders {
	private int oid;
	private String oname;
	private int price;
	private  int  psum;
	private String name;
	private String telephone;
	private String aderss;
	private String userno;
	
	
	public Orders() {
		
		// TODO Auto-generated constructor stub
	}
	
	public Orders(int oid, int price, int psum, String name, String telephone, String aderss, String userno) {
		super();
		this.oid = oid;
		this.price = price;
		this.psum = psum;
		this.name = name;
		this.telephone = telephone;
		this.aderss = aderss;
		this.userno = userno;
	}

	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	
	public String getOname() {
		return oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPsum() {
		return psum;
	}
	public void setPsum(int psum) {
		this.psum = psum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAderss() {
		return aderss;
	}
	public void setAderss(String aderss) {
		this.aderss = aderss;
	}
	public String getUserno() {
		return userno;
	}
	public void setUserno(String userno) {
		this.userno = userno;
	}
	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", price=" + price + ", psum=" + psum + ", name=" + name + ", telephone="
				+ telephone + ", aderss=" + aderss + ", userno=" + userno + "]";
	}
	
}
