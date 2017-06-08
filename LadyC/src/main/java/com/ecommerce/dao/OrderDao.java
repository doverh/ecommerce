package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.dto.Item;
import com.ecommerce.dto.Order;


public interface OrderDao {
	
	Order registerOrder(Order order);	
	List<Item> searchItems(String order_number);
	
}
