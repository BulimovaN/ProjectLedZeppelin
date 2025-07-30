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

@WebServlet({"/next"})
public class NextServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        Integer questIndex = (Integer) session.getAttribute("questIndex");
        Integer stepIndex = (Integer) session.getAttribute("stepIndex");

        if (questIndex == null || stepIndex == null) {
            resp.sendRedirect("home");
            return;
        }

        List<Quest> quests = QuestStorage.getQuests();
        Quest quest = quests.get(questIndex);

        int answer = Integer.parseInt(req.getParameter("answer")) - 1;

        if (quest.getCorrectAnswers().get(stepIndex) != answer) {
            clearGameSession(session);
            req.setAttribute("message", "Поражение! Неправильный ответ.");
            getServletContext().getRequestDispatcher("/end.jsp").forward(req, resp);
            return;
        }


        stepIndex++;

        if (stepIndex >= quest.getSteps().size()) {
            clearGameSession(session);
            req.setAttribute("message", "Поздравляем! Вы прошли квест: " + quest.getName());
            getServletContext().getRequestDispatcher("/end.jsp").forward(req, resp);
        } else {
            session.setAttribute("stepIndex", stepIndex);
            session.setAttribute("stepNumber", stepIndex + 1);

            Quest.Step step = quest.getSteps().get(stepIndex);
            req.setAttribute("question", step.getQuestion());
            req.setAttribute("answer1", step.getAnswer1());
            req.setAttribute("answer2", step.getAnswer2());
            getServletContext().getRequestDispatcher("/start.jsp").forward(req, resp);
        }
    }
    private void clearGameSession(HttpSession session) {
        session.removeAttribute("questIndex");
        session.removeAttribute("stepIndex");
        session.removeAttribute("stepNumber");
        session.removeAttribute("questName");
    }
}
