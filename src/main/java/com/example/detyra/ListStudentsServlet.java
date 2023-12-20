package com.example.detyra;

import com.example.detyra.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list-students")
public class ListStudentsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = (List<Student>) getServletContext().getAttribute("students");
        request.setAttribute("students", students);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}

