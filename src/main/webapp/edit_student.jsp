<%@ page language="java" %>
<%@ page import="com.example.detyra.model.Student" %>
<html>
<head>
    <title>Edit Student</title>
</head>
<body>
<h1>Edit Student</h1>
<form action="edit-student" method="post">
    <%
        Student student = (Student) request.getAttribute("student");
        if (student != null) {
    %>
    <input type="hidden" name="id" value="<%= student.getId() %>"/>
    Name: <input type="text" name="name" value="<%= student.getName() %>"/><br>
    Email: <input type="text" name="email" value="<%= student.getEmail() %>\"/><br>
    <input type="submit" value="Update">
    <%
    } else {%>
    <p> Cannot edit a null student!</p>
    <a href="list-students">Go to main page</a>
    <% }
    %>
</form>
</body>
</html>
