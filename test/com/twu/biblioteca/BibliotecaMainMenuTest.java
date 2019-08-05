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
        assertEquals("Returns menu", "1. View list of books\n9. Exit", bibliotecaMainMenu.showMenu());
    }

    @Test
    public void chooseOptionTestTrue9() {
        BibliotecaMainMenu bibliotecaMainMenu = new BibliotecaMainMenu();
        assertEquals("Accepts valid input", "Valid option.", bibliotecaMainMenu.chooseOption("9"));
    }

    @Test
    public void chooseOptionTestTrue1() {
        BibliotecaMainMenu bibliotecaMainMenu = new BibliotecaMainMenu();
        assertEquals("View list of books", "Harry Potter\nBible", bibliotecaMainMenu.chooseOption("1"));
    }

    @Test
    public void chooseOptionTestError() {
        BibliotecaMainMenu bibliotecaMainMenu = new BibliotecaMainMenu();
        assertEquals("Notifies about the invalid option", "Invalid option. Please try again.", bibliotecaMainMenu.chooseOption("1000000"));
    }
}
