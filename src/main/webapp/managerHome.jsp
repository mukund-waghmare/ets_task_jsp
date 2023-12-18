<!DOCTYPE html>
<%@page import="com.ty.dao.EmployeeDao"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.dto.Employee"%>
<%@page import="com.ty.dto.Task"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Home Page</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <header>
        <h1>Welcome to the Employee Portal</h1>
    </header>

    <nav>
        <ul style="display: flex;">
            <li><a href="register.jsp">Add Employee</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Tasks</a></li>
            <li><form action="logout" method="post">
                <button style="padding: 8px; color: white; background-color: blue; border-radius: 30px;">logout</button>
                </form></li>
        </ul>
    </nav>

    <section id="main-content">
    
    
<%
if(session.getAttribute("currentEmployee")!=null){
%>


    <div style="height: 100%; width: 100%; margin-top: 40px;">
   <table cellspacing="45"; border-sapacing: 10px 20px;>
    
      <tr>
      <th>Id</th>
      <th>Name</th>
      <th>Email</th>
      <th>Password</th>
      <th>Roll</th>
      <th>AssignedTask</th>
      <th>AssignedTaskStatus</th>
      <th>AssignTask</th>
      <th>UpdateEmployee</th>
      <th>DeleteEmployee</th>

     
     </tr>

<%
EmployeeDao employee= new EmployeeDao();
List<Employee> employeeList=employee.getAllEmployee();

for(Employee em:employeeList)
{
	int index=1;
%>

     <tr>
     <td><%=em.getEmployeeId() %></td>
     <td><%=em.getEmployeeName() %></td>
     <td><%=em.getEmployeeEmail() %></td>
     <td><%= em.getEmployeePassword()%></td>
     <td><%=em.getEmployeeRoll() %></td>
     <td style="margin-top: 5px">
        <%for(Task i: em.getEmployeeTaskList()){
        	%>
        	<%=
        			index++ +" "+i.getTaskDescription()
        	%>
        	<br>
        	<%
        }; %></td>
          <td style="margin-top: 5px">
         
        <%
        int statusIndex=1;
        for(Task i: em.getEmployeeTaskList()){
        	%>
        	<%=
        			statusIndex++ +" "+i.getTaskStatus()
        	%>
        	<br>
        	<%
        }; %>
          
          
          </td>
     
     <form method="post">
     
      <td><button style=" background-color:white; padding: 10px; border:1px solid blue; color: black; border-radius: 10%"><a style="text-decoration: none;" href="assignTask.jsp?id=<%=em.getEmployeeId()%>">AssignTask</a></button></td>
      <td><button style=" background-color:white; padding: 10px; border:1px solid blue; color: black;border-radius: 10%"><a style="text-decoration: none;" href="updateEmployee.jsp?id=<%=em.getEmployeeId() %>&name=<%=em.getEmployeeName() %>&emailId=<%=em.getEmployeeEmail() %>&password=<%=em.getEmployeePassword() %>&role=<%=em.getEmployeeRoll() %>&salary=<%=em.getEmployeeSalary() %>&">Update</a></button></td>
       <td><button style=" background-color:white; padding: 10px; border:1px solid blue; color: black;border-radius: 10%"><a style="text-decoration: none;" href="delete?id=<%=em.getEmployeeId() %>">Delete</a></button></td>
     
     </form>
     </tr>
   


<%

}
%>
</table>
</div>


<%}
else {
	
	response.sendRedirect("login.jsp");
%>



<%} %>
    
    

        
    </section>

    <footer>
        <p>&copy; 2023 Employee Portal. All rights reserved.</p>
    </footer>
</body>

</html>
