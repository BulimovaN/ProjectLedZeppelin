package com.javarush.bulimova.controller;

import com.javarush.bulimova.constants.Constants;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet({"/start"})
public class Start extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();


        if (session.getAttribute("questName") == null) {
            session.setAttribute("questName", Constants.questName);
        }

        String step = (String) session.getAttribute("step");
        if (step == null || step.isEmpty()) {
            step = "1";
            session.setAttribute("step", step);
        }

        switch (step) {
            case "1":
                req.setAttribute("question", Constants.questionOne);
                req.setAttribute("answer1", Constants.answerOneQuestionOne);
                req.setAttribute("answer2", Constants.answerTwoQuestionOne);
                break;

            case "2":
                req.setAttribute("question", Constants.questionTwo);
                req.setAttribute("answer1", Constants.answerOneQuestionTwo);
                req.setAttribute("answer2", Constants.answerTwoQuestionTwo);
                break;

            case "3":
                req.setAttribute("question", Constants.questionThree);
                req.setAttribute("answer1", Constants.answerOneQuestionThree);
                req.setAttribute("answer2", Constants.answerTwoQuestionThree);
                break;


            default:
                step = "1";
                session.setAttribute("step", step);
                req.setAttribute("question", Constants.questionOne);
                req.setAttribute("answer1", Constants.answerOneQuestionOne);
                req.setAttribute("answer2", Constants.answerTwoQuestionOne);
        }
        req.setAttribute("step", step);

        getServletContext().getRequestDispatcher("/start.jsp").forward(req, resp);
    }
}
