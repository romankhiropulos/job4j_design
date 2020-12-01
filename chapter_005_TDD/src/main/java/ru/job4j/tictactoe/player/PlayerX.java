package ru.job4j.tictactoe.player;

public class PlayerX implements Player {
    @Override
    public int makeChoice(int place) {
        return place;
    }
}
