package com.ecommerce.dto;

import java.util.ArrayList;

public class Cart {
	private ArrayList<Item> allCartItems = new ArrayList<Item>();
	private double dblOrderTotal;

	public int getLineItemCount() {
		return allCartItems.size();
	}

	public int getItemIndex(int id) {
		int index = 0;
		
			for (Item i : allCartItems) {
				System.out.println("Cart id = " + i.getItem_id());
				if (i.getItem_id() == id) {
					break;
				}
				index++;
			}
		return index;

	}

	public void deleteCartItem(int itemIndex) {
		try {
			allCartItems.remove(itemIndex);
			calculateOrderTotal();
		} catch (NumberFormatException nfe) {
			System.out.println("Error while deleting cart item: " + nfe.getMessage());
			nfe.printStackTrace();
		}
	}

	public void updateCartItem(int itemIndex, String strQuantity) {
		double dblTotalCost = 0.0;
		double dblUnitCost = 0.0;
		int iQuantity = 0;
	    Item cartItem = null;
		try {
			
			iQuantity = Integer.parseInt(strQuantity);
			if (iQuantity > 0) {
				cartItem = (Item) allCartItems.get(itemIndex);
				dblUnitCost = cartItem.getPrice();
				dblTotalCost = dblUnitCost * iQuantity;
				cartItem.setQuantity(iQuantity);
				cartItem.setTotalCost(dblTotalCost);
				calculateOrderTotal();
			}
		} catch (NumberFormatException nfe) {
			System.out.println("Error while updating cart: " + nfe.getMessage());
			nfe.printStackTrace();
		}

	}

	public void addCartItem(String id, String name, String code, String price, String quantity) {
		double dblTotalCost = 0.0;
		double dblUnitCost = 0.0;
		int iQuantity = 0;
		Item item = new Item();
		try {
			
			
			dblUnitCost = Double.parseDouble(price);
			iQuantity = Integer.parseInt(quantity);
			if (iQuantity > 0) {
				dblTotalCost = dblUnitCost * iQuantity;
				item.setItem_id(Integer.parseInt(id));
				item.setProduct_name(name);
				item.setCode(code);
				item.setPrice(dblUnitCost);
				item.setQuantity(iQuantity);
				item.setTotalCost(dblTotalCost);
				allCartItems.add(item);
				calculateOrderTotal();
			}

		} catch (NumberFormatException nfe) {
			System.out.println("Error while parsing from String to primitive types: " + nfe.getMessage());
			nfe.printStackTrace();
		}
	}

	public void addCartItem(Item item) {
		allCartItems.add(item);
	}

	public Item getCartItem(int iItemIndex) {
		Item item = null;
		if (allCartItems.size() > iItemIndex) {
			item = (Item) allCartItems.get(iItemIndex);
		}
		return item;
	}

	public ArrayList<Item> getCartItems() {
		return allCartItems;
	}

	public void setCartItems(ArrayList alCartItems) {
		this.allCartItems = alCartItems;
	}

	public double getOrderTotal() {
		return dblOrderTotal;
	}

	public void setOrderTotal(double dblOrderTotal) {
		this.dblOrderTotal = dblOrderTotal;
	}

	protected void calculateOrderTotal() {
		double dblTotal = 0;
		for (int counter = 0; counter < allCartItems.size(); counter++) {
			Item item = (Item) allCartItems.get(counter);
			dblTotal += item.getTotalCost();

		}
		setOrderTotal(dblTotal);
	}

}