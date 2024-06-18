package com.example.casestudymd3.controller;

import com.example.casestudymd3.Filter.LogInFilter;
import com.example.casestudymd3.model.Dog;
import com.example.casestudymd3.service.DogServiceImpl;
import com.example.casestudymd3.service.IObjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(name = "dogServlet", urlPatterns = {"/dog"})
public class DogServlet extends HttpServlet {
    private DogServiceImpl service = new DogServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                LogInFilter.checkLogIn(req,resp);
                showCreatePage(req, resp);
                break;
            case "backhome":
                LogInFilter.checkLogIn(req,resp);
                dogBackHome(req, resp);
                break;
            case "backlist":
                dogBackList(req, resp);
                break;
            case "edit":
                LogInFilter.checkLogIn(req,resp);
                showEditPage(req, resp);
                break;
            case "delete":
                LogInFilter.checkLogIn(req,resp);
                deleteDog(req, resp);
                break;
            case "typeSearch":
                showType(req, resp);
                break;
            case "colorSearch":
                showColor(req, resp);
                break;
            default:
                LogInFilter.checkLogIn(req,resp);
                //list
                showList(req, resp);
        }
    }
    private void dogBackHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/home");
    }
    private void dogBackList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/dog");
    }
    private void showCreatePage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/dogs/create.jsp");
    }
    private void showEditPage(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int editID = Integer.parseInt(req.getParameter("editID"));
        req.setAttribute("editID", editID);
        Dog editDog = service.findById(editID);
        req.setAttribute("editDog", editDog);
        req.getRequestDispatcher("/dogs/edit.jsp").forward(req, resp);
        resp.sendRedirect("/dogs/edit.jsp");
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("dogList", service.findAll());
        req.getRequestDispatcher("/dogs/list.jsp").forward(req, resp);
    }

    private void createDog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int dog_id = Integer.parseInt(req.getParameter("dogID"));
        String name = req.getParameter("dogName");
        String type = req.getParameter("dogType");
        String color = req.getParameter("dogColor");
        String image = req.getParameter("dogImage");
        int price = Integer.parseInt(req.getParameter("dogPrice"));
        int quantity = Integer.parseInt(req.getParameter("dogQuantity"));

        Dog dog = new Dog(dog_id, name, type, color, image, price, quantity);
        service.save(dog);

//        showList(req, resp);
        resp.sendRedirect("/dog");
    }
    private void editDog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int dog_id = Integer.parseInt(req.getParameter("editID"));
        String name = req.getParameter("editName");
        String type = req.getParameter("editType");
        String color = req.getParameter("editColor");
        String image = req.getParameter("editImage");
        int price = Integer.parseInt(req.getParameter("editPrice"));
        int quantity = Integer.parseInt(req.getParameter("editQuantity"));

        Dog dog = new Dog(dog_id, name, type, color, image, price, quantity);
        service.update(dog_id, dog);

//        showList(req, resp);
        resp.sendRedirect("/dog");
    }
    private void deleteDog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int deleteID = Integer.parseInt(req.getParameter("deleteID"));
        service.remove(deleteID);
        resp.sendRedirect("/dog");
    }
    private void nameSearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameSearch = req.getParameter("search");
        List<Dog> dogListAll = service.findAll();
        List<Dog> dogList = new ArrayList<>();
        for (Dog dog:dogListAll){
            if (dog.getName().contains(nameSearch)) dogList.add(dog);
        }
        if (dogList.isEmpty()) dogList.addAll(dogListAll);
        Set<String> typeList = new HashSet<>();
        Set<String> colorList = new HashSet<>();
        for (Dog dog:dogListAll){
            typeList.add(dog.getType());
            colorList.add(dog.getColor());
        }
        typeList.add("..Show All");
        colorList.add("..Show All");
        req.setAttribute("dogList", dogList);
        req.setAttribute("nameSearch", nameSearch);
        req.setAttribute("typeList", typeList);
        req.setAttribute("colorList", colorList);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    private void showColor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String color= req.getParameter("color");
        List<Dog> dogListAll = service.findAll();
        List<Dog> dogList = new ArrayList<>();
        for (Dog dog:dogListAll){
            if (dog.getColor().equals(color)) dogList.add(dog);
        }
        if (dogList.isEmpty()) dogList.addAll(dogListAll);
        Set<String> typeList = new HashSet<>();
        Set<String> colorList = new HashSet<>();
        for (Dog dog:dogListAll){
            typeList.add(dog.getType());
            colorList.add(dog.getColor());
        }
        typeList.add("..Show All");
        colorList.add("..Show All");
        req.setAttribute("dogList", dogList);
        req.setAttribute("typeList", typeList);
        req.setAttribute("colorList", colorList);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    private void showType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type= req.getParameter("type");
        List<Dog> dogListAll = service.findAll();
        List<Dog> dogList = new ArrayList<>();
        for (Dog dog:dogListAll){
            if (dog.getType().equals(type)) dogList.add(dog);
        }
        if (dogList.isEmpty()) dogList.addAll(dogListAll);
        Set<String> typeList = new HashSet<>();
        Set<String> colorList = new HashSet<>();
        for (Dog dog:dogListAll){
            typeList.add(dog.getType());
            colorList.add(dog.getColor());
        }
        typeList.add("..Show All");
        colorList.add("..Show All");
        req.setAttribute("dogList", dogList);
        req.setAttribute("typeList", typeList);
        req.setAttribute("colorList", colorList);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                LogInFilter.checkLogIn(req,resp);
                createDog(req, resp);
                break;
            case "edit":
                LogInFilter.checkLogIn(req,resp);
                editDog(req, resp);
                break;
            case "nameSearch":
                nameSearch(req, resp);
                break;
            default:
                //list
//                showList(req, resp);
        }
    }
}
