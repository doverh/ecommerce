package com.ecommerce.dto;

import java.util.ArrayList;

public class Cart {
	private ArrayList<Product> allCartProducts = new ArrayList<Product>();
	private double dblOrderTotal;

	public int getLineProductCount() {
		return allCartProducts.size();
	}

	public int getProductIndex(int id) {
		int index = 0;
		
			for (Product p : allCartProducts) {
				System.out.println("Cart id = " + p.getProduct_id());
				if (p.getProduct_id() == id) {
					break;
				}
				index++;
			}
		return index;

	}

	public void deleteCartProduct(int productIndex) {
		try {
			allCartProducts.remove(productIndex);
			calculateOrderTotal();
		} catch (NumberFormatException nfe) {
			System.out.println("Error while deleting cart Product: " + nfe.getMessage());
			nfe.printStackTrace();
		}
	}

	public void updateCartProduct(int ProductIndex, String strQuantity) {
		double dblTotalCost = 0.0;
		double dblUnitCost = 0.0;
		int iQuantity = 0;
	    Product cartProduct = null;
		try {
			
			iQuantity = Integer.parseInt(strQuantity);
			if (iQuantity > 0) {
				cartProduct = (Product) allCartProducts.get(ProductIndex);
				dblUnitCost = cartProduct.getPrice();
				dblTotalCost = dblUnitCost * iQuantity;
				cartProduct.setQuantity(iQuantity);
				cartProduct.setTotalCost(dblTotalCost);
				calculateOrderTotal();
			}
		} catch (NumberFormatException nfe) {
			System.out.println("Error while updating cart: " + nfe.getMessage());
			nfe.printStackTrace();
		}

	}

	public void addCartProduct(String id, String name, String code, String price, String quantity) {
		double dblTotalCost = 0.0;
		double dblUnitCost = 0.0;
		int iQuantity = 0;
		Product Product = new Product();
		try {
			
			
			dblUnitCost = Double.parseDouble(price);
			iQuantity = Integer.parseInt(quantity);
			if (iQuantity > 0) {
				dblTotalCost = dblUnitCost * iQuantity;
				Product.setProduct_id(Integer.parseInt(id));
				//Product.setProduct_name(name);
				//Product.setCode(code);
				Product.setPrice(dblUnitCost);
				Product.setQuantity(iQuantity);
				Product.setTotalCost(dblTotalCost);
				allCartProducts.add(Product);
				calculateOrderTotal();
			}

		} catch (NumberFormatException nfe) {
			System.out.println("Error while parsing from String to primitive types: " + nfe.getMessage());
			nfe.printStackTrace();
		}
	}

	public void addCartProduct(Product Product) {
		allCartProducts.add(Product);
	}

	public Product getCartProduct(int iProductIndex) {
		Product Product = null;
		if (allCartProducts.size() > iProductIndex) {
			Product = (Product) allCartProducts.get(iProductIndex);
		}
		return Product;
	}

	public ArrayList<Product> getCartProducts() {
		return allCartProducts;
	}

	public void setCartProducts(ArrayList<Product> alCartProducts) {
		this.allCartProducts = alCartProducts;
	}

	public double getOrderTotal() {
		return dblOrderTotal;
	}

	public void setOrderTotal(double dblOrderTotal) {
		this.dblOrderTotal = dblOrderTotal;
	}

	protected void calculateOrderTotal() {
		double dblTotal = 0;
		for (int counter = 0; counter < allCartProducts.size(); counter++) {
			Product Product = (Product) allCartProducts.get(counter);
			dblTotal += Product.getTotalCost();

		}
		setOrderTotal(dblTotal);
	}

}