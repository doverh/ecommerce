package com.ecommerce.dao;

import com.ecommerce.dto.User;
import com.ecommerce.exception.ApplicationException;

public interface UserDao {
	
	boolean register(User user);
	User validateUser(String userEmail, String password);
}
