package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        User user1 = new User("Roman", 0, new GregorianCalendar(1993, 12, 21));
        User user2 = new User("Roman", 0, new GregorianCalendar(1993, 12, 21));

        Map<User, Object> map = new HashMap<>();
        map.put(user1, 5);
        map.put(user2, 6);

        for (Map.Entry<User, Object> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
    }
}
