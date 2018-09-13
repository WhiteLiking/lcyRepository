package com.Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestAjaxServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置发送到客户端的响应内容类型
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String moble = request.getParameter("moble");
		System.out.println(moble);
		if("18209583352".equals(moble)){
			out.print("true");
		}else{
			out.print("false");
		}
	}
	

}
