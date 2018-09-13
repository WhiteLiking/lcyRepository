package com.Test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestPs extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TestImple tt = new TestImple();
		Test te = tt.selectTestById("binbin");
		String path = te.getPs();
		String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/");
		Object[] src = deleteSubString(path,uploadFilePath);
		path = "upload/"+src[0].toString();
		request.setAttribute("path",path);
		request.getRequestDispatcher("testPs.jsp").forward(request,response);
	}

	
		// TODO Auto-generated method stub
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
				//²»´æÔÚ·µ»Ø-1
				obj[0] = -1;
				obj[1] = -1;
			}
			
			return obj;
		}
		
	}
	

