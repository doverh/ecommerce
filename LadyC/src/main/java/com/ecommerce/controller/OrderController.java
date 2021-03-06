package com.ecommerce.controller;

import com.ecommerce.dao.ItemDao;
import com.ecommerce.dao.ItemDaoImpl;
import com.ecommerce.dao.OrderDao;
import com.ecommerce.dao.OrderDaoImpl;
import com.ecommerce.dto.Cart;
import com.ecommerce.dto.Item;
import com.ecommerce.dto.Order;
import com.ecommerce.dto.Product;
import com.ecommerce.service.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//This class takes input from Payment.jsp to create the order and stores items
public class OrderController extends HttpServlet {

	private static final long serialVersionUID = 2562294252731783855L;

	OrderService os = new OrderService();

	public void doPost(HttpServletRequest request, HttpServletResponse response, String userId, String orderTotal)
			throws ServletException, java.io.IOException {

		int user_id = Integer.parseInt(userId);
		double total = Double.parseDouble(orderTotal);
		//@SuppressWarnings("unchecked")
		HttpSession session = request.getSession();
		Object objCart = session.getAttribute("cart");
		
		System.out.println("Session"+session.getAttribute("cart"));
		Cart cartSh = null;
		if (objCart != null) {
			cartSh = (Cart) objCart;
		} else {
			cartSh = new Cart();
		}

		ArrayList<Product> carts = cartSh.getCartProducts();

		
		//ArrayList<Product> productList = (ArrayList<Product>)request.getAttribute("productList");
		
		try {
			// Insert new order and create new Order Number
			Order order = new Order();
			order.setAmount(total);
			order.setUser_id(user_id);
			String date = LocalDateTime.now().toString();
			//get just the date portion of the date time string
			order.setOrder_date(date.substring(0, 10));
			OrderDao Odao = new OrderDaoImpl();
			Order newOrder = Odao.registerOrder(order);
			
			ArrayList<Item> items = new ArrayList<Item>();  
			// Insert all items under the same order number
			for (Product p : carts) {
				Item item = new Item();
				item.setProduct_id(p.getProduct_id());
				item.setOrder_number(newOrder.getOrder_number());
				item.setPrice(p.getPrice());
				item.setQuantity(p.getQuantity());
				
				ItemDao iDao = new ItemDaoImpl();
				items.add(iDao.registerItem(item));
				System.out.println(item.getItem_id());
			}
				
			
			request.setAttribute("items", items);
			request.setAttribute("orderNum", newOrder.getOrder_number());
			request.setAttribute("total", total);
			request.getRequestDispatcher("payment_confirm.jsp").forward(request, response);
		}

		catch (IOException e) {

			e.printStackTrace();
		}

	}
}
