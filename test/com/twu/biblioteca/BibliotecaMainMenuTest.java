package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import static org.junit.Assert.assertEquals;

public class BibliotecaMainMenuTest {
    @Rule
    public TestName name = new TestName();

    @Test
    public void showMenuTest() {
        BibliotecaMainMenu bibliotecaMainMenu = new BibliotecaMainMenu();
        assertEquals("Returns menu", "9. Exit", bibliotecaMainMenu.showMenu());
    }

    @Test
    public void chooseOptionTestTrue() {
        BibliotecaMainMenu bibliotecaMainMenu = new BibliotecaMainMenu();
        assertEquals("Accepts valid input", "Valid option", bibliotecaMainMenu.chooseOption("9"));
    }

    @Test
    public void chooseOptionTestError() {
        BibliotecaMainMenu bibliotecaMainMenu = new BibliotecaMainMenu();
        assertEquals("Notifies about the invalid option", "Invalid option. Please try again.", bibliotecaMainMenu.chooseOption("1"));
    }
}
