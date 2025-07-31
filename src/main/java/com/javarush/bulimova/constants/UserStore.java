package com.javarush.bulimova.constants;

import java.util.HashMap;
import java.util.Map;

public class UserStore {
    private static final Map<String, String> users = new HashMap<>();

    static {
        users.put("admin", "12345");
        users.put("user", "11111");
    }

    public static boolean isValid(String username, String password) {
        return password.equals(users.get(username));
    }
    public static boolean register(String username, String password) {
        if (users.containsKey(username)) {
            return false;
        }
        users.put(username, password);
        return true;
    }
}
