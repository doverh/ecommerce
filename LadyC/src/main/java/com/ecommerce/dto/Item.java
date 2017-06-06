package com.ecommerce.dto;

public class Item {
	private String code;
	private String product_name;
	private int item_id;
	private double price;
	private String image;
	private int quantity;
	private double totalCost;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
