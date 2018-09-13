package com.service.inter;

import java.sql.SQLException;
import java.util.List;

import com.page.PageInfo;
import com.page.PageInfo1;
import com.vo.User;

public interface UserService {
	
	User findUserByUsreName(String um)throws SQLException;

	void userRegist(User user)throws Exception;

	User userActive(String code)throws Exception;

	void updateUser(User user01)throws Exception;

	User userLogin(User user) throws Exception;

	User getUserByName(String username);

	int getTotalRecordSum()throws Exception;

	List<User> getPageQuery(PageInfo1 pageInfo1)throws Exception;

	int getTotalRecordSum(User user) throws Exception;

	List<User> getPageQuery(User user, PageInfo1 pageInfo1)throws Exception;

	void deleteUser(String userno)throws Exception;

	User getUserById(String userno)throws Exception;

	void update(User user)throws Exception;
}
