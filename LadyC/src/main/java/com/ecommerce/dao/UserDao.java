package com.ecommerce.dao;

import com.ecommerce.dto.User;

public interface UserDao {
	
	boolean register(User user);
	User validateUser(String userEmail, String password);
}
