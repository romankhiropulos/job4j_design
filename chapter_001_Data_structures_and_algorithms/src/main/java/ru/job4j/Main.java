package ru.job4j;

import java.util.*;

public class Main {

    public static void processIterator(String[] array) {
        // write your code here
        List<String> strings = new ArrayList<>(List.of(array));
        ListIterator<String> listIterator = strings.listIterator();
        String row;
        while (listIterator.hasNext()) {
            row = listIterator.next();
            if (row.charAt(0) == 'J') {
                listIterator.set(row.substring(1));
            } else {
                listIterator.remove();
            }
        }
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        processIterator(scanner.nextLine().split(" "));
    }
}
