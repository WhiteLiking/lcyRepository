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
		
		
/*******************************************��ҳ����ʾ��Ĭ�����չʾ�ĸ���Ʒ**********************************************************************/
		//����ǰ��������Ϣ
		String target = request.getParameter("target");
		if("".equals(target)||target==null){
			
			//��ҳ��ʾ�棬����Ϊ����Ĭ���������򣬵���DAO��ȡ��������Ʒ����ʾ�ڿͻ�����ҳ
			CategoryDAO dao = new DaoImple();
			List<Category> listCategory = dao.selectCategoryBySQL("select * from category");//ȡ��������Ʒ
			
			//��ȡͼƬ�洢·���ĸ�·�����ϴ�����·����
			String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/");
			//��������������ͼƬ·��
			for(int i =0;i<listCategory.size();i++){
				//ȡ��ÿ����Ʒ��ͼƬ·������������·����������·��
				String path = listCategory.get(i).getPsPath();
				//����Ʒû��ͼƬ����·����Ϊ��
				if(path==null){
					path="";
				}
				Object[] src = deleteSubString(path,uploadFilePath);//���ͼƬ������׺��
				path = "upload/" + src[0].toString();//�õ����·��
				//���ͼƬ��������
				listCategory.get(i).setPsPath(path);
				
				//�ж��Ƿ��¼ܣ�����¼ܣ��Ͳ�����ǰ��չʾ
				if(listCategory.get(i).getGround()==0){
					listCategory.remove(i);
				}
			}
			//ת����ǰ����ҳ
			request.setAttribute("listCategory",listCategory);
			request.getRequestDispatcher("jsp/head/mainPage.jsp").forward(request,response);
		}
/*###########################################################################################*/	
		//��Ʒ����ҳ
		if("productMessagePage".equals(target)){
			int cid = Integer.parseInt(request.getParameter("cid"));
			//�����ݿ��в������Ʒ
			CategoryDAO dao = new DaoImple();
			Category category = dao.selectCategoryById(cid);
			
			String path = category.getPsPath();
			//��ȡͼƬ�洢·���ĸ�·�����ϴ�����·����
			String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/");
			//����Ʒû��ͼƬ����·����Ϊ��
			if(path==null){
				path="";
			}
			Object[] src = deleteSubString(path,uploadFilePath);//���ͼƬ������׺��
			path = "upload/" + src[0].toString();//�õ����·��
			//���ͼƬ��������
			category.setPsPath(path);
			//ת������Ʒ����ҳ,������ʾ
			request.setAttribute("product",category);
			request.getRequestDispatcher("jsp/head/productDetails.jsp").forward(request,response);
		}
/*########################################################################################*/
		//���ﳵ
		HttpSession session = request.getSession(true);
		if("addShopCar".equals(target)){
			//���ռ��빺�ﳵ������
			int cid = Integer.parseInt(request.getParameter("id"));
			
			CategoryDAO dao = new DaoImple();
			Category category = dao.selectCategoryById(cid);
			ShopCar productCar = new ShopCar();
			
			//���ͻ�����һ�����ﳵ
			List<ShopCar> listCategory = (List<ShopCar>)session.getAttribute("shopCar");
			if(listCategory==null){//���Ϊ�գ���ͻ���һ��ʹ�ù��ﳵ��Ϊ������
				listCategory = new <ShopCar>ArrayList();
			}
			//����Ʒ�ŵ�session��������,���Ҳ��ܼ����ظ�����Ʒ
			int flag = 1;//��־��-1���ʧ�ܣ�0���ڹ��ﳵ�У�1��ӳɹ�
			for(int i=0;i<listCategory.size();i++){
				
				if(listCategory.get(i).getCid()==category.getCid()){
					//���ﳵ�����и���Ʒ��������Ʒ������1
					flag=0;
					int temp = listCategory.get(i).getQuantity();
					listCategory.get(i).setQuantity(temp+1);
				}	
				if(listCategory.get(i).getCid()==0){
					listCategory.remove(i);
				}
			}
			
			if(flag==1){
				//���빺�ﳵ��
				productCar.setCid(category.getCid());
				productCar.setCname(category.getCname());
				productCar.setCdec(category.getCdec());
				productCar.setPrice(category.getPrice());
				productCar.setVersion(category.getVersion());
				productCar.setPsPath(category.getPsPath());
				listCategory.add(productCar);//��ӹ��ﳵ
			}
			session.setAttribute("shopCar",listCategory);
			//ת�������ﳵ
			//request.getRequestDispatcher("HeadMainPage").forward(request,response);
			response.sendRedirect("HeadMainPage");
			//return;
		}
