package com.javarush.bulimova.controller;

import com.javarush.bulimova.constants.UserStore;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (UserStore.register(username, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", username);
            resp.sendRedirect("/");
        } else {
            req.setAttribute("error", "Пользователь уже существует");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }
}
