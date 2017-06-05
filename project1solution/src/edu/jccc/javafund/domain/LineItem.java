package edu.jccc.javafund.domain;

public class LineItem {
	private Product product;
	private int quantity;
	
	public LineItem() {
		
	}
	
	public LineItem(Product p, int quantity) {
		this.product = p.clone();
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String toString() {
		return "Product info: " + product + ", quantity: " + quantity;
	}
}
