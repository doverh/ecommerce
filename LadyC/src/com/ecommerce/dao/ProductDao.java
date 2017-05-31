package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.dto.Product;
import com.ecommerce.exception.ApplicationException;

public interface ProductDao {
	
		
	List<Product> searchProduct(String search);
	
}
