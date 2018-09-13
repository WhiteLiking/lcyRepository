package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connect.util.PageInfo;
import com.dao.imple.DaoImple;
import com.vo.Category;

public class Manager extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charSet=utf-8");
		
		//����ҳ�淢���Ĳ���
		String ask = request.getParameter("target");
		//�жϽ���������������Ӧ
		if("Info".equals(ask)){
			request.getRequestDispatcher("Info").forward(request,response);
		}
		
		if("jsp/back/addProduct.jsp".equals(ask)){
			request.getRequestDispatcher("jsp/back/addProduct.jsp").forward(request,response);
		}
		
		if("jsp/back/deleteProduct.jsp".equals(ask)){
			request.getRequestDispatcher("jsp/back/deleteProduct.jsp").forward(request,response);
		}
		
		if("jsp/back/updateProduct.jsp".equals(ask)){
			request.getRequestDispatcher("jsp/back/updateProduct.jsp").forward(request,response);
		}
		
		//�ϼܴ���
		if("upGround".equals(ask)){
			int page = (int)request.getAttribute("page");
			DaoImple dao = new DaoImple();
			List<Category> listCategory = new ArrayList<Category>();
			int totalRecord = dao.selectTotalRecordBySQL("select count(*) from category");//�ܼ�¼
			int currentPage = -1;//��ǰҳ
			int perPageStart = -1;//ÿһҳ�ĵ�һ����¼Id
			int perPageEnd = -1;//ÿһҹ�����һ����¼Id
			
			/*********************��ҳ����*****************************************/
			HttpSession session = request.getSession(true);
			PageInfo cpage = new PageInfo();
			cpage.setCurrentPage(page); 
			
			cpage.setTotalRecord(totalRecord);
			currentPage = cpage.getCurrentPage();
			perPageStart = cpage.getPerPageStart();
			perPageEnd = cpage.getPerPageEnd();
			System.out.println(currentPage+"-"+perPageStart+"-"+perPageEnd+"-"+totalRecord);
			//����ҵ���߼���ͨ����ǰҳ�ĵ�һ��¼�����һ����¼cid��ѯ
			DaoImple daoIm = new DaoImple();
			listCategory = daoIm.selectCategoryBy2Id(perPageStart,perPageEnd);
			
			System.out.println(listCategory.size());
			//�ŵ�session�У���PageInfo.jsp����
			session.setAttribute("listCategory",listCategory);
			session.setAttribute("Info",cpage);
			request.getRequestDispatcher("jsp/util/PageInfo.jsp").forward(request,response);
			//response.sendRedirect("jsp/util/PageInfo.jsp");
		}
		//�¼ܴ���
		if("downGround".equals(ask)){
			int page = (int)request.getAttribute("page");
			DaoImple dao = new DaoImple();
			List<Category> listCategory = new ArrayList<Category>();
			int totalRecord = dao.selectTotalRecordBySQL("select count(*) from category");//�ܼ�¼
			int currentPage = -1;//��ǰҳ
			int perPageStart = -1;//ÿһҳ�ĵ�һ����¼Id
			int perPageEnd = -1;//ÿһҹ�����һ����¼Id
			
			/*********************��ҳ����*****************************************/
			HttpSession session = request.getSession(true);
			PageInfo cpage = new PageInfo();
			cpage.setCurrentPage(page); 
			
			cpage.setTotalRecord(totalRecord);
			currentPage = cpage.getCurrentPage();
			perPageStart = cpage.getPerPageStart();
			perPageEnd = cpage.getPerPageEnd();
			System.out.println(currentPage+"-"+perPageStart+"-"+perPageEnd+"-"+totalRecord);
			//����ҵ���߼���ͨ����ǰҳ�ĵ�һ��¼�����һ����¼cid��ѯ
			DaoImple daoIm = new DaoImple();
			listCategory = daoIm.selectCategoryBy2Id(perPageStart,perPageEnd);
			
			System.out.println(listCategory.size());
			//�ŵ�session�У���PageInfo.jsp����
			session.setAttribute("listCategory",listCategory);
			session.setAttribute("Info",cpage);
			request.getRequestDispatcher("jsp/util/PageInfo.jsp").forward(request,response);
		}
	}
	
}
