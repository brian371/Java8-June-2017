package edu.jccc.javafund.dao;

import java.util.ArrayList;

import com.protech.io.ConsoleHelper;

import edu.jccc.javafund.domain.Order;

public class OrderDaoImpl implements OrderDao {
	private ArrayList<Order> orders = new ArrayList<Order>();

	/* (non-Javadoc)
	 * @see edu.jccc.javafund.dao.OrderDao#getOrders()
	 */
	@Override
	public ArrayList<Order> getOrders() {
		return orders;
	} // end getOrders

	/* (non-Javadoc)
	 * @see edu.jccc.javafund.dao.OrderDao#add(edu.jccc.javafund.domain.Order)
	 */
	@Override
	public void add(Order o) {
		orders.add(o);
	} // end add

	/* (non-Javadoc)
	 * @see edu.jccc.javafund.dao.OrderDao#findOrderByOrderNumber(int)
	 */
	@Override
	public Order findOrderByOrderNumber(int orderNumber) {
		Order o = null;
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderNumber() == orderNumber) {
				o = orders.get(i);
				break;
			}
		}
		return o;
	}

	/* (non-Javadoc)
	 * @see edu.jccc.javafund.dao.OrderDao#delete(int)
	 */
	@Override
	public boolean delete(int orderNumber) {
		boolean removed = false;
		Order o = findOrderByOrderNumber(orderNumber);
		if (o != null) {
			orders.remove(o);
			removed = true;
		}
		
		return removed;
	}

}
