package ru.job4j.tdd;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class TeslaGeneratorTest {

    @Test(expected = NoSuchElementException.class)
    public void whenMoreMapKeysThanPatternKeysThenThrowException() throws NoSuchElementException {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr");
        map.put("subject", "You");
        map.put("subjectName", "Fedor");
        String pattern = "I am a ${name}, Who are ${subject}?";
        new TeslaGenerator().produce(pattern, map);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenMorePatternKeysThanMapKeysThenThrowException() throws NoSuchElementException {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr");
        map.put("subject", "You");
        String pattern = "I am a ${name}, Who are ${subject}? - I'm ${subjectName}";
        new TeslaGenerator().produce(pattern, map);
    }
}