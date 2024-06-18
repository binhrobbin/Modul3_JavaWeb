package vn.codegym.th2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("user-name");
        String pass= req.getParameter("pass-word");

        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        if ("admin".equals(username) && ("admin".equals(pass))){
            writer.println("<h1>welcome "+username+" to my website</h1>");
        }else{ writer.println("<h1>Login Error</h1>");}
        writer.println("</html>");
    }
}
