package com.example.casestudymd3.Filter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogInFilter {
    public static void checkLogIn(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        if (!((boolean) session.getAttribute("isLogIn"))) {
//            resp.sendRedirect("/users/login.jsp");
            req.getRequestDispatcher("/users/login.jsp").forward(req,resp);
        }
    }
}
