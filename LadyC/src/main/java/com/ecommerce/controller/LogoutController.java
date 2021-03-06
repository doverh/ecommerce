package com.ecommerce.controller;

import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//This class logout the user from the session(Cart and Login)

public class LogoutController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		HttpSession session = request.getSession();
		session.invalidate();

		String message = "You are successfully logged out!";
		response.sendRedirect("login.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
	}
}
