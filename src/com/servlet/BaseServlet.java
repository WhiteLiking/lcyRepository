package com.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BaseServlet extends HttpServlet{
	 public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		     // 获取cation的值
		 	request.setCharacterEncoding("utf-8");
			response.setContentType("text/html,charSet=utf-8");
		     String meth=request.getParameter("action");
		     // 定义地址
		     String path=null;
		    //地址中的对象
		     Class clazz=this.getClass();
		  try {
			Method method= clazz.getMethod(meth, HttpServletRequest.class,HttpServletResponse.class);
			if(null!=method){
				path=(String)method.invoke(this, request,response);
			}
			if(null!=path){
				request.getRequestDispatcher(path).forward(request, response);
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
		     
	 }
	 public String cha(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
						
			return "/WEB-INF/jsp/admin/category/addCategory.jsp";
		}
}
