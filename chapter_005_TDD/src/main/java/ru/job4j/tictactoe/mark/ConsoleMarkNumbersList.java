package ru.job4j.tictactoe.mark;

public class ConsoleMarkNumbersList extends ConsoleMark {

    public ConsoleMarkNumbersList() {
        this(fillMessageText());
    }

    private ConsoleMarkNumbersList(String message) {
        super(message);
    }

    private static String fillMessageText() {
        StringBuilder line = new StringBuilder();
        line.append("\n");
        for (int i = 0; i <= 9; i++) {
            switch (i) {
                case (0):
                    line.append(i).append(" - A").append(1).append("\n");
                    break;
                case (1):
                    line.append(i).append(" - B").append(1).append("\n");
                    break;
                case (2):
                    line.append(i).append(" - C").append(1).append("\n");
                    break;
                case (3):
                    line.append(i).append(" - A").append(2).append("\n");
                    break;
                case (4):
                    line.append(i).append(" - B").append(2).append("\n");
                    break;
                case (5):
                    line.append(i).append(" - C").append(2).append("\n");
                    break;
                case (6):
                    line.append(i).append(" - A").append(3).append("\n");
                    break;
                case (7):
                    line.append(i).append(" - B").append(3).append("\n");
                    break;
                case (8):
                    line.append(i).append(" - C").append(3).append("\n");
                    break;
                case (9):
                    line.append(i).append(" - Exit").append("\n");
                    break;
                default:
                    break;
            }
        }

        return line.toString();
    }
}
