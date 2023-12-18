<!DOCTYPE html>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.ty.dao.EmployeeDao"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="login.css">
    <title>Login Form</title>
</head>
<body>
<%
   EmployeeDao employeeDao= new EmployeeDao();
      boolean managerStatus=employeeDao.GetManager();
      
   

%>
    <div class="login-container">
        <h2>Login</h2>
        <form action="login" method="post">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            
            <button type="submit" class="login-btn">Login</button>
        </form>
        <%
      if(!managerStatus)
      {%>
        <form action="register.jsp" style="margin-top:5px; ">
        
            <button type="submit" class="login-btn">Register</button>
        </form>
        <%} %>
    </div>
</body>
</html>
