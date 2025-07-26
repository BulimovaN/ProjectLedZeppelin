package com.javarush.bulimova.controller;

import com.javarush.bulimova.constants.Constants;
import com.javarush.bulimova.constants.GameStep;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet({"/next"})
public class Next extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String stepParam = req.getParameter("step");
        GameStep step = GameStep.fromString(stepParam);
        String answer = req.getParameter("answer");

        session.setAttribute("lastStep", step);
        session.setAttribute("lastAnswer", answer);

        switch (step) {
            case STEP_ONE:
                if ("1".equals(answer)) {
                    session.setAttribute("step", GameStep.STEP_TWO.getValue());
                    req.setAttribute("question", Constants.questionTwo);
                    req.setAttribute("answer1", Constants.answerOneQuestionTwo);
                    req.setAttribute("answer2", Constants.answerTwoQuestionTwo);
                    req.setAttribute("step", "2");
                    getServletContext().getRequestDispatcher("/start.jsp").forward(req, resp);
                } else {
                    session.invalidate();
                    req.setAttribute("message", Constants.loss);
                    getServletContext().getRequestDispatcher("/end.jsp").forward(req, resp);
                }
                break;

            case STEP_TWO:
                if ("1".equals(answer)) {
                    session.setAttribute("step", GameStep.STEP_THREE.getValue());
                    req.setAttribute("question", Constants.questionThree);
                    req.setAttribute("answer1", Constants.answerOneQuestionThree);
                    req.setAttribute("answer2", Constants.answerTwoQuestionThree);
                    req.setAttribute("step", "3");
                    getServletContext().getRequestDispatcher("/start.jsp").forward(req, resp);
                } else {
                    session.invalidate();
                    req.setAttribute("message", Constants.loss);
                    getServletContext().getRequestDispatcher("/end.jsp").forward(req, resp);
                }
                break;

            case STEP_THREE:
                session.invalidate();
                req.setAttribute("message", Constants.win);
                getServletContext().getRequestDispatcher("/end.jsp").forward(req, resp);
                break;

            default:
                session.invalidate();
                resp.sendRedirect("/home");
        }
    }
}
