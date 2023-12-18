<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="register.css">
    <title>Registration Form</title>
</head>
<body>
    <div class="container">
        <form  action="registerEmployee" method="post">
            <h2>Registration Form</h2>
            <div class="form-group">
                <label for="name">Employee Name:</label>
                <input type="text" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="email">Employee Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="password"> Employee Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="form-group">
                <label for="role"> Employee Role:</label>
               <!--  <input type="text" > -->
                <select id="contact" name="role" required >
                <option></option>>
                <option>Manager</option>
                <option>Employee</option>>
                </select>
            </div>
            <div class="form-group">
                <label for="salary"> Employee Salary:</label>
                <input type="text" id="contact" name="salary" required>
            </div>
            <div class="form-group">
                <button type="submit">Register</button>
            </div>
          
           
        </form>
         <%
             
         if(session.getAttribute("currentEmployee") == null){
         %>
          <form action="login.jsp" >
        
            <button type="submit" style="position: absolute; bottom: 35px; left: 350px">Login</button>
        </form>
        <% }  else
        {%>
          <form action="managerHome.jsp" >
        
            <button type="submit" style="position: absolute; bottom: 35px; left: 350px">Back</button>
        </form>
        <%
        }%>
        
   
       
       
        </div>
</body>
</html>