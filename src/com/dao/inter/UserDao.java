package com.dao.inter;

import java.sql.SQLException;
import java.util.List;

import com.vo.Category;
import com.vo.User;

public interface UserDao {
	 public User findUserByUsreName(String um) throws SQLException;

	 public void userRegist(User user01)throws Exception;

	public User userActive(String code)throws Exception;

	 public void updateUser(User user)throws Exception;

	 public User userLogin(User user)throws SQLException;

	public User fandUserByName(String username);

	public int getTotalRecordSum(String sql) throws Exception;

	public List<User> getPageQuer(String sql)throws Exception;

	public List<User> getPageByQuery(String sql) throws Exception;

	public void deleteUser(String sql) throws Exception;

	public User getUserById(String userno) throws Exception;

	public void update(User user) throws Exception;
}
