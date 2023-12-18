package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.EmployeeDao;
import com.ty.dto.Employee;

@WebServlet(value = "/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id=req.getParameter("id");
		
		String name=req.getParameter("name");
		
		String salary=req.getParameter("salary");
		
		String password=req.getParameter("password");
		
		String email=req.getParameter("email");
		
		String role=req.getParameter("role");
		
		int newId=Integer.parseInt(id);
		double newSalary=Double.parseDouble(salary);
		
		Employee employee= new Employee();
		employee.setEmployeeId(newId);
		employee.setEmployeeName(name);
		employee.setEmployeeEmail(email);
		employee.setEmployeePassword(password);
		employee.setEmployeeRoll(role);
		employee.setEmployeeSalary(newSalary);
		
		
		PrintWriter printWriter=resp.getWriter();
		
		EmployeeDao employeeDao= new EmployeeDao();
		employeeDao.updateEmployee(employee);
		
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("managerHome.jsp");
        requestDispatcher.forward(req, resp);
		
	}
	
}
