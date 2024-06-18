package vn.codegym.controller;

import vn.codegym.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet (name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    public static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer("Văn A",LocalDate.of(1999,2,13) ,"aaa","111.jpg"));
        customerList.add(new Customer("Văn B",LocalDate.of(2000,2,13) ,"bbb","222.jpg"));
        customerList.add(new Customer("Văn C",LocalDate.of(2005,2,13) ,"ccc","333.jpg"));
        customerList.add(new Customer("Văn D",LocalDate.of(1994,2,13) ,"ddd","444.jpg"));
        customerList.add(new Customer("Văn E",LocalDate.of(1997,2,13) ,"eee","555.jpg"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("customerList",customerList);
        req.getRequestDispatcher("/customer/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
