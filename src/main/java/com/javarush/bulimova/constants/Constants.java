package com.javarush.bulimova.constants;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Constants {

    public static final String questName = "Контакт с НЛО";

    public static final String questionOne = "Ты потерял память. Принять вызов НЛО?";
    public static final String answerOneQuestionOne = "Принять вызов";
    public static final String answerTwoQuestionOne = "Отклонить вызов";

    public static final String questionTwo = "Ты принял вызов. Поднимаешься на мостик к капитану?";
    public static final String answerOneQuestionTwo = "Подняться на мостик";
    public static final String answerTwoQuestionTwo = "Отказаться подниматься на мостик";

    public static final String questionThree = "Ты поднялся на мостик. Ты кто?";
    public static final String answerOneQuestionThree = "Рассказать правду о себе";
    public static final String answerTwoQuestionThree = "Солгать о себе";

    public static final String win = "Тебя вернули домой. Победа";

    public static final String loss = "Ты отклонил вызов. Поражение";

    public static final Map<String, List<String>> questionsMap = new LinkedHashMap<>();

    static {
        questionsMap.put(questionOne, Arrays.asList(answerOneQuestionOne, answerTwoQuestionOne));
        questionsMap.put(questionTwo, Arrays.asList(answerOneQuestionTwo, answerTwoQuestionTwo));
        questionsMap.put(questionThree, Arrays.asList(answerOneQuestionThree, answerTwoQuestionThree));

    }


}
