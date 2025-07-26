package com.javarush.bulimova.controller;

import com.javarush.bulimova.constants.Constants;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet({"", "/home", "/list-user", "/edit-user"})
public class Front extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET: " + req.getRequestURI()); // для отладки
        HttpSession currentSession = req.getSession(true);
        getServletContext().getRequestDispatcher("/welcome.jsp").forward(req, resp);

    }

}
