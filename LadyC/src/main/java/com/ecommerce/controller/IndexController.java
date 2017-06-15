package com.ecommerce.controller;

import com.ecommerce.dto.*;
import com.ecommerce.exception.ApplicationException;
import com.ecommerce.service.*;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//This class takes input from Login.jsp page and promote a search for existing products in the database
public class IndexController extends HttpServlet {

	private static final long serialVersionUID = 2562294252731783855L;

	ProductService ps = new ProductService();

	//This method shows all products in the index page
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		try {

			List<Product> productList = ps.searchAllProducts();
			System.out.println("Index list"+productList.toString());
			if (!productList.isEmpty()) {
				request.setAttribute("products", productList);
				request.getRequestDispatcher("/views/index.jsp").forward(request, response);
			} else {
				String message = "No products found!";
				response.sendRedirect("index.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}
		} catch (ApplicationException e) {
			System.out.println(e);
			response.sendRedirect("index.jsp");

		}
	}
}
