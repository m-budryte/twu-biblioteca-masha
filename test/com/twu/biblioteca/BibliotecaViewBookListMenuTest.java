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

class BookListStub extends BookList {
    @Override
    public String getList() {
        return "Book\nBook\nBook";
    }
}


public class BibliotecaViewBookListMenuTest {
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

    BookListStub bookListStub = new BookListStub();
    BibliotecaViewBookListMenu bibliotecaViewBookListMenu = new BibliotecaViewBookListMenu(bookListStub);

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Rule
    public TestName name = new TestName();

    @Test
    public void viewBooksTest (){
        bibliotecaViewBookListMenu.viewBooks();
        assertEquals("Shows the list of books", "Book\nBook\nBook\n", getOutput());
    }
}
