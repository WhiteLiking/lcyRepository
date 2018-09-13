package com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.Test.Test;
import com.Test.TestImple;
import com.dao.imple.DaoImple;
import com.dao.inter.CategoryDAO;
import com.vo.Category;

public class UseDao extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charSet=utf-8");
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charSet=utf-8");
		//���������źţ���������Ӧ����Ӧ
		String ask = request.getParameter("target");
/************************************************************************************/		
		if("addProduct".equals(ask)){
			
			//���ܿͻ��˷�����Ajax����
			PrintWriter outAjax = response.getWriter();
			String flag = request.getParameter("flag");
			int row = -1;
			
			PrintWriter out = response.getWriter();
			String uploadFileName = "";//�ϴ����ļ���
			String fileName = "";//���ֶ�Ԫ�ص�name����
			//�ж�request������Ϣ�е������Ƿ���multipart����
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			//�ϴ��ļ��Ĵ洢·����webӦ����tomcat�Ĳ���·���е�uploadĿ¼��
			String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/");
			if(isMultipart){
				//ͨ��FileItemFactory�Ķ��󣬲���ServletFileUpload����
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory); 
				try {
					//������յ���Ϣ
					Category category = new Category();
					String fName=null;
					//����form���е������ֶ�
					List<FileItem> items = upload.parseRequest(request);
					//����form���ĵ������ֶ�Ԫ��
					Iterator<FileItem> iter = items.iterator();
					
					while(iter.hasNext()){
						FileItem iterm = (FileItem)iter.next();
						//�������ͨ�ֶ�
						if(iterm.isFormField()){
							//��ȡ�����ֶ��е�name����ֵ
							fileName  = iterm.getFieldName();
							//���δ���ÿ���ֶ�
							if(fileName.equals("cname")){
								category.setCname(iterm.getString("utf-8"));
							}
							if(fileName.equals("cdec")){
								category.setCdec(iterm.getString("utf-8"));
							}
							if(fileName.equals("price")){
								category.setPrice(Integer.parseInt(iterm.getString("utf-8")));
							}
							if(fileName.equals("version")){
								category.setVersion(iterm.getString("utf-8"));
							}
							if(fileName.equals("ground")){
								category.setGround(Integer.parseInt(iterm.getString("utf-8")));
							}
							if(fileName.equals("quantity")){
								category.setQuantity(Integer.parseInt(iterm.getString("utf-8")));
							}
						}else{//�ļ��ֶ�
							//��ȡ�����ϴ����ļ���
							String fieldName = iterm.getName();
							fName = uploadFilePath+fieldName;
							if(fieldName!=null&&!fieldName.equals("")){
								File saveFile = new File(fName);
								try {
									iterm.write(saveFile);
									System.out.println("�ϴ��ɹ���");
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									System.out.println("�ϴ��ļ�ʧ�ܣ�");
								}
							}
						}
					}
					//����ҵ���߼�
					CategoryDAO dao = new DaoImple();
					category.setPsPath(fName);
					row = dao.addCategory(category);
					if(row>=1){
						System.out.println("��ӳɹ�");
						outAjax.print("seccessfully");//��ӳɹ�����ӦAjax������
					}else{
						System.out.println("���ʧ��");
						outAjax.print("unseccessfully");//��ӳɹ�����ӦAjax������
					}
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
//			//��ȡֵ
//			//int cid = Integer.parseInt(request.getParameter("cid"));
//			String cname = request.getParameter("cname");
//			String cdec = request.getParameter("cdec");
//			int price = Integer.parseInt(request.getParameter("price"));
//			String version = request.getParameter("version");
//			int ground = Integer.parseInt(request.getParameter("ground"));
//			int quantity = Integer.parseInt(request.getParameter("quantity"));
//			//�������
//			Category category = new Category();
//			//category.setCid(cid);
//			category.setCname(cname);
//			category.setCdec(cdec);
//			category.setPrice(price);
//			category.setVersion(version);
//			category.setGround(ground);
//			category.setQuantity(quantity);
//			//����ҵ���߼�DAO
//			CategoryDAO dao = new DaoImple();
//			dao.addCategory(category);
//			System.out.println("��ӳɹ�");
			
		}
/*********************************************************************************/
		if("deleteProduct".equals(ask)){
			//��������
			List<Category> listCategory = new <Category>ArrayList();
			String dele = request.getParameter("dele");
			//�����ĵ���id
			try{
				
				CategoryDAO dao1 = new DaoImple();
				Category a = dao1.selectCategoryById(Integer.parseInt(dele));
				if(a==null){
					a.setCid(0);
				}
				listCategory.add(a);
			}catch(NumberFormatException e){
				System.out.println("����Ĳ���id");
			}
			
			//��������cname
			CategoryDAO dao2 = new DaoImple();
			List<Category> list2 = dao2.selectCategoryByName(dele);
			if(list2==null){
				list2.add(new Category());
			}
			listCategory.addAll(list2);
			
			//��������cdec
			CategoryDAO dao3 = new DaoImple();
			List<Category> list3 = dao3.selectCategoryByCdec(dele);
			if(list3==null){
				list3.add(new Category());
			}
			listCategory.addAll(list3);
			//ȥ��ֵ
			for(int i=0;i<listCategory.size();i++){
				if(listCategory.get(i).getCid()<1){
					listCategory.remove(i);
				}
			}
			//ת��
			//HttpSession session = request.getSession(true);
			request.setAttribute("listCategory",listCategory);
			request.getRequestDispatcher("jsp/back/deletePage.jsp").forward(request,response);
			}
/****************************************************************************************/
		//�û���ѡ���Ҫɾ����Ʒ����������ɾ��
		if("deleteOne".equals(ask)){
			PrintWriter out = response.getWriter();
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("��UserDao��"+id);
			
			//����Dao
			CategoryDAO dao = new DaoImple();
			Category category = new Category();
			category.setCid(id);
			int row = dao.deleteCategory(category);
			if(row>=1){
				out.print("true");
			}else{
				out.print("false");
			}
			
			//ɾ������Ʒ�󽫸���Ʒ���cid����ȥ1��
//			CategoryDAO dao1 = new DaoImple();
//			while(dao1.selectCategoryById(id)!=null){
//				CategoryDAO dao2 = new DaoImple();
//				dao2.updateCategoryById(id);
//				id++;
//			}
			
				

		}
/************************************************************************************/
		if("updateProduct".equals(ask)){
			
			List<Category> listCategory = new <Category>ArrayList();
			String update = request.getParameter("update");
			//�����ĵ���id
			try{
				CategoryDAO dao1 = new DaoImple();
				Category a = dao1.selectCategoryById(Integer.parseInt(update));
				if(a==null){
					a.setCid(0);
				}
				listCategory.add(a);
			}catch(NumberFormatException e){
				System.out.println("����Ĳ���id");
			}
			
			//��������cname
			CategoryDAO dao2 = new DaoImple();
			List<Category> list2 = dao2.selectCategoryByName(update);
			if(list2==null){
				list2.add(new Category());
			}
			listCategory.addAll(list2);
			
			//��������cdec
			CategoryDAO dao3 = new DaoImple();
			List<Category> list3 = dao3.selectCategoryByCdec(update);
			if(list3==null){
				list3.add(new Category());
			}
			listCategory.addAll(list3);
			//ȥ��ֵ
			for(int i=0;i<listCategory.size();i++){
				if(listCategory.get(i).getCid()<1){
					listCategory.remove(i);
				}
			}
			//ת��
			request.setAttribute("listCategory",listCategory);
			request.getRequestDispatcher("jsp/back/updatePage.jsp").forward(request,response);
		}
/*****************************************************************************************/
		if("updateOne".equals(ask)){
			//��ȡҪ�޸ĵ�idֵ
			int id = Integer.parseInt(request.getParameter("id"));
			HttpSession session = request.getSession(true);
			session.setAttribute("cid",id);
			request.getRequestDispatcher("jsp/back/updateInput.jsp").forward(request,response);
		}
/********************************************************************************/
		//�û��޸���Ϣ������ϣ������޸�����
		if("updateInputOver".equals(ask)){
			HttpSession session = request.getSession(true);
			int id = (int)session.getAttribute("cid");
			String uploadFileName = "";//�ϴ����ļ���
			String fileName = "";//���ֶ�Ԫ�ص�name����
			//�ж�request������Ϣ�е������Ƿ���multipart����
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			//�ϴ��ļ��Ĵ洢·����webӦ����tomcat�Ĳ���·���е�uploadĿ¼��
			String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/");
			if(isMultipart){
				//ͨ��FileItemFactory�Ķ��󣬲���ServletFileUpload����
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory); 
				try {
					//������յ���Ϣ
					Category category = new Category();
					String fName=null;
					//����form���е������ֶ�
					List<FileItem> items = upload.parseRequest(request);
					//����form���ĵ������ֶ�Ԫ��
					Iterator<FileItem> iter = items.iterator();
					
					while(iter.hasNext()){
						FileItem iterm = (FileItem)iter.next();
						//�������ͨ�ֶ�
						if(iterm.isFormField()){
							//��ȡ�����ֶ��е�name����ֵ
							fileName  = iterm.getFieldName();
							//���δ���ÿ���ֶ�
							if(fileName.equals("cname")){
								category.setCname(iterm.getString("utf-8"));
							}
							if(fileName.equals("cdec")){
								category.setCdec(iterm.getString("utf-8"));
							}
							if(fileName.equals("price")){
								category.setPrice(Integer.parseInt(iterm.getString("utf-8")));
							}
							if(fileName.equals("version")){
								category.setVersion(iterm.getString("utf-8"));
							}
							if(fileName.equals("ground")){
								category.setGround(Integer.parseInt(iterm.getString("utf-8")));
							}
							if(fileName.equals("quantity")){
								category.setQuantity(Integer.parseInt(iterm.getString("utf-8")));
							}
						}else{//�ļ��ֶ�
							//��ȡ�����ϴ����ļ���
							String fieldName = iterm.getName();
							fName = uploadFilePath+fieldName;
							if(fieldName!=null&&!fieldName.equals("")){
								File saveFile = new File(fName);
								try {
									iterm.write(saveFile);
									System.out.println("�ϴ��ɹ���");
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									System.out.println("�ϴ��ļ�ʧ�ܣ�");
								}
							}
						}
					}
					//����ҵ���߼�
					request.getParameter("flag");
					PrintWriter out = response.getWriter();
					CategoryDAO dao = new DaoImple();
					category.setCid(id);
					category.setPsPath(fName);
					
					int row = dao.updateCategory(category);
					if(row>=1){
						System.out.println("�޸ĳɹ���");
						out.print("seccessfully");
					}else{
						out.print("unseccessfully");
					}
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
//			//���ܲ�����id��,�������
//			HttpSession session = request.getSession(true);
//			Category category = new Category();
//			category.setCid((int)(session.getAttribute("cid")));
//			System.out.println(category.getCid());
//			category.setCname(request.getParameter("cname"));
//			category.setCdec(request.getParameter("cdec"));
//			category.setPrice(Integer.parseInt(request.getParameter("price")));
//			category.setVersion(request.getParameter("version"));
//			category.setGround(Integer.parseInt(request.getParameter("ground")));
//			category.setQuantity(Integer.parseInt( request.getParameter("quantity")));
//			
//			//����Dao
//			CategoryDAO dao = new DaoImple();
//			dao.updateCategory(category);
//			System.out.println("�޸ĳɹ�");
//			
			
			}
		}
		//�ϼ�
		if("upGround".equals(ask)){
			//����Id�͵�ǰҳ,ͨ��id��ѯ�޸�ground����
			int currentPage = Integer.parseInt(request.getParameter("currentPage"));
			int id = Integer.parseInt(request.getParameter("id"));
			CategoryDAO dao = new DaoImple();
			Category category = dao.selectCategoryById(id);
			category.setGround(1);//�ϼ�
			//����
			CategoryDAO dao1 = new DaoImple();
			dao1.updateCategory(category);//�޸Ľ���
			//ת��
			request.setAttribute("page",currentPage);
			request.getRequestDispatcher("Manager?target=upGround").forward(request,response);
			
		}
		//�¼�
		if("downGround".equals(ask)){
			//����Id�͵�ǰҳ,ͨ��id��ѯ�޸�ground����
			int currentPage = Integer.parseInt(request.getParameter("currentPage"));
			int id = Integer.parseInt(request.getParameter("id"));
			CategoryDAO dao = new DaoImple();
			Category category = dao.selectCategoryById(id);
			category.setGround(0);//�¼�
			//����
			CategoryDAO dao1 = new DaoImple();
			dao1.updateCategory(category);//�޸Ľ���
			//ת��
			request.setAttribute("page",currentPage);
			request.getRequestDispatcher("Manager?target=downGround").forward(request,response);
		}
	}
}
