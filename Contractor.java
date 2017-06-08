package com.protechtraining.java8oo.model;

public class Contractor extends Employee {
	private double rate;
	private double hours;

	public Contractor() {
		super();
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getHours() {
		return hours;
	}
	public void setHours(double hours) {
		this.hours = hours;
	}
	@Override
	public String toString() {
		return super.toString() + "Contractor [rate=" + rate + ", hours=" + hours + "]";
	}
	
	@Override
	public double calculatePay() {
		return rate * hours;
	}
	
}
