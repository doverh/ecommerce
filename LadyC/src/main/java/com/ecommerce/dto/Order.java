package com.ecommerce.dto;

import java.util.ArrayList;


public class Order {
	private int order_number;
	private int user_id;
	private double amount;
	private ArrayList<Item> allCartItems;
	
	public int getOrder_number() {
		return order_number;
	}
	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public ArrayList<Item> getAllCartItems() {
		return allCartItems;
	}
	public void setAllCartItems(ArrayList<Item> allCartItems) {
		this.allCartItems = allCartItems;
	}

}
