package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import static org.junit.Assert.assertEquals;

public class BookTest {
    @Rule
    public TestName name = new TestName();

    @Test
    public void getBookTitleTest() {
        Book book = new Book("Harry Potter", "1998", "J.K.Rowling");
        assertEquals("Shows the title", "Harry Potter", book.getBookTitle());
    }

    @Test
    public void getPubYearTest() {
        Book book = new Book("Harry Potter", "1998", "J.K.Rowling");
        assertEquals("Shows the publication year", "1998", book.getPubYear());
    }

    @Test
    public void getBookAuthorTest() {
        Book book = new Book("Harry Potter", "1998", "J.K.Rowling");
        assertEquals("Shows the author's name", "J.K.Rowling", book.getBookAuthor());
    }

    @Test
    public void getFullInfoTest() {
        Book book = new Book("Harry Potter", "1998", "J.K.Rowling");
        assertEquals("Returns the whole book info", "Harry Potter J.K.Rowling 1998", book.getFullInfo());
    }

}
