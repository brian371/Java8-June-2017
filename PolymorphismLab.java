package com.protechtraining.java8oo.app;

import com.protechtraining.java8oo.model.Contractor;
import com.protechtraining.java8oo.model.Employee;
import com.protechtraining.java8oo.model.FullTimeEmployee;

public class PolymorphismLab {
	public static void main(String[] args) {
		FullTimeEmployee ft1 = new FullTimeEmployee();
		ft1.setFirstName("Bob");
		ft1.setLastName("Smith");
		ft1.setSalary(80000.0);
		
		Contractor c1 = new Contractor();
		c1.setFirstName("Sue");
		c1.setLastName("Jones");
		c1.setHours(20);
		c1.setRate(100.0);
		Employee[] employees = new Employee[2];
		employees[0] = ft1;
		employees[1] = c1;
		
		for (Employee e : employees) {
			System.out.println(e.getFirstName() + " " + e.getLastName() +
					" got paid " + e.calculatePay());
		}
		
		
	}
}
