package com.example.casestudymd3.controller;

import com.example.casestudymd3.model.Booked;
import com.example.casestudymd3.model.Booking;
import com.example.casestudymd3.model.Dog;
import com.example.casestudymd3.model.User;
import com.example.casestudymd3.service.BookedServiceImpl;
import com.example.casestudymd3.service.BookingServiceImpl;
import com.example.casestudymd3.service.DogServiceImpl;
import com.example.casestudymd3.service.UserServiceImpl;
import com.mysql.cj.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@WebServlet(name = "bookingServlet", urlPatterns = "/booking-servlet")

public class BookingServlet extends HttpServlet {
    private BookedServiceImpl serviceBooked = new BookedServiceImpl();
    private BookingServiceImpl service = new BookingServiceImpl();
    private DogServiceImpl serviceDog = new DogServiceImpl();
    private UserServiceImpl serviceUser = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createBooking(req, resp);
                break;
            case "back":
                bookingBack(req, resp);
                break;
            case "delete":
                deleteBooking(req, resp);
                break;
            case "view":
                showIndexListByBooking(req, resp);
//                session.setAttribute("dogMapBooking", null);
//                session.setAttribute("keySetBooking", null);
//                session.setAttribute("bookingList", null);
                break;
            default:
                //list
                showList(req, resp);
        }
    }
    private void bookingBack(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/home");
    }
    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        session.setAttribute("bookingList", service.findAll());
        req.getRequestDispatcher("/bookings/listBooking.jsp").forward(req, resp);
    }
    private void createBooking(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        int user_id = Integer.parseInt(req.getParameter("userLogID"));
        LocalDate today = LocalDate.now();
        String booking_day = "" + today;
        Booking booking = new Booking(user_id, booking_day);
        service.save(booking);
        int booking_id = service.findAll().get(service.findAll().size()-1).getId();
        session.setAttribute("initBookingID", booking_id);
        session.setAttribute("newBookingID", booking_id);
        session.setAttribute("isDisabled", "disabled");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
    private void showIndexListByBooking(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Map<Integer,Dog> dogMap = new HashMap<>();
        Dog bookedDog = null;
        Dog dog = null;
        List<Booked> bookedList = serviceBooked.findAll();
        List<Booked> bookedListByID = new ArrayList<>();
        int viewBookingId = Integer.parseInt(req.getParameter("viewBookingID"));
        for (Booked booked: bookedList) {
            if(booked.getBooking_id() == viewBookingId) {
                bookedListByID.add(booked);
            }
        }
        for (Booked booked: bookedListByID) {
            dog = serviceDog.findById(booked.getDog_id());
            bookedDog = new Dog(dog.getName(), dog.getPrice(), 1);
            dogMap.put(booked.getId(),bookedDog);
        }
        Set<Integer> keySet = dogMap.keySet();
        req.setAttribute("dogMapBooking", dogMap);
        req.setAttribute("keySetBooking", keySet);
        req.setAttribute("bookingList", service.findAll());
        req.setAttribute("viewBookingId", viewBookingId);
        req.getRequestDispatcher("/bookings/listBooking.jsp").forward(req, resp);
    }
    private void deleteBooking(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int deleteID = Integer.parseInt(req.getParameter("deleteBookingID"));
        int deleteID = Integer.parseInt(req.getParameter("bookingID"));
        service.remove(deleteID);
//        resp.sendRedirect("/booking-servlet");
        HttpSession session = req.getSession();
        session.setAttribute("newBookingID", null);
        session.setAttribute("bookList", null);
        session.setAttribute("bookingList", null);
        session.setAttribute("isDisabled", "");
        session.setAttribute("initBookingID", 0);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
//    private void viewBooking(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession(true);
//        int viewBookingID = Integer.parseInt(req.getParameter("viewBookingID"));
//        session.setAttribute("viewBookingID", viewBookingID);
//        resp.sendRedirect("/");
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
