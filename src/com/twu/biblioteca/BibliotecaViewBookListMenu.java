package com.twu.biblioteca;

public class BibliotecaViewBookListMenu {
    private BookList currentBookList;

    public BibliotecaViewBookListMenu(BookList bookList) {
        currentBookList = bookList;
    }

    public void viewBooks() {
        System.out.println(currentBookList.getList());
    }
}
