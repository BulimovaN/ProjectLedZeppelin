package com.javarush.bulimova.quest;

import java.io.Serializable;
import java.util.List;

public class Quest implements Serializable {
    private String name;
    private List<Step> steps;
    private List<Integer> correctAnswers;

    public Quest(String name, List<Step> steps, List<Integer> correctAnswers) {
        this.name = name;
        this.steps = steps;
        this.correctAnswers = correctAnswers;
    }

    public String getName() {
        return name;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public List<Integer> getCorrectAnswers() {
        return correctAnswers;
    }

    public static class Step {
        private String question;
        private String answer1;
        private String answer2;

        public Step(String question, String answer1, String answer2) {
            this.question = question;
            this.answer1 = answer1;
            this.answer2 = answer2;
        }

        public String getQuestion() {
            return question;
        }

        public String getAnswer1() {
            return answer1;
        }

        public String getAnswer2() {
            return answer2;
        }
    }
}
