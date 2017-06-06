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



//This class takes input from Login.jsp page and controls the flow based on validation with database

public class OrderController extends HttpServlet {

private static final long serialVersionUID = 2562294252731783855L;

OrderService os = new OrderService();

public void doPost(HttpServletRequest request, HttpServletResponse response) 
                    throws ServletException, java.io.IOException {

//	    String name = request.getParameter("product_name");
//	    String code = request.getParameter("product_code");
//	    String image = request.getParameter("product_image");
//	    String price = request.getParameter("product_price");
//	    
//		try{
//			
//			List<Product> productList = ps.searchbyProduct(search);
//			//iterate in a list to show products
//			//Create Http session    
//			System.out.println(productList.toString());
//			if (!productList.isEmpty()){     
//			 request.setAttribute("products", productList); 
//			 request.getRequestDispatcher("search.jsp").forward(request, response);
//			}else{
//				String message = "No products found!";
//				response.sendRedirect("search.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
//			} 
//			//response.sendRedirect("invalid_login.jsp"); //error page 
//		}catch (ApplicationException e){
//			System.out.println(e); 
//			response.sendRedirect("search.jsp");
//			
//		}
//  	}
}
}
