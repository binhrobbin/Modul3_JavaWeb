package vn.codegym.controller;

import vn.codegym.model.Customer;
import vn.codegym.service.CustomerService;
import vn.codegym.service.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"","/customers"})
public class CustomerServlet extends HttpServlet {
    private final CustomerService<Customer> service = new CustomerServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action="";
        switch (action){
            case "create":
                createCustomer(req,resp);
                break;
            case "edit":
                updateCustomer(req,resp);
                break;
            case "delete":
                deleteCustomer(req,resp);
                break;
            case "search":
                searchCustomer(req,resp);
                break;
            default:
                break;
        }
    }

    private void searchCustomer(HttpServletRequest req, HttpServletResponse resp) {
        String nameSearch = req.getParameter("input");
        List<Customer> list = service.findAll();
        List<Customer> customers = new ArrayList<>();
        for (Customer customer:list){
            if (customer.getName().contains(nameSearch)){
                customers.add(customer);
            }
        }
        req.setAttribute("nameSearch",nameSearch);
        req.setAttribute("customers", customers);
        if (customers.isEmpty()) {
            req.setAttribute("message", "There's no name containing in the list");
        }
        RequestDispatcher dispatcher =req.getRequestDispatcher("customer/list.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteCustomer(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = service.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null) dispatcher = req.getRequestDispatcher("error-404.jsp");
        else {
            service.remove(id);
        }
        try {
            resp.sendRedirect("/customers");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateCustomer(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        Customer customer = service.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null) dispatcher = req.getRequestDispatcher("error-404.jsp");
        else {
            customer.setName(name);
            customer.setAddress(address);
            customer.setEmail(email);
            service.update(id,customer);
            req.setAttribute("customer",customer);
            req.setAttribute("message","Customer information was updated");
            dispatcher = req.getRequestDispatcher("customer/edit.jsp");
        }
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createCustomer(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        int id = (int) (Math.random() * 10000);

        service.save(new Customer(id,name,email,address));
        RequestDispatcher dispatcher = req.getRequestDispatcher("customer/create.jsp");
        req.setAttribute("message","New customer was created");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action="";
        switch (action){
            case "create":
                showCreateForm(req,resp);
                break;
            case "edit":
                showEditForm(req,resp);
                break;
            case "delete":
                showDeleteForm(req,resp);
                break;
            case "view":
                viewCustomer(req,resp);
                break;
            default:
                listCustomers(req,resp);
                break;
        }
    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.service.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("customer/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = service.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null) dispatcher= req.getRequestDispatcher("error-404.jsp");
        else {
            req.setAttribute("customer", customer);
            dispatcher = req.getRequestDispatcher("customer/delete.jsp");
        }
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
        int id =Integer.parseInt( req.getParameter("id"));
        Customer customer = service.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null){
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        }else {
            req.setAttribute("customer", customer);
            dispatcher = req.getRequestDispatcher("customer/edit.jsp");
        }
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("customer/create.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listCustomers(HttpServletRequest req, HttpServletResponse resp) {
        List<Customer> customers = service.findAll();
        req.setAttribute("customers", customers);
        RequestDispatcher dispatcher = req.getRequestDispatcher("customer/list.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
