package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import static org.junit.Assert.assertEquals;

public class WelcomeMessageTest {
    @Rule
    public TestName name = new TestName();

    @Test
    public void bibliotecaWelcomeTest() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        assertEquals("Shows the welcome message","Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", bibliotecaApp.welcome());
    }
}
