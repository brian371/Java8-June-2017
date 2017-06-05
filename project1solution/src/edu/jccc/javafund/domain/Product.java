package edu.jccc.javafund.domain;

public class Product implements Cloneable {
	// attributes
	private int modelNumber;
	private double price;
	private String description;
	
	public Product() {
		
	}
	
	public Product(int modelNumber, double price, String description) {
		this.modelNumber = modelNumber;
		this.price = price;
		this.description = description;
	}

	public int getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(int modelNumber) {
		this.modelNumber = modelNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String toString() {
		return "model number: " + modelNumber + 
				", description: " + description +
				", price: " + price;
	}
	
	// Cloning makes an exact copy of an object.  We need to 
	// do this so a LineItem contains the product information at 
	// the time of sale, and not the current info
	public Product clone() {

	    Product clone;
		try {
			clone = (Product)super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException("Problem cloning Product.", e);
		}
	    return clone;

	  }
}
