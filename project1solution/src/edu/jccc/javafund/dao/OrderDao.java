package edu.jccc.javafund.dao;

import java.util.ArrayList;

import edu.jccc.javafund.domain.Order;

public interface OrderDao
{

	public abstract ArrayList<Order> getOrders(); // end getOrders

	public abstract void add(Order o); // end add

	public abstract Order findOrderByOrderNumber(int orderNumber);

	public abstract boolean delete(int orderNumber);

}