package com.ecommerce.controller;

import com.ecommerce.dto.*;
import com.ecommerce.service.*;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//This class takes input from Login.jsp page and controls the flow based on validation with database

public class CartController extends HttpServlet {

	private static final long serialVersionUID = 2562294252731783855L;
	CartService cs = new CartService();

	// public static final String addToCart

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String strAction = request.getParameter("action");

		if (strAction != null && !strAction.equals("")) {
			if (strAction.equals("add")) {
				addToCart(request,response);
			} else if (strAction.equals("update")) {
				updateCart(request,response);
			} else if (strAction.equals("delete")) {
				deleteCart(request,response);
			}
		}
	}
	
	/*Method receives item code and call deleteCart sending item index*/
	protected void deleteCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		
		System.out.println("id = "+itemId);
		
		Cart cart = null;
		
		
		Object objCart = session.getAttribute("cart");
		if (objCart != null) {
			cart = (Cart) objCart;
		} else {
			cart = new Cart();
		}
		
		
		int itemIndex = cart.getItemIndex(itemId);
		System.out.println("Controller Index = "+itemIndex);
		cart.deleteCartItem(itemIndex);
		@SuppressWarnings("unchecked")
		ArrayList<Item> carts = cart.getCartItems();
		System.out.println("Cart size" + carts.size());
		if (!carts.isEmpty()) {
			request.setAttribute("cart", carts);
			//request.setAttribute("total", cart.getOrderTotal());
			request.getRequestDispatcher("checkout.jsp").forward(request, response);
		} else {
			String message = "Shopping cart is empty!";
			response.sendRedirect("search.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		}
	}

	protected void updateCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		HttpSession session = request.getSession();
		String strQuantity = request.getParameter("quantity");
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		System.out.println("Quantity="+strQuantity);

		Cart cart = null;

		Object objCart = session.getAttribute("cart");
		if (objCart != null) {
			cart = (Cart) objCart;
		} else {
			cart = new Cart();
		}
		int itemIndex = cart.getItemIndex(itemId);
		System.out.println("Item index="+itemIndex);
		cart.updateCartItem(itemIndex, strQuantity);
	}

	protected void addToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String strId = request.getParameter("product_id");
		String strName = request.getParameter("product_name");
		String strCode = request.getParameter("product_code");
		String strPrice = request.getParameter("product_price");
		String strQuantity = request.getParameter("product_quantity");
		
		System.out.println(strId+strName+strCode+strPrice+strQuantity);
		Cart cart = null;

		Object objCart = session.getAttribute("cart");

		if (objCart != null) {
			cart = (Cart) objCart;
		} else {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		cart.addCartItem(strId,strName, strCode, strPrice, strQuantity);
		//@SuppressWarnings("rawtypes")
		@SuppressWarnings("unchecked")
		ArrayList<Item> carts = cart.getCartItems();
		System.out.println("Cart size" + carts.size());
		if (!carts.isEmpty()) {
			request.setAttribute("cart", carts);
			//request.setAttribute("total", cart.getOrderTotal());
			request.getRequestDispatcher("checkout.jsp").forward(request, response);
		} else {
			String message = "Shopping cart is empty!";
			response.sendRedirect("checkout.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		}

	}

}

