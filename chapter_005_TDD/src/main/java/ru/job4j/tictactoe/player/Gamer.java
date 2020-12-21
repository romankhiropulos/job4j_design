package ru.job4j.tictactoe.player;

public class Gamer implements Player {
    private final String name;

    public Gamer(String name) {
        this.name = name;
    }

    @Override
    public int makeChoice(int place) {
        return place;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Gamer gamer = (Gamer) o;

        return name.equals(gamer.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
