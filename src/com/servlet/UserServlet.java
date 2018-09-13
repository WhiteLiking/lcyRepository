package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connect.util.MailUtils;
import com.connect.util.UUIDUtils;
import com.page.PageInfo1;
import com.service.UserServiceImpl;
import com.service.inter.UserService;
import com.vo.User;

public class UserServlet  extends BaseServlet{
	public String userRegist(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
	     //���ղ���
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		String age =request.getParameter("age");
		String sex =request.getParameter("sex");
		String email =request.getParameter("email");
		String telephone =request.getParameter("telephone");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setAge(Integer.parseInt(age));
		user.setSex(sex);
		user.setEmail(email);
		user.setTelephone(telephone);
		System.out.println(user);
		//����ҵ���
		 UserService service=new UserServiceImpl();
		 user.setUserno(UUIDUtils.getId());
		 user.setState(0);
		 user.setCode(UUIDUtils.getCode());
		 try {
			 //ע��
			  service.userRegist(user);
			//ע��ɹ���ͨ�����䷢�ͼ����뷢�ͼ�����
			   System.out.println("sajdiajd");
			 MailUtils.sendMail(user.getEmail(), user.getCode());
			//ת��
			request.setAttribute("msg", "1");
			return "/WEB-INF/msg1.jsp";  
		} catch (Exception e) {
			request.setAttribute("msg","3");
			e.printStackTrace();
			return "/WEB-INF/msg1.jsp";  
		}
	}
	public String getUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("application/json");
		 String username =request.getParameter("username");
		 System.out.println(username);
	     UserService service=new UserServiceImpl();
	     User user= service.getUserByName(username);
	     System.out.println(user);
	    if(null==user.getUsername()){
	    	response.getWriter().print("11");
	    }else  {
	    	response.getWriter().print("22");
	    }
		return null;
	}
	public String registUI(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		return "/jsp/user/userregist.jsp";   
	}
	public String loginUI(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
	     return "/jsp/user/userlogin.jsp";  
	}
	public String active(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
	    //�������
		String code=request.getParameter("code");
	    //����ҵ���
		System.out.println(code);
		UserService userservice=new UserServiceImpl();
		 try {
			User user=userservice.userActive(code);
			 user.setState(1);
			 user.setCode(null);
			 UserService userservice2=new UserServiceImpl();
			 userservice2.updateUser(user);
			 request.setAttribute("msg", "����ɹ������¼");
				return "/jsp/user/userlogin.jsp";  
		} catch (Exception e) {
			request.setAttribute("msg", 2);
			e.printStackTrace();
			return "/WEB-INF/msg1.jsp";  
		}
	}
	public String logOut(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
	    //�ر�session�Ự
		request.getSession().removeAttribute("loginUser");
		//�ض�����ҳ
		response.sendRedirect("HeadMainPage");
		return null;  
	}
	//�û���¼
	public String userLogin(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
	    //������� 
		String username = request.getParameter("username");
	     String password = request.getParameter("password");
	     User user = new User();
	     user.setUsername(username);
	     user.setPassword(password);
	     //����ҵ���߼�
	    UserService service=  new UserServiceImpl();
	    User user1=new User();
	         try {
	        	 user1=service.userLogin(user);
	        	 System.out.println(user1);
	        	 request.getSession().setAttribute("loginUser", user1);
	        	 response.sendRedirect("HeadMainPage");
	        	 return null;  
			} catch (SQLException e) {
				//���벻��ȷ��ת����¼ҳ��
				 request.setAttribute("msg2",e.getMessage());
				 e.printStackTrace();
				return "/jsp/user/userlogin.jsp";  
			}
	         catch (RuntimeException e) {
					//���벻��ȷ��ת����¼ҳ��
					 request.setAttribute("msg1",e.getMessage());
					 e.printStackTrace();
					return "/jsp/user/userlogin.jsp";  
			} catch (Exception e) {
				//���벻��ȷ��ת����¼ҳ��
				 System.out.println("����ִ������쳣");
				 e.printStackTrace();
				  
				 return null;
		}
	}
	public String lookUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
	    //�������
		String target=request.getParameter("target");
		System.out.println(target);
		String requestPage=request.getParameter("requestPage");
		if(requestPage==null){
			requestPage="1";
		}
		
		UserService service = new UserServiceImpl();
		try {
			//���������Ҽ�¼
			int toTotalRecordSum = service.getTotalRecordSum();
			PageInfo1 pageInfo1 = new PageInfo1(Integer.parseInt(requestPage));
			pageInfo1.setTotalRecordCount(toTotalRecordSum);
		   //��ѯ����Category
			UserService service1 = new UserServiceImpl();
			List<User> list = service1.getPageQuery(pageInfo1);
			request.setAttribute("list", list);
			request.setAttribute("pageInfo1", pageInfo1);
			return "/WEB-INF/jsp/user/"+target+".jsp";
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			e.printStackTrace();
			return "/WEB-INF/msg.jsp";
		}		 
	}
	
	public String getPageByQuery(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String target=request.getParameter("target");
		System.out.println(target);
		String searchCondition =request.getParameter("searchCondition");
		System.out.println(searchCondition);
		String requestPage=request.getParameter("requestPage");
		System.out.println(requestPage);
		if(requestPage==null){
			requestPage="1";
		}
		User user=new User();
		System.out.println(user);
		UserService service = new UserServiceImpl();
			if(searchCondition!=null&&!searchCondition.trim().equals("")){
				
				if("�Ѽ���".equals(searchCondition)){
					user.setState(1);
				}else if("δ����".equals(searchCondition)){				
					user.setState(0);
				}else{
					user.setUsername(searchCondition);
				}
			}
			try {
			//���������Ҽ�¼
			int toTotalRecordSum=service.getTotalRecordSum(user);
			PageInfo1 pageInfo1 = new PageInfo1(Integer.parseInt(requestPage));
			pageInfo1.setTotalRecordCount(toTotalRecordSum);
		   //��ѯ����Category
			UserService service1 = new UserServiceImpl();
			List<User> list = service1.getPageQuery(user, pageInfo1);
			request.setAttribute("list", list);
			request.setAttribute("pageInfo1", pageInfo1);
			request.setAttribute("searchCondition", searchCondition);
			request.setAttribute("target", target);
			return "/WEB-INF/jsp/user/"+target+".jsp";
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			e.printStackTrace();
			return "/WEB-INF/msg.jsp";
		} 
	}
	public String deleteUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String target=request.getParameter("target");
		System.out.println(target);
		String searchCondition =request.getParameter("searchCondition");
		System.out.println(searchCondition);
		String requestPage=request.getParameter("requestPage");
		System.out.println(requestPage);
		String userno=request.getParameter("userno");
		System.out.println(userno);
		UserService service=new UserServiceImpl();
		 try {
			service.deleteUser(userno);
			request.setAttribute("target", target);
			request.setAttribute("requestPage", requestPage);
			request.setAttribute("searchCondition", searchCondition);
			this.getPageByQuery(request, response);
			return "/WEB-INF/jsp/user/"+target+".jsp";
		 } catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			e.printStackTrace();
			return "/WEB-INF/msg.jsp";
		 }  
	}
	public String getOneForUpdate(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
	      String userno=request.getParameter("userno");
	      System.out.println(userno);
	      String target=request.getParameter("target");
			 System.out.println(target);
			String searchCondition =request.getParameter("searchCondition");
			 System.out.println(searchCondition);
			String requestPage = request.getParameter("requestPage");
			System.out.println(requestPage);
	          User user=new User();
	      UserService service=new UserServiceImpl();
	      try {
			user= service.getUserById(userno);
			request.setAttribute("target", target);
			request.setAttribute("requestPage", requestPage);
			request.setAttribute("searchCondition", searchCondition);
			request.setAttribute("user", user);
			return "/WEB-INF/jsp/user/update.jsp";
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			e.printStackTrace();
			return "/WEB-INF/msg.jsp"; 
		}
	}
	public String updateUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String target=request.getParameter("target");
		System.out.println(target);
		String searchCondition =request.getParameter("searchCondition");
		System.out.println(searchCondition);
		String requestPage=request.getParameter("requestPage");
		System.out.println(requestPage);
		String userno =request.getParameter("userno");
		System.out.println(userno);
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		String age =request.getParameter("age");
		String sex =request.getParameter("sex");
		String email =request.getParameter("email");
		String telephone =request.getParameter("telephone");
		User user = new User();
		user.setUserno(userno);
		user.setUsername(username);
		user.setPassword(password);
		user.setAge(Integer.parseInt(age));
		user.setSex(sex);
		user.setEmail(email);
		user.setTelephone(telephone);
		System.out.println(user);
	    try {
	    	  UserService servive=new UserServiceImpl();
	    	    servive.update(user);
	    	    request.setAttribute("target", target);
				request.setAttribute("requestPage", requestPage);
				request.setAttribute("searchCondition", searchCondition);
				this.getPageByQuery(request, response);
				return "/WEB-INF/jsp/user/updateUser.jsp";
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			e.printStackTrace();
			return "/WEB-INF/msg.jsp"; 
		}
	}
}
