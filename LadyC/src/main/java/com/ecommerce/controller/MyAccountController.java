package com.ecommerce.controller;

import com.ecommerce.dao.MyAccountDao;
import com.ecommerce.dao.MyAccountDaoImpl;
import com.ecommerce.dto.Item;
import com.ecommerce.dto.User;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//This class present to the user orders that he sent

public class MyAccountController extends HttpServlet {

	private static final long serialVersionUID = 2562294252731783855L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		// Check user logged
		HttpSession session = request.getSession();
		Object objUser = session.getAttribute("user_id");

		// If there is a user ID
		if (objUser != null) {
			System.out.println("User id"+Integer.parseInt(objUser.toString()));
			// Select all orders with given user ID
			MyAccountDao myA = new MyAccountDaoImpl();
			List<Object[]> orderList = myA.searchOrderbyUser(Integer.parseInt(objUser.toString()));
			
			for (Object[] result: orderList){
				System.out.println("Item: "+result[0]);
				System.out.println("Item: "+result[1]);
				System.out.println("Item: "+result[2]);
				System.out.println("Item: "+result[3]);
				System.out.println("Item: "+result[4]);
				
			}
			
			
			if (!orderList.isEmpty()) {
				request.setAttribute("orders", orderList);
				request.getRequestDispatcher("views/myaccount.jsp").forward(request, response);
			} else {
				String message = "You haven't place an order yet!";
				response.sendRedirect("views/myaccount.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
			
		//If user not logged in send for login page	
		} else {

			String message = "You should login first!";

			response.sendRedirect("views/login.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

		}
	}
}