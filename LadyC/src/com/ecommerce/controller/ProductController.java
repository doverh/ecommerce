package com.ecommerce.controller;
import com.ecommerce.dao.*;
import com.ecommerce.dto.*;
import com.ecommerce.exception.ApplicationException;
import com.ecommerce.service.*;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//This class takes input from Login.jsp page and controls the flow based on validation with database

public class ProductController extends HttpServlet {

private static final long serialVersionUID = 2562294252731783855L;

ProductService ps = new ProductService();

public void doPost(HttpServletRequest request, HttpServletResponse response) 
                    throws ServletException, java.io.IOException {

	    System.out.println("====================================");
		System.out.println(request.getContextPath());
		String search = request.getParameter("search");
		try{
			
			List<Product> productList = ps.searchbyProduct(search);
			//iterate in a list to show products
			//Create Http session         
			if (productList != null){     
			 request.setAttribute("products", productList); 
			 request.getRequestDispatcher("search.jsp").forward(request, response);
			}
           
		else{
			String message = "No products found!";
			response.sendRedirect("search.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		} 
			//response.sendRedirect("invalid_login.jsp"); //error page 
		}catch (ApplicationException e){
			System.out.println(e); 
			response.sendRedirect("invalid_login.jsp");
		}
		
  }
}