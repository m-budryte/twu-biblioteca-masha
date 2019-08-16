package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList {
    ArrayList<Book> bookList;
    Book book1;
    Book book2;
    Book book3;

    BookList(){
        bookList = new ArrayList<Book>();
    }

    public void loadFakeResources() {
        this.book1 = new Book("Harry Potter", "1997", "J K Rowling");
        this.book2 = new Book("The Hunger Games", "2009", "Suzanne Collins");
        this.book3 = new Book("Twilight", "2005", "Stephenie Meyer");
        loadBooks(book1);
        loadBooks(book2);
        loadBooks(book3);
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
