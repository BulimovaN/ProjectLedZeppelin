package com.javarush.bulimova.controller;

import com.javarush.bulimova.quest.Quest;
import com.javarush.bulimova.quest.QuestStorage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet({"/start"})
public class StartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        String questIndexParam = req.getParameter("questIndex");

        if (questIndexParam == null) {
            resp.sendRedirect("home");
            return;
        }


        int selectedQuestIndex = Integer.parseInt(questIndexParam);
        List<Quest> quests = QuestStorage.getQuests();
        Quest quest = quests.get(selectedQuestIndex);

        Integer savedQuestIndex = (Integer) session.getAttribute("questIndex");
        Integer savedStepIndex = (Integer) session.getAttribute("stepIndex");

        int stepIndex;
        if (savedQuestIndex != null && savedQuestIndex == selectedQuestIndex && savedStepIndex != null) {
            stepIndex = savedStepIndex;
        } else {
            stepIndex = 0;
            session.setAttribute("questIndex", selectedQuestIndex);
            session.setAttribute("questName", quest.getName());
        }


        session.setAttribute("stepIndex", stepIndex);
        session.setAttribute("stepNumber", stepIndex + 1);

        Quest.Step step = quest.getSteps().get(stepIndex);
        req.setAttribute("question", step.getQuestion());
        req.setAttribute("answer1", step.getAnswer1());
        req.setAttribute("answer2", step.getAnswer2());

        getServletContext().getRequestDispatcher("/start.jsp").forward(req, resp);
    }
    }

