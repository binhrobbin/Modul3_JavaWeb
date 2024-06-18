package vn.codegym.controller;

import vn.codegym.model.Student;
import vn.codegym.service.StudentServiceImlt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentServlet", urlPatterns = {"","/student"})
public class StudentServlet  extends HttpServlet {
    StudentServiceImlt studentServiceImlt = new StudentServiceImlt();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action =  req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreatePage(req,resp);
                break;
            case "edit":
                showEditPage(req,resp);
                break;
            case "delete":
                showDeletePage(req,resp);
                break;
            default:
                showList(req, resp);
        }

    }

    private void showDeletePage(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = studentServiceImlt.findById(id);
        studentServiceImlt.remove(id,student);
        try {
            resp.sendRedirect("/student");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showEditPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =Integer.parseInt(req.getParameter("id"));
        Student student = studentServiceImlt.findById(id);
        req.setAttribute("student",student);
        req.getRequestDispatcher("/student/edit.jsp").forward(req,resp);
    }

    private void showCreatePage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/student/create.jsp");
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("studentList", studentServiceImlt.findAll());
        req.getRequestDispatcher("/student/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action =  req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                createStudent(req,resp);
                break;
            case "edit":
                editStudent(req,resp);
                break;
            default:
                showList(req, resp);
        }

    }

    private void editStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt( req.getParameter("studentId"));
        String name =  req.getParameter("studentName");
        int gender = Integer.parseInt( req.getParameter("studentGender"));
        int point = Integer.parseInt( req.getParameter("studentPoint"));
        String image = req.getParameter("studentImage");
        studentServiceImlt.update(id, new Student(id,name,gender,point,image));
        resp.sendRedirect("/student");
    }

    private void createStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                int newId = Integer.parseInt( req.getParameter("studentId"));
                String newName =  req.getParameter("studentName");
                int newGender = Integer.parseInt( req.getParameter("studentGender"));
                int newPoint = Integer.parseInt( req.getParameter("studentPoint"));
                String newImage = req.getParameter("studentImage");
                studentServiceImlt.save(new Student(newId,newName,newGender,newPoint,newImage));
                resp.sendRedirect("/student");
    }
}
