package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import static org.junit.Assert.assertEquals;

class BookStub extends Book {
    public BookStub(String title, String year, String author) {
        super(title, year, author);
    }
    @Override
    public String getBookTitle(){
        return "Title";
    }

    public String getPubYear(){
        return "Year";
    }

    public String getBookAuthor(){
        return "Author";
    }

    public String getFullInfo(){
        return "Title Author Year";
    }
}

public class BookListTest {
    @Rule
    public TestName name = new TestName();

    @Test
    public void loadOneBookTest(){
        BookStub bookStub = new BookStub("title", "year", "author");
        BookList bookList = new BookList();
        bookList.loadBooks(bookStub);
        assertEquals("1 book can be loaded", "Title Author Year\n", bookList.getList());
    }

    @Test
    public void loadTwoBooksTest(){
        BookStub bookStub = new BookStub("title", "year", "author");
        BookList bookList = new BookList();
        bookList.loadBooks(bookStub);
        bookList.loadBooks(bookStub);
        assertEquals("2 books can be loaded", "Title Author Year\nTitle Author Year\n", bookList.getList());
    }
}




