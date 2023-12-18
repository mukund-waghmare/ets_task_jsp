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

@WebServlet(value = "/delete")
public class DeleteServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession ses=req.getSession();
        Employee employee=(Employee)ses.getAttribute("currentEmployee");
     
		
		if(employee!=null)
		{
		
		String id=req.getParameter("id");
		
		PrintWriter printWriter=resp.getWriter();
		
		System.out.println((Employee)req.getAttribute("currentEmployee"));
		int employeeId=Integer.parseInt(id);
		EmployeeDao employeeDao= new EmployeeDao();
		boolean deleteResult=employeeDao.deleteEmployeeById(employeeId);
		System.out.println("===============================================================");
		RequestDispatcher rd= req.getRequestDispatcher("managerHome.jsp");
		rd.forward(req, resp);
		}
		else
		{
			resp.sendRedirect("login.jsp");
		}
		
	}
}
