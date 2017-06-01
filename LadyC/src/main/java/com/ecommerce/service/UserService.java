package com.ecommerce.service;

import com.ecommerce.dao.UserDao;
import com.ecommerce.dao.UserDaoImpl;
import com.ecommerce.dto.User;
import com.ecommerce.exception.ApplicationException;

public class UserService {

	UserDao udao = new UserDaoImpl();

	public User authenticateUser(String userEmail, String password) throws ApplicationException {
		return udao.validateUser(userEmail, password);
	}

}
