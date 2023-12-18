package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.TaskDao;
import com.ty.dto.Task;

@WebServlet(value = "/assignTaskServlet")
public class AssignTaskServlet extends HttpServlet {
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 String id=(String) req.getParameter("taskId");
		 int actualsEmployeeId=Integer.parseInt(id);
		
		String taskDescription=req.getParameter("taskDescription");
		
		String taskStatus=req.getParameter("taskStatus");
		
		
		PrintWriter printWriter= resp.getWriter();
		
		TaskDao taskDtoObject= new TaskDao();
		
		Task newTask= new Task();
		newTask.setTaskDescription(taskDescription);
		newTask.setTaskStatus(taskStatus);
		
		
		
		Task taskState=taskDtoObject.assignTask(actualsEmployeeId, newTask);
		if(taskState!=null)
		{ 
			printWriter.print("<h1>Task Assigned Successfully<h1>");
			
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("assignTask.jsp");
			requestDispatcher.include(req, resp);
		}
		else
		{
			printWriter.print("<h1>Cannot Assign Task<h1>");
			
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("assignTask.jsp");
			requestDispatcher.include(req, resp);
			
		}
	}

}
