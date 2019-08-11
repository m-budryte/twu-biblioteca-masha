package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList {
    ArrayList<Book> bookList;

    public BookList(){
        bookList = new ArrayList<Book>();
    }

    public void loadBooks(Book book) {
        bookList.add(book);
    }

    public String getList() {
        String bookListString = "";
        for (Book book : bookList) {
            bookListString += (book.getFullInfo() + "\n");
        }
        return bookListString;
    }

}
