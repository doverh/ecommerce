package com.ecommerce.authentication.service;

import com.ecommerce.authentication.*;
import com.ecommerce.authentication.dao.UserDaoImpl;
import com.ecommerce.authentication.dao.UserDao;
import com.ecommerce.authentication.dto.User;
import com.ecommerce.authentication.exception.ApplicationException;


public class UserService {
	
	UserDao udao = new UserDaoImpl();
	
	public User authenticateUser(String userEmail, String password) throws ApplicationException {
		return udao.validateUser(userEmail, password);
	}

}
