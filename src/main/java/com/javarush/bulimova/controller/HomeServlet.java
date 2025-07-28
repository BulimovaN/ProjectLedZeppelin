package com.javarush.bulimova.controller;

import com.javarush.bulimova.quest.Quest;
import com.javarush.bulimova.quest.QuestStorage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet({"", "/home"})
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestStorage.initDemoQuest();
        req.setAttribute("quests", QuestStorage.getQuests());
        getServletContext().getRequestDispatcher("/welcome.jsp").forward(req, resp);
    }
}
