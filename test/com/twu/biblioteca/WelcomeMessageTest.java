package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WelcomeMessageTest {
    @Test
    public void bibliotecaWelcomeTest() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String expected = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        String actual = bibliotecaApp.welcome();
        assertEquals(expected, actual);
    }
}
