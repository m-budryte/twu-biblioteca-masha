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

    public Book findBook(String bookTitle, ArrayList<Book> list){
        Book output = null;
        for (Book book : list) {
            if (book.getBookTitle() == bookTitle){
                output = book;
            };
        }
        return output;
    }

    public void reserveBook(String bookTitle) {
        ArrayList<Book> list = unreserved.getList();
        Book bookToReserve = findBook(bookTitle, list);

        unreserved.removeBook(bookToReserve);
        reserved.loadBook(bookToReserve);

        if (bookToReserve != null) {
            System.out.println("Thank you! Enjoy the book.");
        } else {
            System.out.println("Sorry, this book is not available.");
        }
    }

    public void returnBook(String bookTitle) {
        ArrayList<Book> list = reserved.getList();
        Book bookToReturn = findBook(bookTitle, list);

        unreserved.loadBook(bookToReturn);
        reserved.removeBook(bookToReturn);

        if (bookToReturn != null) {
            System.out.println("Thank you for returning the book.");
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }
}
