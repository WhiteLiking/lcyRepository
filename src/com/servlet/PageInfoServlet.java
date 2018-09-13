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
		/**********************����ҵ���߼�********************************************/
		if("info".equals(target)){
			DaoImple dao = new DaoImple();
			List<Category> listCategory = new ArrayList<Category>();
			int totalRecord = dao.selectTotalRecordBySQL("select count(*) from category");//�ܼ�¼
			int currentPage = -1;//��ǰҳ
			int perPageStart = -1;//ÿһҳ�ĵ�һ����¼Id
			int perPageEnd = -1;//ÿһҹ�����һ����¼Id
			
			/*********************��ҳ����*****************************************/
			HttpSession session = request.getSession(true);
			PageInfo cpage =(PageInfo)session.getAttribute("Info");
			String ca = request.getParameter("cpage");
			int cp = -1;//��ǰҳ������
			if(ca==null||ca=="" || cpage==null){
				cp = 1;
				cpage = new PageInfo();
			}else{
				//ȡ����ǰҳ��
				cp = Integer.parseInt(ca);
				//��ǰҳ��ֻ����1~��ҳ��֮��
				if(cp<1){
					cp = 1;
				}
				if(cp>cpage.getTotalPage()){
					cp = cpage.getTotalPage();//1;
				}
				cpage.setCurrentPage(cp);
				
			}
			//�����ܼ�¼��
			cpage.setTotalRecord(totalRecord);
			
			
			currentPage = cpage.getCurrentPage();
			perPageStart = cpage.getPerPageStart();
			perPageEnd = cpage.getPerPageEnd();
			
			//����ҵ���߼���ͨ����ǰҳ�ĵ�һ��¼�����һ����¼cid��ѯ
			DaoImple daoIm = new DaoImple();
			listCategory = daoIm.selectCategoryBy2Id(perPageStart,perPageEnd);
			System.out.println(listCategory);
			
			System.out.println(listCategory.size());
			//�ŵ�session�У���PageInfo.jsp����
			session.setAttribute("listCategory",listCategory);
			session.setAttribute("Info",cpage);
			request.getRequestDispatcher("jsp/util/PageInfo.jsp").forward(request,response);
			//response.sendRedirect("jsp/util/PageInfo.jsp");
		}
		//�鿴���ж���
		if("lookAllOrders".equals(target)){
			List<Orders> order = new <Orders>ArrayList();
			OrdersDAO dao = new OrderDaoImple();
			order = dao.selectOrderSBySql("select * from orders");
			request.setAttribute("order",order);
			request.getRequestDispatcher("jsp/util/orders.jsp").forward(request,response);
		}
		
		//�����޸Ķ�������
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
		
		//�޸Ķ���
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
		
		//ɾ������
		if("deleteOrders".equals(target)){
			int oid = Integer.parseInt(request.getParameter("oid"));
			Orders order = new Orders();
			order.setOid(oid);
			OrdersDAO dao = new OrderDaoImple();
			dao.deleteOrders(order);
			System.out.println("ɾ�������ɹ���");
			request.getRequestDispatcher("Info?target=lookAllOrders").forward(request,response);

		}
	}
}
