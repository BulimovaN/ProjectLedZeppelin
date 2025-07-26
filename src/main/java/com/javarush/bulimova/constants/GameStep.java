package com.javarush.bulimova.constants;

public enum GameStep {
    STEP_ONE("1"),
    STEP_TWO("2"),
    STEP_THREE("3");

    private final String value;

    GameStep(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static GameStep fromString(String s) {
        for (GameStep step : GameStep.values()) {
            if (step.value.equals(s)) return step;
        }
        return null;
    }
}
