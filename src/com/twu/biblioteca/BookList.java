package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList {
    ArrayList<Book> booklist;
    Book book1;
    Book book2;
    Book book3;

    BookList(){
        booklist = new ArrayList<Book>();
    }

    public void loadBook(Book book) {
        booklist.add(book);
    }

    public void removeBook(Book book) {
        booklist.remove(book);
    }

    public void loadFakeResources() {
        this.book1 = new Book("Harry Potter", "1997", "J K Rowling");
        this.book2 = new Book("The Hunger Games", "2009", "Suzanne Collins");
        this.book3 = new Book("Twilight", "2005", "Stephenie Meyer");
        loadBook(book1);
        loadBook(book2);
        loadBook(book3);
    }

    public String getListString() {
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
