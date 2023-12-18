<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assignTask.css">
    <title>Task Assignment</title>
</head>
<body>
      <%
    String id=(String)request.getParameter("id");
    %>
    <div class="container">
        <h1>Task Assignment</h1>
        <form action="assignTaskServlet?id=<%=id %>" id="taskForm">
            <input type="hidden" name="taskId" value="<%=id %>">
            <label for="taskDescription">Task Description:</label>
            <textarea id="taskDescription" name="taskDescription" rows="4" required></textarea>

            <label for="taskStatus">Task Status:</label>
            <select id="taskStatus" name="taskStatus" required>
                <option value="Not Started">Not Started</option>
                <option value="In Progress">In Progress</option>
                <option value="Completed">Completed</option>
            </select>

            <button type="submit">Assign Task</button>
        </form>
        <form action="managerHome.jsp">
         
            <button style="margin-top: 5px" type="submit">Back</button>
        </form>
    </div>
    
     
    
</body>
</html>
