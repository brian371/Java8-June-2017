package edu.jccc.javafund.domain;

import java.util.ArrayList;

public class Order {
	private int orderNumber;
	private String customerName;
	private ArrayList<LineItem> lineItems;
	
	public Order() {
		
	}
	
	public Order(int orderNum, String customerName) {
		this.orderNumber = orderNum;
		this.customerName = customerName;
		lineItems = new ArrayList<LineItem>();
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNum) {
		this.orderNumber = orderNum;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public ArrayList<LineItem> getLineItems() {
		return lineItems;
	}
	
	public void addLineItem(Product p, int quantity) {
		// scan existing line items for product.  If the product exists,
		// add quantity to existing quantity for product.
		
		boolean found = false;
		for (LineItem li : lineItems) {
			if (li.getProduct().getModelNumber() == p.getModelNumber()) {
				li.setQuantity(li.getQuantity() + quantity);
				found = true;
				break;
			}
		}
		
		if (!found) {
			lineItems.add(new LineItem(p, quantity));
		}
	}
	
	public boolean deleteLineItem(int modelNumber) {
		boolean found = false;
		for (LineItem li : lineItems) {
			if (li.getProduct().getModelNumber() == modelNumber) {
				lineItems.remove(li);
				found = true;
				break;
			}
		}
		return found;
	}
	
	public LineItem findLineItemByModelNumber(int modelNumber) {
		LineItem li = null;
		for (int i = 0; i < lineItems.size(); i++) {
			if (lineItems.get(i).getProduct().getModelNumber() == modelNumber) {
				li = lineItems.get(i);
				break;
			}
		}
		return li;
	}
	
	public String toString() {
		String liStr = "";
		if (lineItems.size() == 0) {
			liStr = "No items.";
		} else {
			for (LineItem li : lineItems) {
				liStr += "\t" + li.toString() + "\n";
			}
		}
		
		return "Order number " + orderNumber + 
			" for " + customerName + "\n" +
			"Items:\n" + liStr;
	}
	
}
