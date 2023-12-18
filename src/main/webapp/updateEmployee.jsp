<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
   <link rel="stylesheet" href="register.css">
</head>
<body>





<%
if(session.getAttribute("currentEmployee")!=null)
{
  PrintWriter printWriter=response.getWriter();
  String id=request.getParameter("id");
  String name=request.getParameter("name");
  String email=request.getParameter("emailId");
  String password=request.getParameter("password");
  String role=request.getParameter("role");
  String salary=request.getParameter("salary");
  
  int actualId=Integer.parseInt(id);
  double actualSalary=Double.parseDouble(salary);
  
%>

    <div class="container">
        <form  action="updateEmployee?id=<%=id %>" method="post">
            <h2>Update Employee Information Form</h2>
            <div class="form-group">
                <label for="name">Employee Name:</label>
                <input type="text" id="name" name="name" required value="<%=name%>">
                
            </div>
            <div class="form-group">
                <label for="email">Employee Email:</label>
                <input type="email" id="email" name="email" required value="<%=email%>">
            </div>
            <div class="form-group">
                <label for="password"> Employee Password:</label>
                <input type="password" id="password" name="password" required value="<%=password%>">
            </div>
            <div class="form-group">
                <label for="role"> Employee Role:</label>
                <input type="text" id="contact" name="role" required value="<%=role%>">
            </div>
            <div class="form-group">
                <label for="salary"> Employee Salary:</label>
                <input type="text" id="contact" name="salary" required value="<%=salary%>">
            </div>
            <div class="form-group">
                <button type="submit">Update</button>
            </div>
          
           
        </form>
         
          <form action="managerHome.jsp" >
        
            <button type="submit" style="position: absolute; bottom: 35px; left: 350px">Back</button>
        </form>
       
        </div>
        
 <%}
else
{
  response.sendRedirect("login.jsp");

%>



<%} %>


</body>
</html>