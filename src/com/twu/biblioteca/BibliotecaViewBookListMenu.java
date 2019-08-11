package com.twu.biblioteca;

public class BibliotecaViewBookListMenu {
    BookList currentBookList;
    public BibliotecaViewBookListMenu(BookList bookList) {
        currentBookList = bookList;

    }

    public String viewBooks() {
        return currentBookList.getList();
    }
}
