<%@page import="com.ty.dto.Task"%>
<%@page import="com.ty.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Home Page</title>
    <link rel="stylesheet" href="employeeHome.css">
</head>

<body>
    <header>
        <h1>Welcome to the Employee Portal</h1>
    </header>

    <nav>
        <ul style="display: flex;">
            <li><a href="#">Home</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Tasks</a></li>
            <li>
            <form action="logout" method="post">
            
              <button style="background-color: #2c3e50; color: white;">Logout</button>
            </form>
            </li>
        </ul>
    </nav>

    <section id="main-content">
    
    
    <%
    
    Employee Currentemployee=(Employee)session.getAttribute("currentEmployee");
    if(Currentemployee!=null)
    {
    %>
    
        <table style="width: 80%; margin: auto; border-collapse: collapse; margin-top: 20px;">
        <thead>
            <tr style="background-color: #3498db; color: #fff;">
                 
                <th style="border: 1px solid #ddd; padding: 8px;">Employee Id</th>
                <th style="border: 1px solid #ddd; padding: 8px;">Employee Name</th>
                <th style="border: 1px solid #ddd; padding: 8px;">Employee Email</th>
                <th style="border: 1px solid #ddd; padding: 8px;">Employee Password</th>
                <th style="border: 1px solid #ddd; padding: 8px;">Employee Role</th>
                <th style="border: 1px solid #ddd; padding: 8px;">Employee Salary</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td style="border: 1px solid #ddd; padding: 8px;"><%=Currentemployee.getEmployeeId() %></td>
                <td style="border: 1px solid #ddd; padding: 8px;"><%=Currentemployee.getEmployeeName() %></td>
                <td style="border: 1px solid #ddd; padding: 8px;"><%=Currentemployee.getEmployeeEmail() %></td>
                <td style="border: 1px solid #ddd; padding: 8px;"><%=Currentemployee.getEmployeePassword() %></td>
                <td style="border: 1px solid #ddd; padding: 8px;"><%=Currentemployee.getEmployeeRoll() %></td>
                <td style="border: 1px solid #ddd; padding: 8px;"><%=Currentemployee.getEmployeeSalary() %></td>
                
            </tr>
        </tbody>
    </table>

    <h2 style="text-align: center; margin-top: 20px; border-bottom: 2px solid #3498db; padding-bottom: 5px;">
        Update Task Status</h2>
    
---------------------------------------------------------------------------------------------------------    
    <table style="width: 80%; margin: auto; border-collapse: collapse; margin-top: 20px;">
        <thead>
            <tr style="background-color: #3498db; color: #fff;">
                <th style="border: 1px solid #ddd; padding: 8px;">Task ID</th>
                <th style="border: 1px solid #ddd; padding: 8px;">Task Description</th>
                <th style="border: 1px solid #ddd; padding: 8px;">Task Status</th>
                
                <th style="border: 1px solid #ddd; padding: 8px;">Update Status</th>
            </tr>	
        </thead>
        <%
           for(Task task:Currentemployee.getEmployeeTaskList())
           {
        %>
        <tbody>
            <tr>
                <td style="border: 1px solid #ddd; padding: 8px;"><%=task.getTaskId() %></td>
                <td style="border: 1px solid #ddd; padding: 8px;"><%=task.getTaskDescription() %></td>
                <td style="border: 1px solid #ddd; padding: 8px;"><%=task.getTaskStatus() %></td>
                
                <td style="border: 1px solid #ddd; padding: 8px;"><a style="text-decoration: none; color: black; border:1px solid black padding: 3px; border-radius: 30%" href="updateTask?taskId=<%=task.getTaskId()%>">Change Status</a></td>
                
            </tr>
        
        </tbody>
        <%} %>
    </table>

    

        
    </section>

    <footer>
        <p>&copy; 2023 Employee Portal. All rights reserved.</p>
    </footer>
    
    <%}
    else {
    	
    	response.sendRedirect("login.jsp");
    %>
       
    <%} %>

    
</body>

</html>
