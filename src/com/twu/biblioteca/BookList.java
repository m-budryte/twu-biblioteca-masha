package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;

public class BookList {
    ArrayList<Book> booklist;
    Book book1;
    Book book2;
    Book book3;

    BookList(){
        booklist = new ArrayList<Book>();
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
        booklist.add(book);
    }

    String getListString() {
        String bookListString = "";
        for (Book book : booklist) {
            bookListString += (book.getFullInfo() + "\n");
        }
        return bookListString;
    }

    public ArrayList<Book> getList() {
        return booklist;
    }
}
