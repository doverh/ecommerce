package com.ecommerce.service;
import java.util.List;
import com.ecommerce.dao.OrderDao;
import com.ecommerce.dao.OrderDaoImpl;
import com.ecommerce.dto.Item;
import com.ecommerce.exception.ApplicationException;

public class  OrderService {

	OrderDao odao = new OrderDaoImpl();

	public List<Item> searchforItems(String order_number) throws ApplicationException {
		return odao.searchItems(order_number);
	}

}

