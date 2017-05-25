package com.ecommerce.authentication.dao;

import com.ecommerce.authentication.dto.User;
import com.ecommerce.authentication.exception.ApplicationException;

public interface UserDao {
	
	boolean register(User user);
	User validateUser(String userEmail, String password);
}
