package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.dto.Item;


public interface MyAccountDao {
	
	
	List<Object[]> searchOrderbyUser(int userid);
	
}