/******************************************���ﳵ**********************************************************/
		//�鿴���ﳵ
		if("lookShopCar".equals(target)){
			//ȡ�����ﳵ�е�������Ʒ�����ڹ��ﳵҳ������ʾ
			List<ShopCar> listCategory = (List)session.getAttribute("shopCar");
			
			if(listCategory==null){//���ﳵΪ��
				listCategory = new <ShopCar>ArrayList();
			}
			session.setAttribute("shopCar",listCategory);
			request.getRequestDispatcher("jsp/head/shopCar.jsp").forward(request,response);
		}
		
		//ɾ�����ﳵ�е���Ʒ
		if("deleteShopCar".equals(target)){
			//����Ҫɾ���Ĳ�Ʒ���,ȡ�����ﳵ��ɾ����Ӧ����Ʒ
			int id = Integer.parseInt(request.getParameter("id"));
			List<ShopCar> shopCar = (List<ShopCar>)session.getAttribute("shopCar");
			for(int i=0;i<shopCar.size();i++){
				if(shopCar.get(i).getCid()==id){
					shopCar.remove(i);
				}
			}
			//ɾ�����
			session.setAttribute("shopCar",shopCar);
			//request.getRequestDispatcher("head/shopCar.jsp").forward(request,response);
			response.sendRedirect("jsp/head/shopCar.jsp");
		}
		
		//�ڹ��ﳵ�������Ʒ����
		if("addQuantity".equals(target)){
			List<ShopCar> shopCar = (List<ShopCar>)session.getAttribute("shopCar");
			//��������
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
			
			
		//��С����
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
		
		//��չ��ﳵ
		if("emptyShopCar".equals(target)){
			List<ShopCar> shopCar = (List<ShopCar>)session.getAttribute("shopCar");
			shopCar.clear();
			session.setAttribute("shopCar",shopCar);
			request.getRequestDispatcher("jsp/head/shopCar.jsp").forward(request,response);
		}
		
		
		
		
		//������Ʒ(��ͨ��Id����Ʒ������Ʒ�����ľ��Բ�ѯ)
		if("searchShow".equals(target)){
			String seach = request.getParameter("searchBox");
			List<Category> listCategory = new <Category>ArrayList();
			//�����ĵ���id
			try{
				CategoryDAO dao1 = new DaoImple();
				Category a = dao1.selectCategoryById(Integer.parseInt(seach));
				if(a==null){
					a = new Category(); 
				}
				listCategory.add(a);
			}catch(NumberFormatException e){
				System.out.println("����Ĳ���id");
			}
			
			//��������cname
			CategoryDAO dao2 = new DaoImple();
			List<Category> list2 = dao2.selectCategoryByName(seach);
			if(list2==null){
				list2.add(new Category());
			}
			listCategory.addAll(list2);
			
			//��������cdec
			CategoryDAO dao3 = new DaoImple();
			List<Category> list3 = dao3.selectCategoryByCdec(seach);
			if(list3==null){
				list3.add(new Category());
			}
			listCategory.addAll(list3);
			//ȥ��ֵ,ͼƬ·������
			String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/");
			for(int i=0;i<listCategory.size();i++){
				String path = listCategory.get(i).getPsPath();
				if(path==null){
					path="";
				}
				Object[] src = deleteSubString(path,uploadFilePath);//���ͼƬ������׺��
				path = "upload/" + src[0].toString();
				listCategory.get(i).setPsPath(path);
				
				if(listCategory.get(i)==null||listCategory.get(i).getCid()==0){
					listCategory.remove(i);
				}
			}
			
			//ת��
			request.setAttribute("listCategory",listCategory);
			request.getRequestDispatcher("jsp/head/searchShowPage.jsp").forward(request,response);
		}
/*************************************************************************************************************/
		//��ѡ��ѡ�У���Ӧ����Ʒ�۸���ʾ
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
		//��ѡ��ȡ������Ӧ����Ʒ�۸���ʾ
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
/***************************************����֧��ҳ�洦��*********************************************************************/
		if("payment".equals(target)){
			//�ύ������ȡ�����ﳵ�е���Ʒ
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
	//һ���ַ���������
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
			//�����ڷ���-1
			obj[0] = -1;
			obj[1] = -1;
		}
		
		return obj;
	}
	
}
