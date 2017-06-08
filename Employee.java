package com.protechtraining.java8oo.model;

public class Employee {
	private int employeeNum;
	private String firstName;
	private String lastName;
	private String department;
	
	public int getEmployeeNum() {
		return employeeNum;
	}
	public void setEmployeeNum(int employeeNum) {
		this.employeeNum = employeeNum;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public double calculatePay() {
		return 0.0;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeNum=" + employeeNum + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", department=" + department + "]";
	}
	
}
