package com.ecommerce.controller;

import com.ecommerce.service.*;

import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//This class logout the user from the session(Cart and Login)

public class LogoutController extends HttpServlet {

	private static final long serialVersionUID = 2562294252731783855L;

	UserService us = new UserService();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		HttpSession session = request.getSession();
		session.invalidate();

		String message = "You are successfully logged out!";
		response.sendRedirect("welcome?message=" + URLEncoder.encode(message, "UTF-8"));
	}
}
