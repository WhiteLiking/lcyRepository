package com.servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connect.util.PageInfo;
import com.dao.imple.DaoImple;
import com.dao.imple.OrderDaoImple;
import com.dao.inter.CategoryDAO;
import com.dao.inter.OrdersDAO;
import com.vo.Category;
import com.vo.Orders;
public class PageInfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charSet=utf-8");
		String target = request.getParameter("target");
		/**********************创建业务逻辑********************************************/
		if("info".equals(target)){
			DaoImple dao = new DaoImple();
			List<Category> listCategory = new ArrayList<Category>();
			int totalRecord = dao.selectTotalRecordBySQL("select count(*) from category");//总记录
			int currentPage = -1;//当前页
			int perPageStart = -1;//每一页的第一条记录Id
			int perPageEnd = -1;//每一夜的最后一条记录Id
			
			/*********************分页部分*****************************************/
			HttpSession session = request.getSession(true);
			PageInfo cpage =(PageInfo)session.getAttribute("Info");
			String ca = request.getParameter("cpage");
			int cp = -1;//当前页的请求
			if(ca==null||ca=="" || cpage==null){
				cp = 1;
				cpage = new PageInfo();
			}else{
				//取出当前页数
				cp = Integer.parseInt(ca);
				//当前页数只能在1~总页数之间
				if(cp<1){
					cp = 1;
				}
				if(cp>cpage.getTotalPage()){
					cp = cpage.getTotalPage();//1;
				}
				cpage.setCurrentPage(cp);
				
			}
			//导入总记录数
			cpage.setTotalRecord(totalRecord);
			
			
			currentPage = cpage.getCurrentPage();
			perPageStart = cpage.getPerPageStart();
			perPageEnd = cpage.getPerPageEnd();
			
			//调用业务逻辑，通过当前页的第一记录和最后一条记录cid查询
			DaoImple daoIm = new DaoImple();
			listCategory = daoIm.selectCategoryBy2Id(perPageStart,perPageEnd);
			System.out.println(listCategory);
			
			System.out.println(listCategory.size());
			//放到session中，与PageInfo.jsp共享
			session.setAttribute("listCategory",listCategory);
			session.setAttribute("Info",cpage);
			request.getRequestDispatcher("jsp/util/PageInfo.jsp").forward(request,response);
			//response.sendRedirect("jsp/util/PageInfo.jsp");
		}
		//查看所有订单
		if("lookAllOrders".equals(target)){
			List<Orders> order = new <Orders>ArrayList();
			OrdersDAO dao = new OrderDaoImple();
			order = dao.selectOrderSBySql("select * from orders");
			request.setAttribute("order",order);
			request.getRequestDispatcher("jsp/util/orders.jsp").forward(request,response);
		}
		
		//接收修改订单请求
		if("updateOrderRequest".equals(target)){
			int oid = Integer.parseInt(request.getParameter("oid"));
			String userno = request.getParameter("userno");
			Orders or = new Orders();
			or.setOid(oid);
			or.setUserno(userno);
			HttpSession seesion = request.getSession(true);
			seesion.setAttribute("ord",or);
			request.getRequestDispatcher("jsp/util/updateOrder.jsp").forward(request,response);
			
		}
		
		//修改订单
		if("updateOrder".equals(target)){
			int oid = Integer.parseInt(request.getParameter("oid"));
			String userno = request.getParameter("userno");
			String oname = request.getParameter("oname");
			int price = Integer.parseInt(request.getParameter("price"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			String name = request.getParameter("name");
			String telephone = request.getParameter("telephone");
			String address = request.getParameter("address");
			
			Orders order = new Orders();
			order.setOname(oname);
			order.setPrice(price);
			order.setPsum(quantity);
			order.setName(name);
			order.setTelephone(telephone);
			order.setAderss(address);
			order.setOid(oid);
			order.setUserno(userno);
			OrdersDAO dao = new OrderDaoImple();
			dao.updateOrders(order);
			
			request.getRequestDispatcher("Info?target=lookAllOrders").forward(request,response);
			
		}
		
		//删除订单
		if("deleteOrders".equals(target)){
			int oid = Integer.parseInt(request.getParameter("oid"));
			Orders order = new Orders();
			order.setOid(oid);
			OrdersDAO dao = new OrderDaoImple();
			dao.deleteOrders(order);
			System.out.println("删除订单成功！");
			request.getRequestDispatcher("Info?target=lookAllOrders").forward(request,response);

		}
	}
}
