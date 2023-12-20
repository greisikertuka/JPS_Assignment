package com.example.detyra;

import com.example.detyra.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/add-student")
public class AddStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("add_student.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        List<Student> students = (List<Student>) getServletContext().getAttribute("students");
        if (students == null) {
            students = new ArrayList<>();
            getServletContext().setAttribute("students", students);
        }
        students.add(new Student(java.util.UUID.randomUUID().toString(), name, email));

        response.sendRedirect("list-students");
    }
}

