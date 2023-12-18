package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Employee;
import com.ty.dto.Task;

public class TaskDao {

	EntityManagerFactory entityManagerFactory = null;
	EntityManager entityManager = null;
	EntityTransaction entityTransaction = null;

	{
		entityManagerFactory = Persistence.createEntityManagerFactory("employee");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	public Task assignTask(int passedEmployeeId, Task passedTask) {
		Employee employeeToAssignTask = entityManager.find(Employee.class, passedEmployeeId);
		List<Task> taskList = employeeToAssignTask.getEmployeeTaskList();

		if (employeeToAssignTask != null) {
			employeeToAssignTask.setEmployeeTaskList(taskList);
			passedTask.setEmployee(employeeToAssignTask);

			taskList.add(passedTask);
			entityTransaction.begin();
			entityManager.persist(passedTask);
			entityManager.merge(employeeToAssignTask);
			entityTransaction.commit();

			return passedTask;
		}

		return null;
	}

	public Task getTaskById(int passedTaskId) {

		Task taskToUpdate = entityManager.find(Task.class, passedTaskId);

		return taskToUpdate;
	}

	public Task UpdateTask(Task passedTask) {
		entityTransaction.begin();
		entityManager.merge(passedTask);
		entityTransaction.commit();
		return passedTask;
	}

}
