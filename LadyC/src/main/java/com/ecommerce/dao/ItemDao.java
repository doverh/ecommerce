package com.ecommerce.dao;

import com.ecommerce.dto.Item;



public interface ItemDao {
	
	boolean registerItem(Item item, int product_id);	
	
}
