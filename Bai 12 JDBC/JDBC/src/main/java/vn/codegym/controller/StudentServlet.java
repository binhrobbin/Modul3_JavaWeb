package vn.codegym.controller;

import vn.codegym.model.Student;
import vn.codegym.service.IStudentService;
import vn.codegym.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "studentServlet", urlPatterns = {"", "/student"})
public class StudentServlet extends HttpServlet {
    private IStudentService service = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreatePage(req, resp);
                break;
            case "edit":
                break;
            default:
                //list
                showList(req, resp);
        }
    }

    private void showCreatePage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/student/create.jsp");
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("studentList", service.finAll());
        req.getRequestDispatcher("/student/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createStudent(req, resp);
                break;
            case "edit":
                break;
            default:
                //list
                showList(req, resp);
        }

    }

    private void createStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("studentId"));
        String name = req.getParameter("studentName");
        int gender = Integer.parseInt(req.getParameter("studentGender"));
        int point = Integer.parseInt(req.getParameter("studentPoint"));
        String image = req.getParameter("studentImage");

        Student student = new Student(id, name, gender, point, image);
        service.save(student);

//        showList(req, resp);
        resp.sendRedirect("/student");
    }
}
