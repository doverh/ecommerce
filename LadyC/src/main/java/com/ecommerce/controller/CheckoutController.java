package com.ecommerce.controller;


import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.dto.*;

//This class takes input from Login.jsp page and controls the flow based on validation with database

public class CheckoutController extends HttpServlet {

	private static final long serialVersionUID = 2562294252731783855L;

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		
		String total = request.getParameter("orderTotal");
		HttpSession session = request.getSession();
		Object logged = session.getAttribute("login");
		Object objCart = session.getAttribute("cart");
		
				System.out.println("Session"+session.getAttribute("cart"));
		Cart cartSh = null;
		if (objCart != null) {
			cartSh = (Cart) objCart;
		} else {
			cartSh = new Cart();
		}

		ArrayList<Product> carts = cartSh.getCartProducts();

		System.out.println("Session loggeds"+logged);
		// Create Http session
		if (objCart != null & logged != null) {
			request.setAttribute("products", carts);
			request.setAttribute("total", cartSh.getOrderTotal());
			request.getRequestDispatcher("payment.jsp").forward(request, response);
				}else{
				response.sendRedirect("login.jsp");
		}
	}
}
