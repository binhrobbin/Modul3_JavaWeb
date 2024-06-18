package vn.codegym.controller;

import vn.codegym.model.User;
import vn.codegym.repository.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

@WebServlet(name = "UserServlet",urlPatterns = {"","/users"})
public class UserServlet extends HttpServlet {
    private final UserDAO userDAO = new UserDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action ="";
        switch (action) {
            case "create":
                showNewForm(req,resp);
                break;
            case "edit":
                showEditForm(req,resp);
                break;
            case "delete":
                deleteUser(req,resp);
                break;
            default:
                listUser(req,resp);
                break;
        }
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id =Integer.parseInt( req.getParameter("id"));
        userDAO.deleteUser(id);
        resp.sendRedirect("/users");
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int id =Integer.parseInt( req.getParameter("id"));
        User existingUser = userDAO.selectUser(id);
        req.setAttribute("user",existingUser);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("user/edit.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("user/create.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void listUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = userDAO.selectAllUsers();
        Set<String> setList = new HashSet<>();
        setList.add("");
        for (User user:userList){
            setList.add(user.getCountry());
        }
        System.out.println(setList);
        req.setAttribute("userList",userList);
        req.setAttribute("setList",setList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("user/list.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";
        try {
            switch (action) {
                case "create":
                    insertUser(req, resp);
                    break;
                case "edit":
                    updateUser(req, resp);
                    break;
                case "country":
                    countrySearch(req, resp);
                    break;
                case "arr":
                    arrangement(req, resp);
                    break;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void arrangement(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userListAll = userDAO.selectAllUsers();
        List<User> userList = new ArrayList<>();
        Set<String> setList = new HashSet<>();
        setList.add("");
        for (User user:userListAll){
            setList.add(user.getCountry());
        }
        String country = req.getParameter("countrySearch");
        for (User user : userListAll) {
            if (user.getCountry().equals(country)) {
                userList.add(user);
            }
        }
        if (userList.isEmpty()) userList.addAll(userListAll);
        Collections.sort(userList);
        req.setAttribute("userList",userList);
        req.setAttribute("setList",setList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("user/list.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void countrySearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userListAll = userDAO.selectAllUsers();
        List<User> userList = new ArrayList<>();
        Set<String> setList = new HashSet<>();
        setList.add("");
        for (User user:userListAll){
            setList.add(user.getCountry());
        }
        String country = req.getParameter("countrySearch");
            for (User user : userListAll) {
                if (user.getCountry().equals(country)) {
                    userList.add(user);
                }
            }
        if (userList.isEmpty()) userList.addAll(userListAll);
        req.setAttribute("userList",userList);
        req.setAttribute("setList",setList);
        req.setAttribute("search",country);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("user/list.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt( req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        User user = new User(id,name,email,country);
        userDAO.updateUser(user);
        req.setAttribute("message","User information was updated");
        req.setAttribute("user",user);
        RequestDispatcher dispatcher = req.getRequestDispatcher("user/edit.jsp");
        dispatcher.include(req, resp);
    }

    private void insertUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        userDAO.insertUser(new User(name,email,country));
        RequestDispatcher dispatcher = req.getRequestDispatcher("user/create.jsp");
        req.setAttribute("message","New user was created");
        dispatcher.include(req,resp);
    }
}
