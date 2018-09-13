package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.imple.UserDaoImpl;
import com.dao.inter.UserDao;
import com.page.PageInfo1;
import com.service.inter.UserService;
import com.vo.User;



public class UserServiceImpl implements UserService {
       private  UserDao dao;
	public UserServiceImpl() {
		dao=new UserDaoImpl();
	}

	@Override
	public User userLogin(User user) throws Exception {
		   //调用dao层执行查找   sql="select * from user_table where username=? and password"
		User user1 =new User();
		 try {
			user1= dao.userLogin(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("查看激活状态:"+user1.getUsername());
		 if(user1.getUsername()==null){
			throw new SQLException("密码错误！");
		 }else{	
			if(user1.getState()==0){
			throw new RuntimeException("用户未激活");
			}else{
			return user1;
			}
		}
	}
	
	@Override
	public User findUserByUsreName(String um) throws SQLException{

		return null;
		
	}

	@Override
	//注册
	public void userRegist(User user) throws Exception{
		   dao.userRegist(user);			  
	}

	@Override
	//连接根据code查
	public User userActive(String code) throws Exception {
		//调用dao层的方法  sql="select * from user_table where code=?"
		 User user=dao.userActive(code);
		 
		return user;
	}

	@Override
	//更新
	public void updateUser(User user) throws Exception {
		   dao.updateUser(user);
	}

	@Override
	public User getUserByName(String username) {
		 User user=dao.fandUserByName(username);
		return user;
	}

	@Override
	public int getTotalRecordSum() throws Exception {
		String sql="select count(*) from user_table";
		int totalRecordSum=dao.getTotalRecordSum(sql);
		
		return totalRecordSum;
	}

	@Override
	public List<User> getPageQuery(PageInfo1 pageInfo1) throws Exception {
		List<User> list=null;
		String sql="select * from (select c.*,rownum r from user_table c) where r>="+pageInfo1.getBegin()+" and r<="+pageInfo1.getEnd();
		list=dao.getPageQuer(sql);
		return list;
	}

	@Override
	public int getTotalRecordSum(User user) throws Exception {
		 int  toTotalRecordSum =-1;
			StringBuffer sb=new StringBuffer("select count(*) from user_table where 1=1");
			String username=user.getUsername();
			Integer state=user.getState();
			if(username!=null&&!username.trim().equals("")){
				sb.append(" and username like '%");
				sb.append(username);
				sb.append("%'");
			}
			String sql=sb.toString();
			System.out.println(sql);
			toTotalRecordSum=dao.getTotalRecordSum(sql);
			return toTotalRecordSum;
	}

	@Override
	public List<User> getPageQuery(User user, PageInfo1 pageInfo1) throws Exception {
		List<User> list=null;
		 StringBuffer sb=new StringBuffer("select * from (select c.*,rownum r from user_table c where 1=1");		 
		 String username=user.getUsername();
		 Integer state=user.getState();
		 if(username!=null&&!username.trim().equals("")){
			 sb.append(" and username like '%");
			 sb.append(username);
			 sb.append("%'");
		 }		
		 sb.append(") where r>=");
		 sb.append(pageInfo1.getBegin());
		 sb.append("and r<=");
		 sb.append(pageInfo1.getEnd());
		 String sql=sb.toString();
		 System.out.println(sql);
		 list=dao.getPageByQuery(sql);
		return list;
	}

	@Override
	public void deleteUser(String userno) throws Exception {
		dao.deleteUser(userno);
	}

	@Override
	public User getUserById(String userno) throws Exception {
		  User user=dao.getUserById(userno);
		return user;
	}

	@Override
	public void update(User user) throws Exception {
		dao.update(user);
		
	}

}
