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

@WebServlet(value = "/registerEmployee")
public class RegisterServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String employeeName=req.getParameter("name");
        String employeeEmail=req.getParameter("email");
        String employeePassword=req.getParameter("password");
        String employeeRoll=req.getParameter("role");
        String employeeSalary=req.getParameter("salary");
        
        double orignalSalary=Double.parseDouble(employeeSalary);
        
        Employee employee = new Employee();
        
        employee.setEmployeeName(employeeName);
        employee.setEmployeeEmail(employeeEmail);
        employee.setEmployeePassword(employeePassword);
        employee.setEmployeeSalary(orignalSalary);
        employee.setEmployeeRoll(employeeRoll);
         
         EmployeeDao employeeDao= new EmployeeDao();
         Employee employeeResult=employeeDao.AddEmployee(employee);
         
         
         PrintWriter printWriter=resp.getWriter();
         printWriter.print("<h1 class='msg'>Employee Registred Successfully</h1>");
         
         RequestDispatcher requestDispatcher=req.getRequestDispatcher("register.jsp");
         requestDispatcher.include(req, resp);
         
	}
	
	

}
