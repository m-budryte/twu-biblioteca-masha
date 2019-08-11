package com.twu.biblioteca;

import java.util.ArrayList;

public class Book extends ArrayList<Book> {
    String bookTitle;
    String pubYear;
    String bookAuthor;

    public Book(String title, String year, String author){
        bookTitle = title;
        pubYear = year;
        bookAuthor = author;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getPubYear() {
        return pubYear;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getFullInfo() {
        return bookTitle + " " + bookAuthor + " " + pubYear;
    }
}
