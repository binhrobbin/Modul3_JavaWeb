package com.example.casestudymd3.controller;

import com.example.casestudymd3.model.Booked;
import com.example.casestudymd3.model.Dog;
import com.example.casestudymd3.service.BookedServiceImpl;
import com.example.casestudymd3.service.DogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@WebServlet(name = "bookedServlet", urlPatterns = "/booked-servlet")

public class BookedServlet extends HttpServlet {
    private BookedServiceImpl serviceBooked = new BookedServiceImpl();
    private DogServiceImpl serviceDog = new DogServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createBooked(req, resp);
                break;
            case "edit":

                break;
            case "delete":
                deleteBooked(req, resp);
                break;
            default:
                //list
                showListByBooking(req, resp);
        }
    }
    private void bookedBack(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/home");
    }
    private void deleteBooked(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int deleteBookedID = Integer.parseInt(req.getParameter("deleteBookedID"));
        serviceBooked.remove(deleteBookedID);
        showListByBooking(req,resp);
//        resp.sendRedirect("/index.jsp");
    }
    private void showListByBooking(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Map<Integer,Dog> dogMap = new HashMap<>();
        Dog bookedDog = null;
        Dog dog = null;
        List<Booked> bookedList = serviceBooked.findAll();
        List<Booked> bookedListByID = new ArrayList<>();
        for (Booked booked: bookedList) {
            if(booked.getBooking_id() == Integer.parseInt(req.getParameter("bookingID"))) {
                bookedListByID.add(booked);
            }
        }
        for (Booked booked: bookedListByID) {
            dog = serviceDog.findById(booked.getDog_id());
            bookedDog = new Dog(dog.getName(), dog.getPrice(), 1);
            dogMap.put(booked.getId(),bookedDog);
        }
        Set<Integer> keySet = dogMap.keySet();
        session.setAttribute("dogMap", dogMap);
        session.setAttribute("keySet", keySet);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
//    private void showListAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        Map<Integer,Dog> dogMap = new HashMap<>();
//        Dog bookedDog = null;
//        Dog dog = null;
//        List<Booked> bookedList = serviceBooked.findAll();
//        for (Booked booked: bookedList) {
//            dog = serviceDog.findById(booked.getDog_id());
//            bookedDog = new Dog(dog.getName(), dog.getPrice(), 1);
//            dogMap.put(booked.getId(),bookedDog);
//        }
//        Set<Integer> keySet = dogMap.keySet();
//        session.setAttribute("dogMap", dogMap);
//        session.setAttribute("keySet", keySet);
//        req.getRequestDispatcher("/index.jsp").forward(req, resp);
//    }
    private void createBooked(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String booked_day = "0";
        int booking_id = Integer.parseInt(req.getParameter("bookingID"));
        int dog_id = Integer.parseInt(req.getParameter("dogBookedID"));
        Booked booked = new Booked(booked_day,booking_id, dog_id);
        serviceBooked.save(booked);
        showListByBooking(req, resp);
//        resp.sendRedirect("/home");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
