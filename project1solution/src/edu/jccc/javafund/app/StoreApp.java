package edu.jccc.javafund.app;

import java.util.ArrayList;

import com.protech.io.ConsoleHelper;

import edu.jccc.javafund.dao.OrderDao;
import edu.jccc.javafund.dao.OrderDaoImpl;
import edu.jccc.javafund.dao.ProductDao;
import edu.jccc.javafund.dao.ProductDaoImpl;
import edu.jccc.javafund.domain.LineItem;
import edu.jccc.javafund.domain.Order;
import edu.jccc.javafund.domain.Product;
import edu.jccc.javafund.util.InputUtils;

public class StoreApp {

	public static void main(String[] args) {
		ProductDao prodManager = new ProductDaoImpl();
		OrderDao orderManager = new OrderDaoImpl();
		int choice = 0;
		
		int modelNumber;
		double price;
		String description;
		
		int orderNumber;
		String customerName;
		
		Product p;
		
		Order o;

		do {
			// display the menu of choices
			System.out.println();
			System.out.println("1.List products");
			System.out.println("2.Add product");
			System.out.println("3.Update product");
			System.out.println("4.Delete product");

			System.out.println("5.List Orders");
			System.out.println("6.Add Order");
			System.out.println("7.Update Order");
			System.out.println("8.Delete Order");

			System.out.println("9.Add Product to Order");
			System.out.println("10.Delete Product from Order");

			System.out.println("11.Exit");
			
			
			// Ask the user for their choice
			choice = ConsoleHelper.readInt("Enter a choice: ");

			// process the choice
			switch (choice)
			{
			case 1:  // list products
				ArrayList<Product> products = prodManager.getProducts();
				if (products.size() == 0) {
					System.out.println("No products.");
				} else {
					for (int i = 0; i < products.size(); i++) {
						Product prod = products.get(i);
						System.out.println(prod.toString());
					}
				}

				
				
				break;				
			case 2: // add product
				modelNumber = InputUtils.inputModelNumber();
				price = InputUtils.inputPrice();
				description = InputUtils.inputDescription();
				
				p  = new Product(modelNumber, price, description);
				prodManager.add(p);
				break;
			case 3: // update product
				modelNumber = InputUtils.inputModelNumber();
				p = prodManager.findProductByModelNumber(modelNumber);
				if (p == null) {
					System.out.println("Product with model number " + modelNumber + " not found.");
				} else {
					price = InputUtils.inputPrice();
					description = InputUtils.inputDescription();
					
					p.setPrice(price);
					p.setDescription(description);
					System.out.println("Product updated.");
				}
				break;
			case 4: // delete product
				modelNumber = InputUtils.inputModelNumber();
				if (prodManager.delete(modelNumber)) {
					System.out.println("Product deleted.");
				} else {
					System.out.println("Product with model number " + modelNumber + " not found.");
				}
				break;
			case 5:  // list orders
				ArrayList<Order> orders = orderManager.getOrders();
				if (orders.size() == 0) {
					System.out.println("No orders.");
				} else {
					for (Order ord : orders) {
						System.out.println(ord.toString());
					}
				}
				break;
			case 6: // add order
				orderNumber = InputUtils.inputOrderNumber();
				customerName = InputUtils.inputCustomerName();
				
				o  = new Order(orderNumber, customerName);
				orderManager.add(o);
				break;
			case 7: // update order
				orderNumber = InputUtils.inputOrderNumber();
				o = orderManager.findOrderByOrderNumber(orderNumber);
				if (o == null) {
					System.out.println("Order with order number " + orderNumber + " not found.");
				} else {
					customerName = InputUtils.inputCustomerName();
					
					o.setCustomerName(customerName);
					System.out.println("Order updated.");
				}
				break;
			case 8: // delete order
				orderNumber = InputUtils.inputOrderNumber();
				if (orderManager.delete(orderNumber)) {
					System.out.println("Order deleted.");
				} else {
					System.out.println("Order with order number " + orderNumber + " not found.");
				}
				break;
				
			case 9: // add product to order
				orderNumber = InputUtils.inputOrderNumber();
				if ((o = orderManager.findOrderByOrderNumber(orderNumber)) != null) {				
					modelNumber = InputUtils.inputModelNumber();
					if ((p = prodManager.findProductByModelNumber(modelNumber)) != null) {
						int quantity = InputUtils.inputQuantity();
						o.addLineItem(p, quantity);
						System.out.println(quantity + " " + p.getDescription() + " added to order");
					} else {
						System.out.println("Product with model number " + modelNumber + " not found.");
					}
				} else {
					System.out.println("Order with order number " + orderNumber + " not found.");
				}
				break;
			case 10: // remove product from order
				orderNumber = InputUtils.inputOrderNumber();
				if ((o = orderManager.findOrderByOrderNumber(orderNumber)) != null) {				
					modelNumber = InputUtils.inputModelNumber();
					LineItem li = o.findLineItemByModelNumber(modelNumber);
					if (li != null) {
						o.deleteLineItem(modelNumber);
						System.out.println("All " + li.getProduct().getDescription() + " (" + li.getQuantity() + " total) removed from order.");
					} else {
						System.out.println("Product with model number " + modelNumber + " not found on order.");
					}
				} else {
					System.out.println("Order with order number " + orderNumber + " not found.");
				}
				break;
			case 11:
				System.out.println("Good bye!");
				break;
			default:
				System.out.println("Invalid choice.");
			} // end switch

		} while (choice != 11);

	}

}
