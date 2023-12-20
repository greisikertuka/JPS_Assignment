<%@ page language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.detyra.model.Student" %>
<!DOCTYPE html>
<html>
<head>
    <title>Students List</title>
</head>
<body>
<h2>Students List</h2>

<%
    List<Student> students = (List<Student>) request.getAttribute("students");

    if (students != null && !students.isEmpty()) {
%>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th colspan="3">Actions</th>

    </tr>
    <% for (Student student : students) { %>
    <tr>
        <td><%= student.getName() %>
        </td>
        <td><%= student.getEmail() %>
        </td>
        <td><a href="add-student">Add</a></td>
        <td><a href="edit-student?id=<%=student.getId()%>">Edit</a></td>
        <td>
            <form action="delete-student" method="post">
                <input type="hidden" name="id" value=<%=student.getId()%>>
                <button type="submit">Delete</button>
            </form>
        </td>

    </tr>
    <% } %>
</table>
<%
} else {
%>
<p>No students found.</p>
<p>
    <a href="add-student">Add student</a>
</p>
<%
    }
%>
</body>
</html>
