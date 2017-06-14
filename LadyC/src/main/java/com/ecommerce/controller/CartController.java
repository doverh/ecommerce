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

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String strAction = request.getParameter("action");

		if (strAction != null && !strAction.equals("")) {
			if (strAction.equals("add")) {
				addToCart(request, response);
			} else if (strAction.equals("update")) {
				updateCart(request, response);
			} else if (strAction.equals("delete")) {
				deleteCart(request, response);
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
				request.getRequestDispatcher("shoppingcart.jsp").forward(request, response);
			} else {
				String message = "Shopping cart is empty!";
				response.sendRedirect("search.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			}

		}
	}

	/* Method receives item code and call deleteCart sending item index */
	protected void deleteCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int productId = Integer.parseInt(request.getParameter("productId"));

		System.out.println("id = " + productId);

		Cart cart = null;

		Object objCart = session.getAttribute("cart");
		if (objCart != null) {
			cart = (Cart) objCart;
		} else {
			cart = new Cart();
		}

		int productIndex = cart.getProductIndex(productId);
		System.out.println("Controller Index = " + productIndex);
		cart.deleteCartProduct(productIndex);
		@SuppressWarnings("unchecked")
		ArrayList<Product> carts = cart.getCartProducts();
		System.out.println("Cart size" + carts.size());
		if (!carts.isEmpty()) {
			request.setAttribute("products", carts);
			request.setAttribute("total", cart.getOrderTotal());
			request.getRequestDispatcher("shoppingcart.jsp").forward(request, response);
		} else {
			String message = "Shopping cart is empty!";
			response.sendRedirect("search.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		}
	}

	protected void updateCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String strQuantity = request.getParameter("quantity");
		int productId = Integer.parseInt(request.getParameter("productId"));
		System.out.println("Quantity=" + strQuantity);

		Cart cart = (Cart) session.getAttribute("cart");

		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		int productIndex = cart.getProductIndex(productId);
		// System.out.println("Item index=" + itemIndex);
		cart.updateCartProduct(productIndex, strQuantity);

		ArrayList<Product> carts = cart.getCartProducts();
		if (!carts.isEmpty()) {
			request.setAttribute("products", carts);
			request.setAttribute("total", cart.getOrderTotal());
			request.getRequestDispatcher("shoppingcart.jsp").forward(request, response);
		} else {
			String message = "Shopping cart is empty!";
			response.sendRedirect("shoppingcart.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
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
			request.getRequestDispatcher("shoppingcart.jsp").forward(request, response);
		} else {
			String message = "Shopping cart is empty!";
			response.sendRedirect("checkout.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
		}

	}

}
