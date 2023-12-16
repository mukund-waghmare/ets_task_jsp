package com.ty.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int taskId;
	
	private String taskDescription;

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

	public Task(int taskId, String taskDescription) {
	
		this.taskId = taskId;
		this.taskDescription = taskDescription;
	}

	public Task() {
		super();
	}
	
	
	
	
	
	
	
	
	

}
