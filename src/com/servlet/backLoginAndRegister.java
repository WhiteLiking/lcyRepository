package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.imple.ManagerDaoImple;
import com.vo.Manager;

public class backLoginAndRegister extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charSet=utf-8");
		String target = request.getParameter("target");
	
		//后台注册
		if("register".equals(target)){
			//PrintWriter out = response.getWriter();
			String acount = request.getParameter("uname");
			String passward = request.getParameter("upassward");
			ManagerDaoImple maDao = new ManagerDaoImple();
			List<Manager> listManager = maDao.selectManagerBySQL("select * from manager");
			if(acount.equals("")||acount==null||passward.equals("")||passward==null){
				Manager promt = new Manager();
				promt.setCname("账号或密码不能为空！");
				request.setAttribute("promt",promt);
				request.getRequestDispatcher("jsp/backUser/backRegister.jsp").forward(request,response);
			}else{
				boolean flag = true;
				for(int i=0;i<listManager.size();i++){
					if(listManager.get(i).getCname().equals(acount)){
						flag = false;
						Manager promt = new Manager();
						promt.setCname("此账号已被注册！");
						request.setAttribute("promt",promt);
						request.getRequestDispatcher("jsp/backUser/backRegister.jsp").forward(request,response);
					}
				}
				if(flag==true){
					Manager manager = new Manager();
					manager.setCname(acount);
					manager.setCpassword(passward);
					ManagerDaoImple dao = new ManagerDaoImple();
					dao.addManager(manager);
					
					Manager promt = new Manager();
					promt.setCname("注册成功！");
					request.setAttribute("promt",promt);
					request.getRequestDispatcher("jsp/backUser/backRegister.jsp").forward(request,response);
				}
			}
		}
		
		
		//后台登录
		if("login".equals(target)){
			String acount = request.getParameter("uname");
			String passward = request.getParameter("upassward");
			System.out.println(acount+passward);
			ManagerDaoImple maDao = new ManagerDaoImple();
			List<Manager> listManager = maDao.selectManagerBySQL("select * from manager");
			boolean flag=false;
			String cname = "";
			String cpassword = "";
			for(int i=0;i<listManager.size();i++){
				cname = listManager.get(i).getCname();
				cpassword = listManager.get(i).getCpassword();
			if(cname.equals(acount)&&cpassword.equals(passward)){
				request.getRequestDispatcher("jsp/back/backMainPage.jsp").forward(request,response);
				flag=true;
				}
			}
			if(flag==false){
				Manager manager = new Manager();
				manager.setCname("");
				request.setAttribute("promt",manager);
				
				request.getRequestDispatcher("jsp/backUser/backLogin.jsp").forward(request,response);
			}
		}
	}
	
}
