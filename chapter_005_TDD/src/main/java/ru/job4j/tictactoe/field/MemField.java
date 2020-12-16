package ru.job4j.tictactoe.field;

import ru.job4j.tictactoe.player.Player;
import ru.job4j.tictactoe.util.FieldUtils;

import java.util.List;

public class MemField implements Field {
    
    private final Player[] field;

    public MemField() {
        field = new Player[9];
    }

    public Player[] getFIELD() {
        return field;
    }

    @Override
    public boolean addChoice(Player player, int place) {
        boolean result = analyze(place);
        if (result) {
            field[place] = player;
            if (winCheck()) {
                throw new IllegalStateException("Wins");
            }
        }
        return result;
    }

    @Override
    public boolean analyze(int place) {
        return field[place] == null;
    }

    public boolean fieldCheck() {
        winCheck();
        return false;
    }

//    Поле - анализирует процесс игры (игра завершена или может быть продолжена)
//    Мб надо объединить всю главную логику в один метод, сначало идет проверка на возможность
//    вставки(свободно ли указанное поле), потом вставка, потом проверка на возможность продолжения игры
//    Хотя, нужно ведь еще по логике в Rules проверять заполнено ли все поле из 9 ячеек. Мб в текущий
//    класс добавить счетчик size и сделать паблик метод с гетом этого сайза, а в rules чекать чтобы
//    сайз был <= 9.

    private boolean winCheck() {
        for (int[] item : FieldUtils.getWinArrays()) {
            if (field[item[0]].equals(field[item[1]])
                && field[item[0]].equals(field[item[2]])
                && field[item[1]].equals(field[item[2]])) {
                return true;
            }
        }
        return false;
    }
}