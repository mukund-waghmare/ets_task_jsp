package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.dao.EmployeeDao;
import com.ty.dto.Employee;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String role=req.getParameter("role");
		
		PrintWriter printWriter=resp.getWriter();
	
		
		Employee employee = new Employee();
		employee.setEmployeeEmail(email);
		employee.setEmployeePassword(password);
		
		EmployeeDao employeeDao= new EmployeeDao();
		Employee employeeResult=employeeDao.loginEmployee(employee);
		
		if(employeeResult!=null && employeeResult.getEmployeeRoll().equals("Manager"))
		{
			HttpSession session=req.getSession();
			
			session.setAttribute("currentEmployee", employeeResult);
			
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("managerHome.jsp");
			requestDispatcher.forward(req, resp);
			
			
		}
		else if(employeeResult!=null && employeeResult.getEmployeeRoll().equals("Employee"))
		{
			HttpSession session=req.getSession();
			
			session.setAttribute("currentEmployee", employeeResult);
			
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("employeeHome.jsp");
			requestDispatcher.forward(req, resp);
			
		}
		else
		{
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("login.jsp");
			requestDispatcher.include(req, resp);
			printWriter.print("<h1 style='position:absolute; top:10px'>Invalid Login Credentials</h1>");
		}
	}
	
	
}
