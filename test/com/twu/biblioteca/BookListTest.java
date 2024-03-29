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

class BookStub extends Book {
    public BookStub(String title, String year, String author) {
        super(title, year, author);
    }
    @Override
    public String getItemTitle(){
        return "Title";
    }

    public String getReleaseYear(){
        return "Year";
    }

    public String getItemAuthor(){
        return "Author";
    }

    public String getFullInfo(){
        return "Title | Author | Year";
    }
}

public class BookListTest {
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

    BookStub bookStub = new BookStub("title", "year", "author");
    BookList bookList = new BookList();

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Rule
    public TestName name = new TestName();

    @Test
    public void loadOneBookTest(){
        bookList.addItem(bookStub);
        assertEquals("1 book can be loaded", "Title | Author | Year\n", bookList.getListString());
    }

    @Test
    public void loadTwoBooksTest(){
        bookList.addItem(bookStub);
        bookList.addItem(bookStub);
        assertEquals("2 books can be loaded", "Title | Author | Year\nTitle | Author | Year\n", bookList.getListString());
    }

    @Test
    public void getsBookListObject(){
        bookList.addItem(bookStub);
        ArrayList<Book> expected = new ArrayList<Book>();
        expected.add(bookStub);
        assertEquals("A ArrayList of books returned", expected, bookList.getList());
    }
}




