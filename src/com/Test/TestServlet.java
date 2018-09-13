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
				String name = null;
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
						if(fileName.equals("uname")){
							
							name = iterm.getString("utf-8");
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
