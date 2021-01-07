package ru.job4j.tictactoe;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.job4j.tictactoe.field.MemFieldTest;
import ru.job4j.tictactoe.mark.ConsoleMarkFieldTest;
import ru.job4j.tictactoe.mark.ConsoleMarkNumbersListTest;
import ru.job4j.tictactoe.mark.ConsoleMarkTest;
import ru.job4j.tictactoe.output.ConsoleOutPutTest;
import ru.job4j.tictactoe.player.GamerTest;
import ru.job4j.tictactoe.rule.GameRuleTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ConsoleMarkTest.class,
        ConsoleMarkFieldTest.class,
        ConsoleMarkNumbersListTest.class,
        ConsoleOutPutTest.class,
        GameRuleTest.class,
        GamerTest.class,
        MemFieldTest.class
})
public class AllTicTacToeTests {
}
