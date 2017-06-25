package com.ecommerce.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.controller.CartController;
import com.ecommerce.controller.CheckoutController;
import com.ecommerce.controller.LoginController;
import com.ecommerce.controller.LogoutController;
import com.ecommerce.controller.MyAccountController;
import com.ecommerce.controller.OrderController;
import com.ecommerce.controller.ProductController;
import com.ecommerce.controller.RegistrationController;
import com.ecommerce.dto.Product;
import com.ecommerce.exception.ApplicationException;
import com.ecommerce.service.ProductService;

/**
 * Servlet implementation class redirect to the controllers
 */
@WebServlet("*.do")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ActionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");
		
		//Values used to update and delete product on shopping cart
		String strQuantity = request.getParameter("quantity");
		String strproductId = request.getParameter("productId");
		
		//Values used to send informations to the OrderController 
		String userId = request.getParameter("userId");
		String orderTotal = request.getParameter("orderTotal");
		
		if (action != null && action.equalsIgnoreCase("login")) {
			new LoginController().doPost(request, response);
		} else if (action != null && action.equalsIgnoreCase("logout")) {
			new LogoutController().doPost(request, response);
		} else if (action != null && action.equalsIgnoreCase("register")) {
			new RegistrationController().doPost(request, response);
		}else if (action != null && action.equalsIgnoreCase("search")) {
				new ProductController().doPost(request, response);
		} else if (action != null && action.equalsIgnoreCase("checkout")) {
			new CheckoutController().doPost(request, response);
		} else if (action != null && action.equalsIgnoreCase("account")) {
			new MyAccountController().doPost(request, response);
		} else if (action != null && action.equalsIgnoreCase("cart")) {
			new CartController().doPost(request, response, "",strproductId,strQuantity);
		} else if (action != null && action.equalsIgnoreCase("add")) {
			new CartController().doPost(request, response, "add",strproductId,strQuantity);
		} else if (action != null && action.equalsIgnoreCase("update")) {
			new CartController().doPost(request, response, "update",strproductId,strQuantity);
		}else if (action != null && action.equalsIgnoreCase("delete")) {
			new CartController().doPost(request, response, "delete",strproductId,strQuantity);
		}else if (action != null && action.equalsIgnoreCase("order")) {
			new OrderController().doPost(request, response,userId,orderTotal);
		}else {
			// Load index page with a list of existent products
			ProductService ps = new ProductService();
			List<Product> productList;
			try {
				productList = ps.searchAllProducts();
				System.out.println("Index list" + productList.toString());
				if (!productList.isEmpty()) {
					request.setAttribute("products", productList);
					request.getRequestDispatcher("/views/index.jsp").forward(request, response);
				}
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
