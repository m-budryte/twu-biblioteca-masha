package com.twu.biblioteca;

import java.util.ArrayList;

public class LibraryItemList {
    ArrayList<LibraryItem> libraryItemsList;
    Book book1;
    Book book2;
    Book book3;

    public LibraryItemList() {
        libraryItemsList = new ArrayList<LibraryItem>();
    }

    public void addItem(LibraryItem book) {
        libraryItemsList.add(book);
    }

    public void removeItem(LibraryItem book) {
        libraryItemsList.remove(book);
    }

    public void loadFakeResources() {
        this.book1 = new Book("Harry Potter", "1997", "J K Rowling");
        this.book2 = new Book("The Hunger Games", "2009", "Suzanne Collins");
        this.book3 = new Book("Twilight", "2005", "Stephenie Meyer");
        addItem(book1);
        addItem(book2);
        addItem(book3);
    }

    public String getListString() {
        String bookListString = "";
        for (LibraryItem item : libraryItemsList) {
            bookListString += (item.getFullInfo() + "\n");
        }
        return bookListString;
    }

    public ArrayList<LibraryItem> getList() {
        return libraryItemsList;
    }
}
