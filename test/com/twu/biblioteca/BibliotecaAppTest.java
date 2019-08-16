package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

class BibliotecaMainMenuStub extends BibliotecaMainMenu {
    @Override
    public void showMenu() {
        System.out.println("1. View list of books\n9.Exit");
    }
}

public class BibliotecaAppTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    BibliotecaApp bibliotecaApp = new BibliotecaApp();

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Rule
    public TestName name = new TestName();

    @Test
    public void welcomesUserTest() {
        bibliotecaApp.welcome();
        assertEquals("Shows the welcome message","Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n", getOutput());
    }

    @Test
    public void welcomesAndShowsTheMenu() {
        bibliotecaApp.main(null);
        assertEquals("Shows the welcome message and the main menu","Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n1. View list of books\n9.Exit\n", getOutput());
    }
}
