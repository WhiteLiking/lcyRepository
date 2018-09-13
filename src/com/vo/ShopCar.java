package com.vo;

public class ShopCar {
	//商品表中的字段对用Java中的属性
		private int cid;//商品的id编号
		private String cname;//商品名称
		private String cdec;//商品描述
		private int prevPrice;//原价
		private int price;//商品价格
		private String version;//商品型号
		private int ground;//商品是否上架：0-下架，1-上架
		private int quantity=1;//商品量
		private int totalPrice = getPrice()*getQuantity();
		private String psPath;//商品图片的保存路径
/**********************************************************************/		
		
		
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
		public String getCdec() {
			return cdec;
		}
		public void setCdec(String cdec) {
			this.cdec = cdec;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public String getVersion() {
			return version;
		}
		public void setVersion(String version) {
			this.version = version;
		}
		public int getGround() {
			return ground;
		}
		public void setGround(int ground) {
			this.ground = ground;
		}
		public int getQuantity() {
			return quantity;
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
		
		public int getPrevPrice(){
			return this.getPrice()*7/5;
		}
		public int getTotalPrice(){
			return this.totalPrice;
		}
		
		
//		public static void main(String[] args) {
//			ShopCar shop = new ShopCar();
//			System.out.println(shop.getPrevPrice());
//		}
}
