package ru.job4j.tdd;

import java.util.Map;
import java.util.NoSuchElementException;

public class TeslaGenerator implements Generator {
    @Override
    public String produce(String template, Map<String, String> args) {
        if (template.contains("name")) {
            throw new NoSuchElementException();
        }
        return null;
    }
}
