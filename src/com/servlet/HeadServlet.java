package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.imple.DaoImple;
import com.dao.inter.CategoryDAO;
import com.vo.Category;
import com.vo.Orders;
import com.vo.ShopCar;
import com.vo.User;

public class HeadServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charSet=utf-8");
		
		
/*******************************************主页的显示，默认随机展示四个商品**********************************************************************/
		//接受前端请求信息
		String target = request.getParameter("target");
		if("".equals(target)||target==null){
			
			//主页显示面，设置为开启默认启动程序，调用DAO，取出所有商品，显示在客户端主页
			CategoryDAO dao = new DaoImple();
			List<Category> listCategory = dao.selectCategoryBySQL("select * from category");//取出所有商品
			
			//获取图片存储路径的父路径（上传到的路径）
			String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/");
			//遍历容器，处理图片路径
			for(int i =0;i<listCategory.size();i++){
				//取出每个商品的图片路径，并将绝对路径处理成相对路径
				String path = listCategory.get(i).getPsPath();
				//若商品没有图片，则路径设为空
				if(path==null){
					path="";
				}
				Object[] src = deleteSubString(path,uploadFilePath);//获得图片名。后缀名
				path = "upload/" + src[0].toString();//得到相对路径
				//填充图片数据数据
				listCategory.get(i).setPsPath(path);
				
				//判断是否下架，如果下架，就不能再前端展示
				if(listCategory.get(i).getGround()==0){
					listCategory.remove(i);
				}
			}
			//转发到前端主页
			request.setAttribute("listCategory",listCategory);
			request.getRequestDispatcher("jsp/head/mainPage.jsp").forward(request,response);
		}
/*###########################################################################################*/	
		//商品详情页
		if("productMessagePage".equals(target)){
			int cid = Integer.parseInt(request.getParameter("cid"));
			//在数据库中查出该商品
			CategoryDAO dao = new DaoImple();
			Category category = dao.selectCategoryById(cid);
			
			String path = category.getPsPath();
			//获取图片存储路径的父路径（上传到的路径）
			String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/");
			//若商品没有图片，则路径设为空
			if(path==null){
				path="";
			}
			Object[] src = deleteSubString(path,uploadFilePath);//获得图片名。后缀名
			path = "upload/" + src[0].toString();//得到相对路径
			//填充图片数据数据
			category.setPsPath(path);
			//转发到商品详情页,用于显示
			request.setAttribute("product",category);
			request.getRequestDispatcher("jsp/head/productDetails.jsp").forward(request,response);
		}
/*########################################################################################*/
		//购物车
		HttpSession session = request.getSession(true);
		if("addShopCar".equals(target)){
			//接收加入购物车的请求
			int cid = Integer.parseInt(request.getParameter("id"));
			
			CategoryDAO dao = new DaoImple();
			Category category = dao.selectCategoryById(cid);
			ShopCar productCar = new ShopCar();
			
			//给客户创建一个购物车
			List<ShopCar> listCategory = (List<ShopCar>)session.getAttribute("shopCar");
			if(listCategory==null){//如果为空，则客户第一次使用购物车，为他创建
				listCategory = new <ShopCar>ArrayList();
			}
			//将商品放到session容器中中,并且不能加入重复的商品
			int flag = 1;//标志，-1添加失败，0已在购物车中，1添加成功
			for(int i=0;i<listCategory.size();i++){
				
				if(listCategory.get(i).getCid()==category.getCid()){
					//购物车中已有该商品，将该商品数量加1
					flag=0;
					int temp = listCategory.get(i).getQuantity();
					listCategory.get(i).setQuantity(temp+1);
				}	
				if(listCategory.get(i).getCid()==0){
					listCategory.remove(i);
				}
			}
			
			if(flag==1){
				//加入购物车中
				productCar.setCid(category.getCid());
				productCar.setCname(category.getCname());
				productCar.setCdec(category.getCdec());
				productCar.setPrice(category.getPrice());
				productCar.setVersion(category.getVersion());
				productCar.setPsPath(category.getPsPath());
				listCategory.add(productCar);//添加购物车
			}
			session.setAttribute("shopCar",listCategory);
			//转发到购物车
			//request.getRequestDispatcher("HeadMainPage").forward(request,response);
			response.sendRedirect("HeadMainPage");
			//return;
		}
