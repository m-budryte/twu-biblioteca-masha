package com.twu.biblioteca;

import java.util.ArrayList;

public class Book extends LibraryItem {
    String itemAuthor;

    public Book(String title, String year, String author){
        super(title, year);
        itemAuthor = author;
    }

    public String getItemAuthor() {
        return itemAuthor;
    }

    public String getFullInfo() {
        return itemTitle + " | " + itemAuthor + " | " + releaseYear;
    }

}
