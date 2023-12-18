package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import com.ty.dto.Employee;
import com.ty.dto.Task;

public class EmployeeDao {
	
	EntityManagerFactory entityManagerFactory=null;
	EntityManager entityManager=null;
	EntityTransaction entityTransaction=null;
	
	{
		entityManagerFactory=Persistence.createEntityManagerFactory("employee");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}

	
	public Employee AddEmployee(Employee passedEmployee)
	{
		
			entityTransaction.begin();
			entityManager.persist(passedEmployee);
			entityTransaction.commit();

			return passedEmployee;
	
	}
	
	public Employee loginEmployee(Employee passedEmployee)
	{
		Query query=entityManager.createQuery("select e from Employee e");
		List<Employee> employeeList=query.getResultList();
		
		if(employeeList!=null)
		{
			for(Employee employee:employeeList)
			{
				if(employee.getEmployeeEmail().equals(passedEmployee.getEmployeeEmail())&&employee.getEmployeePassword().equals(passedEmployee.getEmployeePassword()))
				{
					return employee;
					
				}
			}
		}
		
		return null;
		
	}
	
	public List<Employee> getAllEmployee()
	{
		Query query=entityManager.createQuery("select e from Employee e where e.employeeRoll=?1");
		query.setParameter(1, "Employee");
		List<Employee> employee=query.getResultList();
		
		return employee;
	}
	
	public boolean deleteEmployeeById(int passedId)
	{
	  Employee employeeToDelete=entityManager.find(Employee.class, passedId);
	  
	  List<Task> tasklist=employeeToDelete.getEmployeeTaskList();
	  
	  entityTransaction.begin();
	  for(Task task:tasklist)
	  {
		
		  task.setEmployee(null);
		  entityManager.remove(task);
	  }
	  tasklist=null;
	  
	  employeeToDelete.setEmployeeTaskList(tasklist);
	  
	 
	  entityManager.merge(employeeToDelete);
	  entityManager.remove(employeeToDelete);
	  entityTransaction.commit();;
	  return true;
	}
	
	public Employee updateEmployee(Employee passedEmployee)
	{
		Employee employeeToUpdate=entityManager.find(Employee.class, passedEmployee.getEmployeeId());
		employeeToUpdate.setEmployeeName(passedEmployee.getEmployeeName());
		employeeToUpdate.setEmployeeEmail(passedEmployee.getEmployeeEmail());
		employeeToUpdate.setEmployeePassword(passedEmployee.getEmployeePassword());
		employeeToUpdate.setEmployeeRoll(passedEmployee.getEmployeeRoll());
		employeeToUpdate.setEmployeeSalary(passedEmployee.getEmployeeSalary());
		
		entityTransaction.begin();
		entityTransaction.commit();
		return passedEmployee;
		
	}
	
	public boolean GetManager()
	{
		Query query=entityManager.createQuery("select m from Employee m");
		
		List<Employee> employeeList=query.getResultList();
		
	
		if(!employeeList.isEmpty())
		{
			for(int i=0;i<employeeList.size();i++)
			{
				if(employeeList.get(i).getEmployeeRoll().equals("Manager"))
				{
					return true;
				}
			}
			
		}
		return false;
	}
	

}
