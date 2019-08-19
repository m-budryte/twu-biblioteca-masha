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
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class BibliotecaBookListMenuTest {
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

    BookList bookList = new BookList();

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Rule
    public TestName name = new TestName();

    @Test
    public void viewBooksTest (){
        bookList.loadFakeResources();
        BibliotecaBookListMenu bibliotecaBookListMenu = new BibliotecaBookListMenu(bookList);
        bibliotecaBookListMenu.viewBooks();
        assertEquals("Shows the list of books", "Harry Potter | J K Rowling | 1997\nThe Hunger Games | Suzanne Collins | 2009\nTwilight | Stephenie Meyer | 2005\n", getOutput());
    }

    @Test
    public void aBookCanBeReserved (){
        bookList.loadFakeResources();
        BibliotecaBookListMenu bibliotecaBookListMenu = new BibliotecaBookListMenu(bookList);
        bibliotecaBookListMenu.reserveBook("Harry Potter");
        bibliotecaBookListMenu.viewBooks();
        assertEquals("A book can be reserved", "Thank you! Enjoy the book.\nThe Hunger Games | Suzanne Collins | 2009\nTwilight | Stephenie Meyer | 2005\n", getOutput());
    }

    @Test
    public void successMessageReservation (){
        bookList.loadFakeResources();
        BibliotecaBookListMenu bibliotecaBookListMenu = new BibliotecaBookListMenu(bookList);
        bibliotecaBookListMenu.reserveBook("Harry Potter");
        assertEquals("A book can be reserved", "Thank you! Enjoy the book.\n", getOutput());
    }

    @Test
    public void unsuccessfullMessageReservation (){
        bookList.loadFakeResources();
        BibliotecaBookListMenu bibliotecaBookListMenu = new BibliotecaBookListMenu(bookList);
        bibliotecaBookListMenu.reserveBook("BDJJKSP:ABCHDNFL");
        assertEquals("A book can be reserved", "Sorry, this book is not available.\n", getOutput());
    }
}
