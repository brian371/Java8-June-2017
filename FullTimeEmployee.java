package com.protechtraining.java8oo.model;

public class FullTimeEmployee extends Employee {
	private double salary;
	
	public FullTimeEmployee() {
		super();
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public double calculatePay() {
		// TODO Auto-generated method stub
		return salary / 24;
	}

	@Override
	public String toString() {
		return super.toString() + 
				"FullTimeEmployee [salary=" + salary + "]";
	}
	
	
}
