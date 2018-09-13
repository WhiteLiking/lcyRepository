package com.Test;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class TestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charSet=utf-8");
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
				String name = null;
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
						if(fileName.equals("uname")){
							
							name = iterm.getString("utf-8");
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
				Test test = new Test();
				test.setName(name);
				test.setPs(fName);
				
				TestImple im = new TestImple();
				im.add(test);
				
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	}
	
	
	
	

}
