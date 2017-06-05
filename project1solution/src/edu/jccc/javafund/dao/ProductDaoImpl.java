package edu.jccc.javafund.dao;

import java.util.ArrayList;

import com.protech.io.ConsoleHelper;

import edu.jccc.javafund.domain.Product;

/*
 * The ProductManager class is used to store and retieve
 * products
 */
public class ProductDaoImpl implements ProductDao {
	private ArrayList<Product> products = new ArrayList<Product>();

	/* (non-Javadoc)
	 * @see edu.ku.train.manager.ProductManager#getProducts()
	 */
	public ArrayList<Product> getProducts() {
		return products;
	} // end getProducts

	/* (non-Javadoc)
	 * @see edu.ku.train.manager.ProductManager#add(edu.ku.train.model.Product)
	 */
	public void add(Product p) {
		products.add(p);
	} // end add

	/*
	 * finds a product given a model number
	 */
	/* (non-Javadoc)
	 * @see edu.ku.train.manager.ProductManager#findProductByModelNumber(int)
	 */
	public Product findProductByModelNumber(int modelNumber) {
		Product p = null;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getModelNumber() == modelNumber) {
				p = products.get(i);
				break;
			} // end if
		} // end for
				
		return p;
	} // end findProductByModelNumber

	/* (non-Javadoc)
	 * @see edu.ku.train.manager.ProductManager#delete(int)
	 */
	public boolean delete(int modelNumber) {
		boolean removed = false;
		Product p = findProductByModelNumber(modelNumber);
		if (p != null) {
			products.remove(p);
			removed = true;
		}

		return removed;
	}

	
}
