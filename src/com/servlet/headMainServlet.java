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

import com.dao.imple.OrderDaoImple;
import com.dao.inter.OrdersDAO;
import com.vo.Orders;
import com.vo.ShopCar;
import com.vo.User;

public class headMainServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charSet=utf-8");
		// TODO Auto-generated method stub
		String target = request.getParameter("target");
		
		//接收订单详细信息
		if("paymentAddress".equals(target)){
			//接收到订单收件信息
			String receiver_name = request.getParameter("receiver_name");
			String phoneNumber = request.getParameter("phoneNumber");
			String province = request.getParameter("province");
			String city = request.getParameter("city");
			String area = request.getParameter("area");
			String receiver_address =request.getParameter("receiver_address");
			
			
			
			//取出订单商品信息
			List<Orders> listOrder = new <Orders>ArrayList();
			HttpSession session = request.getSession(true);
			
			//用户登录名
			User user=(User)session.getAttribute("loginUser");
			String name = user.getUsername();
			
			List<ShopCar> shopCar = (List<ShopCar>)session.getAttribute("shopCar");
			for(int i=0;i<shopCar.size();i++){
				Orders order = new Orders();
				order.setOid(shopCar.get(i).getCid());
				order.setOname(shopCar.get(i).getCname());
				order.setPrice(shopCar.get(i).getPrice());
				order.setPsum(shopCar.get(i).getQuantity());
				
				order.setName(receiver_name);
				order.setTelephone(phoneNumber);
				order.setAderss(province+city+area+receiver_address);
				order.setUserno(name);
				
				listOrder.add(order);
			}
			
			System.out.println(listOrder);
			session.setAttribute("shopCar",shopCar);
			session.setAttribute("productOrder",listOrder);
			request.getRequestDispatcher("jsp/DiDanYe.jsp").forward(request,response);
			
		}
		//确认提交订单，将订单存入数据库
		if("orderSure".equals(target)){
			//取出订单的商品和地址
			HttpSession session = request.getSession(true);
			List<Orders> order = (List<Orders>)session.getAttribute("productOrder");
			for(int i=0;i<order.size();i++){
				OrdersDAO dao = new OrderDaoImple();
				dao.addOrdres(order.get(i));
			}
			session.setAttribute("productOrder",order);
			request.getRequestDispatcher("jsp/ZhiFu.jsp").forward(request,response);
		}
		
		//支付成功，清空订单返回主页
		if("clearPayment".equals(target)){
			response.sendRedirect("index.jsp");
		}
		//返回主页，清空购物车
		if("returnMainPage".equals(target)){
			HttpSession session = request.getSession(true);
			List<ShopCar> shopCar = (List<ShopCar>)session.getAttribute("shopCar");
			shopCar.clear();
			response.sendRedirect("HeadMainPage");
		}
		
	}
	
	
}
