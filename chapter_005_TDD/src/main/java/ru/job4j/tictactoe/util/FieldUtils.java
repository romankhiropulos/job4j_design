package ru.job4j.tictactoe.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FieldUtils {
    public static List<int[]> getWinArrays() {
        return new ArrayList<>(
                Arrays.asList(
                        new int[]{0, 1, 2},
                        new int[]{3, 4, 5},
                        new int[]{6, 7, 8},
                        new int[]{0, 3, 6},
                        new int[]{1, 4, 7},
                        new int[]{2, 5, 8},
                        new int[]{0, 4, 8},
                        new int[]{2, 4, 6}
                )
        );
    }
}