/******************************************购物车**********************************************************/
		//查看购物车
		if("lookShopCar".equals(target)){
			//取出购物车中的所有商品，并在购物车页面中显示
			List<ShopCar> listCategory = (List)session.getAttribute("shopCar");
			
			if(listCategory==null){//购物车为空
				listCategory = new <ShopCar>ArrayList();
			}
			session.setAttribute("shopCar",listCategory);
			request.getRequestDispatcher("jsp/head/shopCar.jsp").forward(request,response);
		}
		
		//删除购物车中的商品
		if("deleteShopCar".equals(target)){
			//接收要删除的产品编号,取出购物车，删除相应的商品
			int id = Integer.parseInt(request.getParameter("id"));
			List<ShopCar> shopCar = (List<ShopCar>)session.getAttribute("shopCar");
			for(int i=0;i<shopCar.size();i++){
				if(shopCar.get(i).getCid()==id){
					shopCar.remove(i);
				}
			}
			//删除完毕
			session.setAttribute("shopCar",shopCar);
			//request.getRequestDispatcher("head/shopCar.jsp").forward(request,response);
			response.sendRedirect("jsp/head/shopCar.jsp");
		}
		
		//在购物车中添加商品数量
		if("addQuantity".equals(target)){
			List<ShopCar> shopCar = (List<ShopCar>)session.getAttribute("shopCar");
			//增加数量
			int id = Integer.parseInt(request.getParameter("id"));
			for(int i=0;i<shopCar.size();i++){
				if(shopCar.get(i).getCid()==id&&shopCar.get(i).getPrice()!=0){
					int temp = shopCar.get(i).getQuantity();
					shopCar.get(i).setQuantity(temp+1);
				}
			}
			session.setAttribute("shopCar",shopCar);
			request.getRequestDispatcher("jsp/head/shopCar.jsp").forward(request,response);
		}
			
			
		//减小数量
		if("reduceQuantity".equals(target)){
			List<ShopCar> shopCar = (List<ShopCar>)session.getAttribute("shopCar");
			int id = Integer.parseInt(request.getParameter("id"));
			for(int i=0;i<shopCar.size();i++){
				if(shopCar.get(i).getCid()==id&&shopCar.get(i).getPrice()!=0){
					int temp = shopCar.get(i).getQuantity();
					if(temp>0){							
						shopCar.get(i).setQuantity(temp-1);
					}
				}
			}
			session.setAttribute("shopCar",shopCar);
			request.getRequestDispatcher("jsp/head/shopCar.jsp").forward(request,response);
		}
		
		//清空购物车
		if("emptyShopCar".equals(target)){
			List<ShopCar> shopCar = (List<ShopCar>)session.getAttribute("shopCar");
			shopCar.clear();
			session.setAttribute("shopCar",shopCar);
			request.getRequestDispatcher("jsp/head/shopCar.jsp").forward(request,response);
		}
		
		
		
		
		//搜索商品(可通过Id，商品名，商品描述的绝对查询)
		if("searchShow".equals(target)){
			String seach = request.getParameter("searchBox");
			List<Category> listCategory = new <Category>ArrayList();
			//传来的的是id
			try{
				CategoryDAO dao1 = new DaoImple();
				Category a = dao1.selectCategoryById(Integer.parseInt(seach));
				if(a==null){
					a = new Category(); 
				}
				listCategory.add(a);
			}catch(NumberFormatException e){
				System.out.println("输入的不是id");
			}
			
			//传来的是cname
			CategoryDAO dao2 = new DaoImple();
			List<Category> list2 = dao2.selectCategoryByName(seach);
			if(list2==null){
				list2.add(new Category());
			}
			listCategory.addAll(list2);
			
			//传来的是cdec
			CategoryDAO dao3 = new DaoImple();
			List<Category> list3 = dao3.selectCategoryByCdec(seach);
			if(list3==null){
				list3.add(new Category());
			}
			listCategory.addAll(list3);
			//去空值,图片路径处理
			String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/");
			for(int i=0;i<listCategory.size();i++){
				String path = listCategory.get(i).getPsPath();
				if(path==null){
					path="";
				}
				Object[] src = deleteSubString(path,uploadFilePath);//获得图片名。后缀名
				path = "upload/" + src[0].toString();
				listCategory.get(i).setPsPath(path);
				
				if(listCategory.get(i)==null||listCategory.get(i).getCid()==0){
					listCategory.remove(i);
				}
			}
			
			//转发
			request.setAttribute("listCategory",listCategory);
			request.getRequestDispatcher("jsp/head/searchShowPage.jsp").forward(request,response);
		}
/*************************************************************************************************************/
		//复选框选中，相应的商品价格显示
		if("AjaxCheckBoxTrue".equals(target)){
			PrintWriter out = response.getWriter();
			int id = Integer.parseInt(request.getParameter("cid"));
			System.out.println(id);
			List<ShopCar> shopCar = (List<ShopCar>)session.getAttribute("shopCar");
			for(int i=0;i<shopCar.size();i++){
				if(shopCar.get(i).getCid()==id){
					id = shopCar.get(i).getPrice()*shopCar.get(i).getQuantity();
				}
			}
			out.print(id);
			out.close();
		}
		//复选框取消，相应的商品价格不显示
		if("AjaxCheckBoxFalse".equals(target)){
			PrintWriter out = response.getWriter();
			int id = Integer.parseInt(request.getParameter("cid"));
			System.out.println(id);
			List<ShopCar> shopCar = (List<ShopCar>)session.getAttribute("shopCar");
			for(int i=0;i<shopCar.size();i++){
				if(shopCar.get(i).getCid()==id){
					id = shopCar.get(i).getPrice()*shopCar.get(i).getQuantity();
				}
			}
			out.print(id);
			out.close();
			
		}
/***************************************订单支付页面处理*********************************************************************/
		if("payment".equals(target)){
			//提交订单，取出购物车中得商品
			List<ShopCar> shopCar = (List<ShopCar>)session.getAttribute("shopCar");
			User user=(User)session.getAttribute("loginUser");
			request.setAttribute("shopCar",shopCar);
			if(user==null){
			request.getRequestDispatcher("/jsp/user/userlogin.jsp").forward(request,response); 	
			}else {
				
			request.getRequestDispatcher("jsp/DiDanYe.jsp").forward(request,response);	
			}
			
			
		}
		
	}
	
	
	
/*###########################################################################################################################*/	
	//一个字符串处理方法
	public Object[] deleteSubString(String str1,String str2) {
		StringBuffer sb = new StringBuffer(str1);
		int delCount = 0;
		Object[] obj = new Object[2];
 
		while (true) {
			int index = sb.indexOf(str2);
			if(index == -1) {
				break;
			}
			sb.delete(index, index+str2.length());
			delCount++;
			
		}
		if(delCount!=0) {
			obj[0] = sb.toString();
			obj[1] = delCount;
		}else {
			//不存在返回-1
			obj[0] = -1;
			obj[1] = -1;
		}
		
		return obj;
	}
	
}
