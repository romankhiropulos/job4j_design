package ru.job4j.tdd.cinema;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class CinemaTest {

    @Test
    public void makeDummy() {
        System.out.println("Dummy test for CinemaTest");
    }
//    @Test
//    public void buy() {
//        Account account = new AccountCinema();
//        Cinema cinema = new Cinema3D();
//        Calendar date = Calendar.getInstance();
//        date.set(2020, 10, 10, 23, 00);
//        Ticket ticket = cinema.buy(account, 1, 1, date);
//        assertThat(ticket, is(new Ticket3D()));
//    }
//
//    @Test
//    public void find() {
//        Cinema cinema = new Cinema3D();
//        cinema.add(new Session3D());
//        List<Session> sessions = cinema.find(session -> true);
//        assertThat(sessions, is(Arrays.asList(new Session3D())));
//    }
//
//    @Test
//    public void add() {
//        Session session = new Session3D();
//        Cinema cinema = new Cinema3D();
//        cinema.add(session);
//        List<Session> sessions = new ArrayList<>(cinema.find(s -> true));
//        assertTrue(sessions.contains(session));
//    }
}