package com.example.detyra;

import com.example.detyra.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/edit-student")
public class EditStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("id");
        Student student = null;
        List<Student> students = (List<Student>) getServletContext().getAttribute("students");
        for (Student studentFromList : students) {
            if (studentFromList.getId().equals(studentId)) {
                student = studentFromList;
                break;
            }
        }
        assert student != null;
        request.setAttribute("student", student);
        request.getRequestDispatcher("edit_student.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String studentId = request.getParameter("id");
        String updatedName = request.getParameter("name");
        String updatedEmail = request.getParameter("email");
        Student student = null;
        List<Student> students = (List<Student>) getServletContext().getAttribute("students");
        for (Student studentFromList : students) {
            if (studentFromList.getId().equals(studentId)) {
                student = studentFromList;
                break;
            }
        }
        assert student != null;
        student.setName(updatedName);
        student.setEmail(updatedEmail);
        getServletContext().setAttribute("students", students);
        response.sendRedirect("list-students");
    }
}
