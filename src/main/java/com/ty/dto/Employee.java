package com.ty.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	
	private String employeeName;
	
	private String employeeEmail;
	
	private String employeePassword;
	
	private String employeeRoll; // manager employee
	
	private double employeeSalary;
	
	private List<Task> employeeTaskList= new ArrayList<Task>();

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public String getEmployeeRoll() {
		return employeeRoll;
	}

	public void setEmployeeRoll(String employeeRoll) {
		this.employeeRoll = employeeRoll;
	}

	public double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public List<Task> getEmployeeTaskList() {
		return employeeTaskList;
	}

	public void setEmployeeTaskList(List<Task> employeeTaskList) {
		this.employeeTaskList = employeeTaskList;
	}

	public Employee(int employeeId, String employeeName, String employeeEmail, String employeePassword,
			String employeeRoll, double employeeSalary) {
		
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.employeePassword = employeePassword;
		this.employeeRoll = employeeRoll;
		this.employeeSalary = employeeSalary;
	}
	
	
	
	
	
	
	
	
	
	

}
