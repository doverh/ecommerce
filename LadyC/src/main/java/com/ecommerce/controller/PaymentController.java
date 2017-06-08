package com.ecommerce.controller;


import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.dto.Cart;
import com.ecommerce.dto.Item;

//This class takes input from Login.jsp page and controls the flow based on validation with database

public class PaymentController extends HttpServlet {

	private static final long serialVersionUID = 2562294252731783855L;

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		
		String total = request.getParameter("orderTotal");
		HttpSession session = request.getSession();
		Object objCart = session.getAttribute("cart");
		
		// Create Http session
		if (objCart != null ) {
			response.sendRedirect("payment.jsp?total=" + URLEncoder.encode(total, "UTF-8"));
		}else{
				response.sendRedirect("login.jsp");
		}
	}
}
