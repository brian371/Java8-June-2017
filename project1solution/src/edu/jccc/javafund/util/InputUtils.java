package edu.jccc.javafund.util;

import com.protech.io.ConsoleHelper;

public class InputUtils
{
	// -------------------------------------------------------
	// Product methods
	// -------------------------------------------------------

	public static int inputModelNumber()
	{
		String prompt = "Enter a model number (10000 - 19999): ";
		int modelNumber = ConsoleHelper.readInt(prompt);
		while (modelNumber < 10000 || modelNumber > 19999)
		{
			System.out
					.println("The model number must be between 10000 and 19999.");
			modelNumber = ConsoleHelper.readInt(prompt);
		}
		return modelNumber;
	}

	public static double inputPrice()
	{
		String prompt = "Enter price (0 - 9999.99): ";
		double price = ConsoleHelper.readDouble(prompt);
		while (price < 0.0 || price > 9999.99)
		{
			System.out.println("The price must be between 0.00 and 9999.99.");
			price = ConsoleHelper.readDouble(prompt);
		}
		return price;
	}

	public static String inputDescription()
	{
		String prompt = "Enter description: ";
		String description = ConsoleHelper.readLine(prompt).trim();
		while ("".equals(description))
		{
			System.out.println("You must enter a description");
			description = ConsoleHelper.readLine(prompt).trim();
		}
		return description;
	}

	// -------------------------------------------------------
	// Order methods
	// -------------------------------------------------------

	public static int inputOrderNumber()
	{
		String prompt = "Enter a order number (20000 - 29999): ";
		int orderNumber = ConsoleHelper.readInt(prompt);
		while (orderNumber < 20000 || orderNumber > 29999)
		{
			System.out
					.println("The order number must be between 20000 and 29999.");
			orderNumber = ConsoleHelper.readInt(prompt);
		}
		return orderNumber;
	}

	public static String inputCustomerName()
	{
		String prompt = "Enter customer name: ";
		String customerName = ConsoleHelper.readLine(prompt).trim();
		while ("".equals(customerName))
		{
			System.out.println("You must enter a customer name");
			customerName = ConsoleHelper.readLine(prompt).trim();
		}
		return customerName;
	}

	public static int inputQuantity()
	{
		String prompt = "Enter quantity (must be 1 or more): ";
		int quantity = ConsoleHelper.readInt(prompt);
		while (quantity < 1)
		{
			System.out.println("The quantity must be 1 or more.");
			quantity = ConsoleHelper.readInt(prompt);
		}
		return quantity;
	}

}
