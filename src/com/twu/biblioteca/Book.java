package com.twu.biblioteca;

public class Book {
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
}
