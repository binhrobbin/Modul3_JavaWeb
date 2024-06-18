package com.example.casestudymd3.controller;

import com.example.casestudymd3.model.Dog;
import com.example.casestudymd3.model.User;
import com.example.casestudymd3.repository.UserRepositoryImpl;
import com.example.casestudymd3.service.DogServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private final UserRepositoryImpl userRepository = new UserRepositoryImpl();
    private DogServiceImpl service = new DogServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       RequestDispatcher requestDispatcher = req.getRequestDispatcher("users/login.jsp");
       requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username =  req.getParameter("username");
        String password =  req.getParameter("password");
        List<User> userList = userRepository.findAll();
        boolean check = false;
        HttpSession session = req.getSession(true);
        User userLog = new User();
        for (User user:userList){
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                check=true;
                userLog = user;
                session.setAttribute("idUser", user.getId());
                session.setAttribute("userLog", userLog);
                session.setAttribute("role", user.getRole());
                session.setAttribute("isLogIn",true);
                break;
            }
        }
        if (check){
            if (session.getAttribute("role").equals("admin")){
                req.setAttribute("username",username);
                req.getRequestDispatcher("/users/admin.jsp").forward(req,resp);
            }
            else {
                List<Dog> dogList = service.findAll();
                Set<String> typeList = new HashSet<>();
                Set<String> colorList = new HashSet<>();
                for (Dog dog:dogList){
                    typeList.add(dog.getType());
                    colorList.add(dog.getColor());
                }
                session.setAttribute("dogList", dogList);
                session.setAttribute("typeList", typeList);
                session.setAttribute("colorList", colorList);
                resp.sendRedirect("/home");
            }
        }
        else {
            req.setAttribute("message", "wrong account or password");
            req.getRequestDispatcher("users/login.jsp").forward(req, resp);
//            resp.sendRedirect("/login");
        }
    }
}
