package com.example.casestudymd3.controller;

import com.example.casestudymd3.model.Dog;
import com.example.casestudymd3.service.DogServiceImpl;
import com.example.casestudymd3.service.IObjectService;

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

@WebServlet(name = "homeServlet", urlPatterns = {"", "/home"})
public class HomeServlet extends HttpServlet {
    private DogServiceImpl service = new DogServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showListHome(req, resp);
    }
    private void showListHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dog> dogList = service.findAll();
        Set<String> typeList = new HashSet<>();
        Set<String> colorList = new HashSet<>();
        for (Dog dog:dogList){
            typeList.add(dog.getType());
            colorList.add(dog.getColor());
        }
        req.setAttribute("dogList", dogList);
        req.setAttribute("typeList", typeList);
        req.setAttribute("colorList", colorList);
        req.setAttribute("initBookingID", 0);
        req.setAttribute("isDisabled", "");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
        HttpSession session = req.getSession();
        session.setAttribute("isLogIn",false);
//        req.setAttribute("dogList", service.findAll());
//        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("idUser",null);
        session.setAttribute("role",null);
        session.setAttribute("userLog", null);
        session.setAttribute("newBookingID", null);
        session.setAttribute("bookList", null);
        session.setAttribute("isLogIn",false);
        session.setAttribute("bookingList", null);
        resp.sendRedirect("/home");
    }
}
