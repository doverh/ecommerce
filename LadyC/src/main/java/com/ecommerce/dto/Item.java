package com.ecommerce.dto;



public class Item {
	
	private int item_id;
	private int quantity;
	private double totalCost;
	private int order_number;
	private double price;
	private int product_id;
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getOrder_number() {
		return order_number;
	}
	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}
	
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getTotalCost() {
		return totalCost;
	}
	
	public void setTotalCost(double dblTotalCost) {
		this.totalCost = dblTotalCost;
		
	}
}
