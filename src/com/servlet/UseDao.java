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
		//接收请求信号，并作出相应的响应
		String ask = request.getParameter("target");
/************************************************************************************/		
		if("addProduct".equals(ask)){
			
			//接受客户端发来的Ajax请求
			PrintWriter outAjax = response.getWriter();
			String flag = request.getParameter("flag");
			int row = -1;
			
			PrintWriter out = response.getWriter();
			String uploadFileName = "";//上传的文件名
			String fileName = "";//表字段元素的name属性
			//判断request请求信息中的内容是否是multipart类型
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			//上传文件的存储路径（web应用在tomcat的部署路径中的upload目录）
			String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/");
			if(isMultipart){
				//通过FileItemFactory的对象，产生ServletFileUpload对象
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory); 
				try {
					//保存接收的信息
					Category category = new Category();
					String fName=null;
					//解析form表单中的所有字段
					List<FileItem> items = upload.parseRequest(request);
					//遍历form表单的的所有字段元素
					Iterator<FileItem> iter = items.iterator();
					
					while(iter.hasNext()){
						FileItem iterm = (FileItem)iter.next();
						//如果是普通字段
						if(iterm.isFormField()){
							//获取表单中字段中的name属性值
							fileName  = iterm.getFieldName();
							//依次处理每个字段
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
						}else{//文件字段
							//获取正在上传的文件名
							String fieldName = iterm.getName();
							fName = uploadFilePath+fieldName;
							if(fieldName!=null&&!fieldName.equals("")){
								File saveFile = new File(fName);
								try {
									iterm.write(saveFile);
									System.out.println("上传成功！");
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									System.out.println("上传文件失败！");
								}
							}
						}
					}
					//调用业务逻辑
					CategoryDAO dao = new DaoImple();
					category.setPsPath(fName);
					row = dao.addCategory(category);
					if(row>=1){
						System.out.println("添加成功");
						outAjax.print("seccessfully");//添加成功，响应Ajax的请求
					}else{
						System.out.println("添加失败");
						outAjax.print("unseccessfully");//添加成功，响应Ajax的请求
					}
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
//			//获取值
//			//int cid = Integer.parseInt(request.getParameter("cid"));
//			String cname = request.getParameter("cname");
//			String cdec = request.getParameter("cdec");
//			int price = Integer.parseInt(request.getParameter("price"));
//			String version = request.getParameter("version");
//			int ground = Integer.parseInt(request.getParameter("ground"));
//			int quantity = Integer.parseInt(request.getParameter("quantity"));
//			//填充数据
//			Category category = new Category();
//			//category.setCid(cid);
//			category.setCname(cname);
//			category.setCdec(cdec);
//			category.setPrice(price);
//			category.setVersion(version);
//			category.setGround(ground);
//			category.setQuantity(quantity);
//			//调用业务逻辑DAO
//			CategoryDAO dao = new DaoImple();
//			dao.addCategory(category);
//			System.out.println("添加成功");
			
		}
/*********************************************************************************/
		if("deleteProduct".equals(ask)){
			//接收数据
			List<Category> listCategory = new <Category>ArrayList();
			String dele = request.getParameter("dele");
			//传来的的是id
			try{
				
				CategoryDAO dao1 = new DaoImple();
				Category a = dao1.selectCategoryById(Integer.parseInt(dele));
				if(a==null){
					a.setCid(0);
				}
				listCategory.add(a);
			}catch(NumberFormatException e){
				System.out.println("输入的不是id");
			}
			
			//传来的是cname
			CategoryDAO dao2 = new DaoImple();
			List<Category> list2 = dao2.selectCategoryByName(dele);
			if(list2==null){
				list2.add(new Category());
			}
			listCategory.addAll(list2);
			
			//传来的是cdec
			CategoryDAO dao3 = new DaoImple();
			List<Category> list3 = dao3.selectCategoryByCdec(dele);
			if(list3==null){
				list3.add(new Category());
			}
			listCategory.addAll(list3);
			//去空值
			for(int i=0;i<listCategory.size();i++){
				if(listCategory.get(i).getCid()<1){
					listCategory.remove(i);
				}
			}
			//转发
			//HttpSession session = request.getSession(true);
			request.setAttribute("listCategory",listCategory);
			request.getRequestDispatcher("jsp/back/deletePage.jsp").forward(request,response);
			}
/****************************************************************************************/
		//用户已选择好要删除商品并返回请求删除
		if("deleteOne".equals(ask)){
			PrintWriter out = response.getWriter();
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("在UserDao的"+id);
			
			//调用Dao
			CategoryDAO dao = new DaoImple();
			Category category = new Category();
			category.setCid(id);
			int row = dao.deleteCategory(category);
			if(row>=1){
				out.print("true");
			}else{
				out.print("false");
			}
			
			//删除该商品后将该商品后的cid都减去1；
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
			//传来的的是id
			try{
				CategoryDAO dao1 = new DaoImple();
				Category a = dao1.selectCategoryById(Integer.parseInt(update));
				if(a==null){
					a.setCid(0);
				}
				listCategory.add(a);
			}catch(NumberFormatException e){
				System.out.println("输入的不是id");
			}
			
			//传来的是cname
			CategoryDAO dao2 = new DaoImple();
			List<Category> list2 = dao2.selectCategoryByName(update);
			if(list2==null){
				list2.add(new Category());
			}
			listCategory.addAll(list2);
			
			//传来的是cdec
			CategoryDAO dao3 = new DaoImple();
			List<Category> list3 = dao3.selectCategoryByCdec(update);
			if(list3==null){
				list3.add(new Category());
			}
			listCategory.addAll(list3);
			//去空值
			for(int i=0;i<listCategory.size();i++){
				if(listCategory.get(i).getCid()<1){
					listCategory.remove(i);
				}
			}
			//转发
			request.setAttribute("listCategory",listCategory);
			request.getRequestDispatcher("jsp/back/updatePage.jsp").forward(request,response);
		}
/*****************************************************************************************/
		if("updateOne".equals(ask)){
			//获取要修改的id值
			int id = Integer.parseInt(request.getParameter("id"));
			HttpSession session = request.getSession(true);
			session.setAttribute("cid",id);
			request.getRequestDispatcher("jsp/back/updateInput.jsp").forward(request,response);
		}
/********************************************************************************/
		//用户修改信息输入完毕，返回修改请求
		if("updateInputOver".equals(ask)){
			HttpSession session = request.getSession(true);
			int id = (int)session.getAttribute("cid");
			String uploadFileName = "";//上传的文件名
			String fileName = "";//表字段元素的name属性
			//判断request请求信息中的内容是否是multipart类型
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			//上传文件的存储路径（web应用在tomcat的部署路径中的upload目录）
			String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/");
			if(isMultipart){
				//通过FileItemFactory的对象，产生ServletFileUpload对象
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory); 
				try {
					//保存接收的信息
					Category category = new Category();
					String fName=null;
					//解析form表单中的所有字段
					List<FileItem> items = upload.parseRequest(request);
					//遍历form表单的的所有字段元素
					Iterator<FileItem> iter = items.iterator();
					
					while(iter.hasNext()){
						FileItem iterm = (FileItem)iter.next();
						//如果是普通字段
						if(iterm.isFormField()){
							//获取表单中字段中的name属性值
							fileName  = iterm.getFieldName();
							//依次处理每个字段
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
						}else{//文件字段
							//获取正在上传的文件名
							String fieldName = iterm.getName();
							fName = uploadFilePath+fieldName;
							if(fieldName!=null&&!fieldName.equals("")){
								File saveFile = new File(fName);
								try {
									iterm.write(saveFile);
									System.out.println("上传成功！");
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									System.out.println("上传文件失败！");
								}
							}
						}
					}
					//调用业务逻辑
					request.getParameter("flag");
					PrintWriter out = response.getWriter();
					CategoryDAO dao = new DaoImple();
					category.setCid(id);
					category.setPsPath(fName);
					
					int row = dao.updateCategory(category);
					if(row>=1){
						System.out.println("修改成功！");
						out.print("seccessfully");
					}else{
						out.print("unseccessfully");
					}
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
//			//接受参数（id）,填充数据
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
//			//调用Dao
//			CategoryDAO dao = new DaoImple();
//			dao.updateCategory(category);
//			System.out.println("修改成功");
//			
			
			}
		}
		//上架
		if("upGround".equals(ask)){
			//接收Id和当前页,通过id查询修改ground属性
			int currentPage = Integer.parseInt(request.getParameter("currentPage"));
			int id = Integer.parseInt(request.getParameter("id"));
			CategoryDAO dao = new DaoImple();
			Category category = dao.selectCategoryById(id);
			category.setGround(1);//上架
			//插入
			CategoryDAO dao1 = new DaoImple();
			dao1.updateCategory(category);//修改结束
			//转发
			request.setAttribute("page",currentPage);
			request.getRequestDispatcher("Manager?target=upGround").forward(request,response);
			
		}
		//下架
		if("downGround".equals(ask)){
			//接收Id和当前页,通过id查询修改ground属性
			int currentPage = Integer.parseInt(request.getParameter("currentPage"));
			int id = Integer.parseInt(request.getParameter("id"));
			CategoryDAO dao = new DaoImple();
			Category category = dao.selectCategoryById(id);
			category.setGround(0);//下架
			//插入
			CategoryDAO dao1 = new DaoImple();
			dao1.updateCategory(category);//修改结束
			//转发
			request.setAttribute("page",currentPage);
			request.getRequestDispatcher("Manager?target=downGround").forward(request,response);
		}
	}
}
