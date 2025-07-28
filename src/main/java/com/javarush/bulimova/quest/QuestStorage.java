package com.javarush.bulimova.quest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class QuestStorage {
    private static final List<Quest> quests = new ArrayList<>();

    public static void addQuest(Quest quest) {
        quests.add(quest);
    }

    public static List<Quest> getQuests() {
        return Collections.unmodifiableList(quests);
    }

    public static Quest findByName(String name) {
        return quests.stream()
                .filter(q -> q.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public static void initDemoQuest() {
        if (quests.isEmpty()) {
            Quest demo = DemoQuestFactory.createNloQuest();
            addQuest(demo);
        }
    }

}
