package com.ecommerce.controller;

import com.ecommerce.dto.*;
import com.ecommerce.exception.ApplicationException;
import com.ecommerce.service.*;

import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//This class takes input from Login.jsp page and authenticate user in the system
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 2562294252731783855L;

	UserService us = new UserService();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
		User userObject = null;
		try {
			userObject = us.authenticateUser(username, password);
			int userId = userObject.getId();
			HttpSession session = request.getSession();
			Object logged = session.getAttribute("login");
			Cart cart = null;
			Object objCart = session.getAttribute("cart");
			if (objCart != null) {
				cart = (Cart) objCart;
			} else {
				cart = new Cart();
			}

			ArrayList<Product> carts = cart.getCartProducts();

			String greetings = "Welcome"+userObject.getFirstname()+"!";
			
				if (userObject != null & !carts.isEmpty()) {
					// Create Http session
					session.setAttribute("login", "logged");
					session.setAttribute("currentSessionUser", greetings );
					session.setAttribute("user_id",userId);
					request.setAttribute("products", carts);
					request.setAttribute("total", cart.getOrderTotal());
					request.getRequestDispatcher("payment.jsp").forward(request, response);
				} else if (userObject != null & carts.isEmpty()){
					// Create Http session
					session.setAttribute("login", "logged");
					session.setAttribute("user_id",userId);
					request.setAttribute("currentSessionUser", greetings);
					request.setAttribute("message", "Your cart is empty!");
					request.getRequestDispatcher("search.jsp").forward(request, response);
				} else {
					String message = "Invalid credentials!";
					
					response.sendRedirect("login.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
				}
			// response.sendRedirect("invalid_login.jsp"); //error page
		} catch (ApplicationException e) {
			System.out.println(e);
			response.sendRedirect("index.html");
		}

	}
}
