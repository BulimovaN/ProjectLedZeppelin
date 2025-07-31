package com.javarush.bulimova.quest;

import java.util.Arrays;
import java.util.List;

public class DemoQuestFactory {
    public static Quest createNloQuest() {
        List<Quest.Step> steps = Arrays.asList(
                new Quest.Step("Ты видишь НЛО. Что делать?", "Подойти ближе", "Убежать"),
                new Quest.Step("Инопланетянин протягивает руку. Что делать?", "Пожать руку", "Спрятаться"),
                new Quest.Step("Он предлагает полететь с ним. Что делать?", "Согласиться", "Отказаться")
        );
        List<Integer> correct = Arrays.asList(0, 0, 0);
        return new Quest("Приключение с НЛО \uD83D\uDC7D", steps, correct);
    }
}
