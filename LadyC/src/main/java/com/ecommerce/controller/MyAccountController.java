package com.ecommerce.controller;

import com.ecommerce.dao.ItemDao;
import com.ecommerce.dao.ItemDaoImpl;
import com.ecommerce.dao.MyAccountDao;
import com.ecommerce.dao.MyAccountDaoImpl;
import com.ecommerce.dao.OrderDao;
import com.ecommerce.dao.OrderDaoImpl;
import com.ecommerce.dto.Cart;
import com.ecommerce.dto.Item;
import com.ecommerce.dto.Order;
import com.ecommerce.dto.Product;
import com.ecommerce.dto.User;
import com.ecommerce.service.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//This class takes input from Payment.jsp page and controls the flow based on validation with database

public class MyAccountController extends HttpServlet {

	private static final long serialVersionUID = 2562294252731783855L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		// Check user logged
		HttpSession session = request.getSession();
		Object objUser = session.getAttribute("user_id");

		// If there is a user ID
		if (objUser != null) {
			User user = (User) objUser;
		
			// Select all orders with given user ID
			MyAccountDao myA = new MyAccountDaoImpl();
			List orderList = myA.searchOrderbyUser(user.getId());

			if (!orderList.isEmpty()) {
				request.setAttribute("orders", orderList);
				request.getRequestDispatcher("myAccount.jsp").forward(request, response);
			} else {
				String message = "You haven't place an order yet!";
				response.sendRedirect("myAccount.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
			
		//If user not logged in send for login page	
		} else {

			String message = "You should login first!";

			response.sendRedirect("login.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

		}
	}
}