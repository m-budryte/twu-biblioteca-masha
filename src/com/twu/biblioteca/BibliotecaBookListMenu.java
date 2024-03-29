package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaBookListMenu implements reserveAndReturn {
    private BookList unreserved;
    private BookList reserved;

    public BibliotecaBookListMenu(BookList bookList) {
        unreserved = bookList;
        reserved = new BookList();
    }

    @Override
    public void viewAll() {
        System.out.print(unreserved.getListString());
    }

    @Override
    public Book findItem(String bookTitle, ArrayList<LibraryItem> list){
        LibraryItem output = null;
        for (LibraryItem item : list) {
            if (item.getItemTitle() == bookTitle){
                output = item;
            };
        }
        return (Book) output;
    }

    @Override
    public void reserveItem(String bookTitle) {
        ArrayList<LibraryItem> list = unreserved.getList();
        Book bookToReserve = findItem(bookTitle, list);

        unreserved.removeItem(bookToReserve);
        reserved.addItem(bookToReserve);

        if (bookToReserve != null) {
            System.out.println("Thank you! Enjoy the book.");
        } else {
            System.out.println("Sorry, this book is not available.");
        }
    }

    @Override
    public void returnItem(String bookTitle) {
        ArrayList<LibraryItem> list = reserved.getList();
        Book bookToReturn = findItem(bookTitle, list);

        unreserved.addItem(bookToReturn);
        reserved.removeItem(bookToReturn);

        if (bookToReturn != null) {
            System.out.println("Thank you for returning the book.");
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }
}
