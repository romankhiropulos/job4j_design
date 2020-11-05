package ru.job4j.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        byte weight = 80;
        short height = 185;
        int age = 33;
        long students = 1500;
        char courses = '3';
        float experience = 10.2f;
        double level = 2222222222L;
        boolean javaDeveloper = true;

        LOG.debug("{}User info name : {}, age : {},{}weight : {}, height : {}, students : {}, {}"
                       .concat("courses : {}, experience : {}, level : {}, javaDeveloper : {}{}"), "\n",
                name, age, "\n", weight, height, students, "\n", courses, experience, level, javaDeveloper, "\n");

        System.out.printf("User info name : %s, age : %s%n", name, age);
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
    }
}
