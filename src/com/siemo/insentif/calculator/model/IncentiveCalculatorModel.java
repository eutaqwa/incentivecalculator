package com.siemo.insentif.calculator.model;

public class IncentiveCalculatorModel {
	private String grade;
	private int salary;
	private float incentivePercentage;
	private int incentive;
	private float incentiveFloat;
	
	public IncentiveCalculatorModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public IncentiveCalculatorModel(String grade, int salary, float incentivePercentage, int incentive, float incentiveFloat) {
		super();
		this.grade = grade;
		this.salary = salary;
		this.incentivePercentage = incentivePercentage;
		this.incentive = incentive;
		this.incentiveFloat =incentiveFloat;
	}


	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public float getIncentivePercentage() {
		return incentivePercentage;
	}

	public void setIncentivePercentage(float incentivePercentage) {
		this.incentivePercentage = incentivePercentage;
	}

	public int getIncentive() {
		return incentive;
	}
	public void setIncentive(int incentive) {
		this.incentive = incentive;
	}
	public float getIncentiveFloat() {
		return incentiveFloat;
	}
	public void setIncentiveFloat(float incentiveFloat) {
		this.incentiveFloat = incentiveFloat;
	}
	
	
	
}
