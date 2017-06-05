package edu.jccc.javafund.dao;

import java.util.ArrayList;

import edu.jccc.javafund.domain.Product;

public interface ProductDao
{

	public abstract ArrayList<Product> getProducts(); // end getProducts

	public abstract void add(Product p); // end add

	/*
	 * finds a product given a model number
	 */
	public abstract Product findProductByModelNumber(int modelNumber); // end findProductByModelNumber

	public abstract boolean delete(int modelNumber);

	
}