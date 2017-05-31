package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.dao.ProductDaoImpl;
import com.ecommerce.dto.Product;
import com.ecommerce.exception.ApplicationException;



public class ProductService {
	
	ProductDao pdao = new ProductDaoImpl();
	
	public List<Product> searchbyProduct(String search) throws ApplicationException {
		return pdao.searchProduct(search);
	}

}

