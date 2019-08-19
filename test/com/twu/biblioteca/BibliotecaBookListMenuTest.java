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
        bibliotecaBookListMenu.viewAll();
        assertEquals("Shows the list of books", "Harry Potter | J K Rowling | 1997\nThe Hunger Games | Suzanne Collins | 2009\nTwilight | Stephenie Meyer | 2005\n", getOutput());
    }

    @Test
    public void aBookCanBeReservedTest (){
        bookList.loadFakeResources();
        BibliotecaBookListMenu bibliotecaBookListMenu = new BibliotecaBookListMenu(bookList);
        bibliotecaBookListMenu.reserveItem("Harry Potter");
        setUpOutput();
        bibliotecaBookListMenu.viewAll();
        assertEquals("A book can be reserved", "The Hunger Games | Suzanne Collins | 2009\nTwilight | Stephenie Meyer | 2005\n", getOutput());
    }

    @Test
    public void successMessageReservationTest (){
        bookList.loadFakeResources();
        BibliotecaBookListMenu bibliotecaBookListMenu = new BibliotecaBookListMenu(bookList);
        bibliotecaBookListMenu.reserveItem("Harry Potter");
        assertEquals("success message upon reservation", "Thank you! Enjoy the book.\n", getOutput());
    }

    @Test
    public void unsuccessfullMessageReservationTest (){
        bookList.loadFakeResources();
        BibliotecaBookListMenu bibliotecaBookListMenu = new BibliotecaBookListMenu(bookList);
        bibliotecaBookListMenu.reserveItem("BDJJKSP:ABCHDNFL");
        assertEquals("unsuccessful message upon reservation", "Sorry, this book is not available.\n", getOutput());
    }

    @Test
    public void returnBookTest (){
        bookList.loadFakeResources();
        BibliotecaBookListMenu bibliotecaBookListMenu = new BibliotecaBookListMenu(bookList);
        bibliotecaBookListMenu.reserveItem("Harry Potter");
        bibliotecaBookListMenu.returnItem("Harry Potter");
        setUpOutput();
        bibliotecaBookListMenu.viewAll();
        assertEquals("book can be returned", "The Hunger Games | Suzanne Collins | 2009\nTwilight | Stephenie Meyer | 2005\nHarry Potter | J K Rowling | 1997\n", getOutput());
    }

    @Test
    public void successMessageReturnTest (){
        bookList.loadFakeResources();
        BibliotecaBookListMenu bibliotecaBookListMenu = new BibliotecaBookListMenu(bookList);
        bibliotecaBookListMenu.reserveItem("Harry Potter");
        setUpOutput();
        bibliotecaBookListMenu.returnItem("Harry Potter");
        assertEquals("success message upon reservation", "Thank you for returning the book.\n", getOutput());
    }

    @Test
    public void unsuccessfullMessageReturnTest (){
        bookList.loadFakeResources();
        BibliotecaBookListMenu bibliotecaBookListMenu = new BibliotecaBookListMenu(bookList);
        bibliotecaBookListMenu.returnItem("BDJJKSP:ABCHDNFL");
        assertEquals("A book can be reserved", "That is not a valid book to return.\n", getOutput());
    }
}
