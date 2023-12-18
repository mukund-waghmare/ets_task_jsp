package com.ty.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.TaskDao;
import com.ty.dto.Employee;
import com.ty.dto.Task;

@WebServlet(value = "/updateTask")
public class UpdateTaskServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String taskId = req.getParameter("taskId");
		int actualId = Integer.parseInt(taskId);

		Task task = new TaskDao().getTaskById(actualId);

		if (task.getTaskStatus().equalsIgnoreCase("Not Started"))
			task.setTaskStatus("In Progress");
		else if (task.getTaskStatus().equalsIgnoreCase("In Progress"))
			task.setTaskStatus("Completed");
		else if (task.getTaskStatus().equalsIgnoreCase("Completed"))
			task.setTaskStatus("Not Started");
  
		
		
		 task=new TaskDao().UpdateTask(task);
		System.out.println(task);
		
		Employee employee=(Employee)req.getSession().getAttribute("currentEmployee");
		List<Task> taskList=employee.getEmployeeTaskList();
		
		for(Task task1:taskList)
		{
			if(task1.getTaskId()==task.getTaskId())
			{
				task1.setTaskStatus(task.getTaskStatus());
			}
			
		}
		
		
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("employeeHome.jsp");
		requestDispatcher.forward(req, resp);
		
	}
}
