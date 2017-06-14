package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.dto.Product;

public interface ProductDao {
	
	List<Product> searchAll();	
	List<Product> searchProduct(String search);
	
}
