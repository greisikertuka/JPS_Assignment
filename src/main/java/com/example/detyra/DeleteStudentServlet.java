package com.example.detyra;

import com.example.detyra.model.Student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@WebServlet("/delete-student")
public class DeleteStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String studentId = request.getParameter("id");
        List<Student> students = (List<Student>) getServletContext().getAttribute("students");
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (Objects.equals(student.getId(), studentId)) {
                iterator.remove();
                break;
            }
        }
        getServletContext().setAttribute("students", students);
        response.sendRedirect("list-students");
    }
}

