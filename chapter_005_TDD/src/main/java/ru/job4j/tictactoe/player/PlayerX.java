package ru.job4j.tictactoe.player;

public class PlayerX implements Player {
    private String name = "X";

    @Override
    public int makeChoice(int place) {
        return place;
    }

    public String getName() {
        return name;
    }
}
