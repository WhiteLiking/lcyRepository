package com.vo;

public class ShopCar {
	//��Ʒ���е��ֶζ���Java�е�����
		private int cid;//��Ʒ��id���
		private String cname;//��Ʒ����
		private String cdec;//��Ʒ����
		private int prevPrice;//ԭ��
		private int price;//��Ʒ�۸�
		private String version;//��Ʒ�ͺ�
		private int ground;//��Ʒ�Ƿ��ϼܣ�0-�¼ܣ�1-�ϼ�
		private int quantity=1;//��Ʒ��
		private int totalPrice = getPrice()*getQuantity();
		private String psPath;//��ƷͼƬ�ı���·��
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
