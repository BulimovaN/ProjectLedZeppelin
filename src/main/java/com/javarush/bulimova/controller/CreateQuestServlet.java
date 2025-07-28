package com.javarush.bulimova.controller;

import com.javarush.bulimova.quest.Quest;
import com.javarush.bulimova.quest.QuestStorage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet({"/create"})
public class CreateQuestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");

        List<Quest.Step> steps = new ArrayList<>();
        steps.add(new Quest.Step(req.getParameter("q1"), req.getParameter("a1"), req.getParameter("a2")));
        steps.add(new Quest.Step(req.getParameter("q2"), req.getParameter("b1"), req.getParameter("b2")));
        steps.add(new Quest.Step(req.getParameter("q3"), req.getParameter("c1"), req.getParameter("c2")));

        List<Integer> correct = new ArrayList<>();
        String[] correctParams = {"correct1", "correct2", "correct3"};

        for (String param : correctParams) {
            String val = req.getParameter(param);
            if (val != null && !val.isEmpty()) {
                try {
                    int index = Integer.parseInt(val) - 1;
                    if (index != 0 && index != 1) {
                        throw new ServletException("Параметр " + param + " должен быть 1 или 2");
                    }
                    correct.add(index);
                } catch (NumberFormatException e) {
                    throw new ServletException("Неверный формат числа для параметра: " + param, e);
                }
            } else {
                throw new ServletException("Отсутствует параметр: " + param);
            }
        }

        Quest quest = new Quest(name, steps, correct);
        QuestStorage.addQuest(quest);

        resp.sendRedirect("home");
    }
}
