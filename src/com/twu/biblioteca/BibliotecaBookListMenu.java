package com.twu.biblioteca;

public class BibliotecaBookListMenu {
    private BookList unreserved;

    public BibliotecaBookListMenu(BookList bookList) {
        unreserved = bookList;
    }

    public void viewBooks() {
        System.out.println(unreserved.getListString());
    }
}
