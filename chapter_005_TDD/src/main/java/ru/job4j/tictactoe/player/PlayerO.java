package ru.job4j.tictactoe.player;

public class PlayerO implements Player {
    private String name = "O";

    @Override
    public int makeChoice(int place) {
        return place;
    }

    public String getName() {
        return name;
    }
}
