package com.ecommerce.controller.copy;

import com.ecommerce.dto.*;
import com.ecommerce.exception.ApplicationException;
import com.ecommerce.service.*;

import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//This class takes input from Login.jsp page and controls the flow based on validation with database

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

			// Create Http session
			if (userObject != null) {
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", userObject);
				response.sendRedirect("userLogged.jsp"); // logged-in page
			}

			else {
				String message = "Invalid credentials!";
				response.sendRedirect("login.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
			// response.sendRedirect("invalid_login.jsp"); //error page
		} catch (ApplicationException e) {
			System.out.println(e);
			response.sendRedirect("invalid_login.jsp");
		}

	}
}
