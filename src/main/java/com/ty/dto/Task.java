package com.ty.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	
	private int taskId;
	
	private String taskDescription;
	
	private String taskStatus;
	
	@ManyToOne
	private Employee employee;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Task() {
		
	}

	public Task(int taskId, String taskDescription, String taskStatus, Employee employee) {
		
		this.taskId = taskId;
		this.taskDescription = taskDescription;
		this.taskStatus = taskStatus;
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskDescription=" + taskDescription + ", taskStatus=" + taskStatus + "]";
	}
	
	
	
	
	

	}
