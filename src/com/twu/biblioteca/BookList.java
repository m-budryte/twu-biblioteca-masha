package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList {
    ArrayList<Book> bookList;

    BookList(){
        bookList = new ArrayList<Book>();
    }

    void loadBooks(Book book) {
        bookList.add(book);
    }

    String getList() {
        String bookListString = "";
        for (Book book : bookList) {
            bookListString += (book.getFullInfo() + "\n");
        }
        return bookListString;
    }

}
