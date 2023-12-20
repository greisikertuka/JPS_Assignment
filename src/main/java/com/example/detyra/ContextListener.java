package com.example.detyra;

import com.example.detyra.model.Student;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.List;

@WebListener
public class ContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event) {
        List<Student> students = new ArrayList<>();
        event.getServletContext().setAttribute("students", students);
        event.getServletContext().setAttribute("student", new Student("","",""));
    }
}
