package com.ecommerce.controller;

import com.ecommerce.dao.ItemDao;
import com.ecommerce.dao.ItemDaoImpl;
import com.ecommerce.dao.OrderDao;
import com.ecommerce.dao.OrderDaoImpl;
import com.ecommerce.dto.Item;
import com.ecommerce.dto.Order;
import com.ecommerce.service.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//This class takes input from Payment.jsp page and controls the flow based on validation with database

public class OrderController extends HttpServlet {

	private static final long serialVersionUID = 2562294252731783855L;

	OrderService os = new OrderService();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		int user_id = Integer.parseInt(request.getParameter("user_id"));
		double total = Double.parseDouble(request.getParameter("order_total"));
		//@SuppressWarnings("unchecked")
		System.out.println(request.getParameter("products").toString());

		try {
			// Insert new order and create new Order Number
			Order order = new Order();
			order.setAmount(total);
			order.setUser_id(user_id);
			OrderDao Odao = new OrderDaoImpl();
			Order newOrder = Odao.registerOrder(order);

			// Insert all itens under the same order number
//			for (Item item : items) {
//				//Item newItem;
//				int productId = item.getProduct_id();
//				item.setOrder_number(newOrder.getOrder_number());
//				//item.setPrice();
//				ItemDao iDao = new ItemDaoImpl();
//				iDao.registerItem(item, productId);
//
//			}
			
			request.setAttribute("orderNum", newOrder);
			request.setAttribute("total", total);
			request.getRequestDispatcher("payment_confirm.jsp").forward(request, response);
		}

		catch (IOException e) {

			e.printStackTrace();
		}

	}
}
