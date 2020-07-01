package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (row < data.length && column == data[row].length) {
            if (data.length == 1 && data[row].length == 0) {
                return false;
            }
            column = 0;
            row++;
        }
        return row != data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }

    public static void main(String[] args) {
        int[][] array = new int[3][4];
        array[0] = new int[]{5, 7, 3, 17};
        array[1] = new int[]{7, 1, 12};
        array[2] = new int[]{8, 1, 2, 3};

        for (int i = 0; i < array.length; i++) {  // идём по строкам
            for (int j = 0; j < array[i].length; j++) { // идём по столбцам
                System.out.print(" " + array[i][j] + " "); //вывод элемента
            }
            System.out.println(); // перенос строки ради визуального сохранения табличной формы
        }

        int[][] in = {
                {}
        };
        for (int i = 0; i < in.length; i++) {  // идём по строкам
            for (int j = 0; j < in[i].length; j++) { // идём по столбцам
                System.out.print(" " + in[i][j] + " "); //вывод элемента
            }
            System.out.println(); // перенос строки ради визуального сохранения табличной формы
        }
    }
}
