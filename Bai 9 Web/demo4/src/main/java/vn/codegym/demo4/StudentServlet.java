package vn.codegym.demo4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentServlet", urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Da vao doGet cua StudentServlet");
        resp.sendRedirect("login.jsp"); // chuyển hướng ko có data
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Da vao doPost");
        String userName = req.getParameter("txt-use");
        String pass = req.getParameter("txt-pass");
        System.out.println(userName+"-"+pass);
        //chuyển hướng có data
        req.setAttribute("studentName",userName);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
