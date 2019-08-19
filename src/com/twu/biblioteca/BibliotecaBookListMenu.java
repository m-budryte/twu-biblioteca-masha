package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;

public class BibliotecaBookListMenu {
    private BookList unreserved;
    private BookList reserved;

    public BibliotecaBookListMenu(BookList bookList) {
        unreserved = bookList;
        reserved = new BookList();
    }

    public void viewBooks() {
        System.out.print(unreserved.getListString());
    }

    public void reserveBook(String bookTitle) {
        ArrayList<Book> list = unreserved.getList();

        Book bookToReserve = null;

        for (Book book : list) {
            if (book.getBookTitle() == bookTitle){
                bookToReserve = book;
            };
        }

        unreserved.removeBook(bookToReserve);
        reserved.loadBook(bookToReserve);

        if (bookToReserve != null) {
            System.out.println("Thank you! Enjoy the book.");
        } else {
            System.out.println("Sorry, this book is not available.");
        }
    }
}
