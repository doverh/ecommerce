package com.ecommerce.controller;

import com.ecommerce.dto.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//This class add, delete or update products from the shopping cart

public class CartController extends HttpServlet {

	private static final long serialVersionUID = 2562294252731783855L;

	public void doPost(HttpServletRequest request, HttpServletResponse response,String strAction,String strProductId,String strQuantity) throws ServletException, IOException {

		if (strAction != null && !strAction.equals("")) {
			if (strAction.equals("add")) {
				addToCart(request, response);
			} else if (strAction.equals("update")) {
				updateCart(request, response,strProductId,strQuantity);
			} else if (strAction.equals("delete")) {
				deleteCart(request, response,strProductId);
			}
		} else {
			HttpSession session = request.getSession();
			Cart cart = null;

			Object objCart = session.getAttribute("cart");
			if (objCart != null) {
				cart = (Cart) objCart;
			} else {
				cart = new Cart();
			}

			ArrayList<Product> carts = cart.getCartProducts();

			if (!carts.isEmpty()) {
				request.setAttribute("products", carts);
				request.setAttribute("total", cart.getOrderTotal());
				request.getRequestDispatcher("views/geshoppingcart.jsp").forward(request, response);
			} else {
				String message = "Shopping cart is empty!";
				response.sendRedirect("views/search.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}

		}
	}

	/* Method receives item code and call deleteCart sending item index */
	protected void deleteCart(HttpServletRequest request, HttpServletResponse response, String strProductId)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
	
		Cart cart = null;

		Object objCart = session.getAttribute("cart");
		if (objCart != null) {
			cart = (Cart) objCart;
		} else {
			cart = new Cart();
		}

		int productId = Integer.parseInt(strProductId);
		int productIndex = cart.getProductIndex(productId);
		System.out.println("Controller Index = " + productIndex);
		cart.deleteCartProduct(productIndex);
		ArrayList<Product> carts = cart.getCartProducts();
		System.out.println("Cart size" + carts.size());
		if (!carts.isEmpty()) {
			request.setAttribute("products", carts);
			request.setAttribute("total", cart.getOrderTotal());
			request.getRequestDispatcher("/views/shoppingcart.jsp").forward(request, response);
		} else {
			String message = "Shopping cart is empty!";
			response.sendRedirect("/views/search.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		}
	}

	protected void updateCart(HttpServletRequest request, HttpServletResponse response,String strProductId, String strQuantity)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		//System.out.println("Quantity=" + iQuantity);

		Cart cart = (Cart) session.getAttribute("cart");

		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		int productId = Integer.parseInt(strProductId);
		int iQuantity = Integer.parseInt(strQuantity);
		int productIndex = cart.getProductIndex(productId);
		// System.out.println("Item index=" + itemIndex);
		cart.updateCartProduct(productIndex, iQuantity);

		ArrayList<Product> carts = cart.getCartProducts();
		if (!carts.isEmpty()) {
			request.setAttribute("products", carts);
			request.setAttribute("total", cart.getOrderTotal());
			request.getRequestDispatcher("/views/shoppingcart.jsp").forward(request, response);
		} else {
			String message = "Shopping cart is empty!";
			response.sendRedirect("/views/shoppingcart.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		}

	}

	protected void addToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String strId = request.getParameter("product_id");
		String strName = request.getParameter("product_name");
		String strCode = request.getParameter("product_code");
		String strPrice = request.getParameter("product_price");
		String strQuantity = request.getParameter("product_quantity");

		System.out.println(strId + strName + strCode + strPrice + strQuantity);
		Cart cart = (Cart) session.getAttribute("cart");

		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		cart.addCartProduct(strId, strName, strCode, strPrice, strQuantity);
		ArrayList<Product> carts = cart.getCartProducts();
		System.out.println("Cart size" + carts.size());
		if (!carts.isEmpty()) {
			request.setAttribute("products", carts);
			request.setAttribute("total", cart.getOrderTotal());
			request.getRequestDispatcher("/views/shoppingcart.jsp").forward(request, response);
		} else {
			String message = "Shopping cart is empty!";
			response.sendRedirect("/views/checkout.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		}

	}

}
