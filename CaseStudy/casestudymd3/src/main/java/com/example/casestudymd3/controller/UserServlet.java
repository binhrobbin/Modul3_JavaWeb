package com.example.casestudymd3.controller;

import com.example.casestudymd3.Filter.LogInFilter;
import com.example.casestudymd3.model.User;
import com.example.casestudymd3.repository.UserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "userServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private final UserRepositoryImpl userRepository = new UserRepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreatePage(req, resp);
                break;
            case "edit":
                LogInFilter.checkLogIn(req,resp);
                showEditPage(req, resp);
                break;
            case "delete":
                LogInFilter.checkLogIn(req,resp);
                deleteUser(req, resp);
                break;
            case "back":
                LogInFilter.checkLogIn(req,resp);
                backAdmin(req, resp);
                break;
            default:
                LogInFilter.checkLogIn(req,resp);
                showList(req, resp);
        }
    }

    private void backAdmin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user= userRepository.findById((int)session.getAttribute("idUser"));
        req.setAttribute("username", user.getUsername());
        req.getRequestDispatcher("/users/admin.jsp").forward(req,resp);
    }

    private void showEditPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = userRepository.findById(id);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/users/edit.jsp").forward(req, resp);
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        userRepository.remove(id);
        resp.sendRedirect("user");
    }


    private void showCreatePage(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String check = req.getParameter("check");
            req.setAttribute("check", check);
            req.getRequestDispatcher("/users/create.jsp").forward(req, resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        Integer userIdLogin = (Integer) session.getAttribute("idUser");
        System.out.println(userIdLogin);

        req.setAttribute("userList", userRepository.findAll());
        req.getRequestDispatcher("/users/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LogInFilter.checkLogIn(req,resp);
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createUser(req, resp);
                break;
            case "edit":
                editUser(req, resp);
                break;
            case "delete":
                messageDelete(req, resp);
                break;
            default:
//                showList(req, resp);
        }
    }

    private void messageDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String username = userRepository.findById(id).getUsername();
        req.setAttribute("username", username);
        req.setAttribute("id", id);
        req.setAttribute("userList", userRepository.findAll());
        req.getRequestDispatcher("/users/list.jsp").forward(req, resp);
    }

    private void editUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int money = Integer.parseInt(req.getParameter("money"));
        String role = req.getParameter("role");
        String image = req.getParameter("image");
        User user = new User(id, name, username, password, money, role, image);
        try {
            userRepository.update(id, user);
            req.setAttribute("message", "Edit success");
            req.setAttribute("user", user);
            req.getRequestDispatcher("/users/edit.jsp").forward(req, resp);
        } catch (RuntimeException e) {
            req.setAttribute("message1", "(username already exist!)");
            req.setAttribute("user", user);
            req.getRequestDispatcher("/users/edit.jsp").forward(req, resp);
        }
    }

    private void createUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String check = req.getParameter("check");
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String image = req.getParameter("image");
        User user = new User(name, username, password, image);
        try {
            userRepository.save(user);
            req.setAttribute("message", "Create success!");
            req.setAttribute("check", check);
            req.getRequestDispatcher("/users/create.jsp").forward(req, resp);
//            resp.sendRedirect("/users/create.jsp");
        } catch (RuntimeException e) {
            if (check != null) req.setAttribute("check", check);
            req.setAttribute("message1", "(username already exist!)");
            req.setAttribute("user", user);
            req.getRequestDispatcher("/users/create.jsp").forward(req, resp);
//            resp.sendRedirect("/users/create.jsp");
        }
    }
}
