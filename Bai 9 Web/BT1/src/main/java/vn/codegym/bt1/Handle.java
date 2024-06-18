package vn.codegym.bt1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Handle", value = "/handle")
public class Handle extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String desc = req.getParameter("des");
        float price =Float.parseFloat( req.getParameter("price"));
        float percent =Float.parseFloat( req.getParameter("dis"));
    // chuyển hướng có data

        req.setAttribute("desc",desc);
        req.setAttribute("price",price);
        req.setAttribute("percent",percent);
        req.getRequestDispatcher("result.jsp").forward(req,resp);
    }
}
