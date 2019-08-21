package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList extends LibraryItemList {
    Book book1;
    Book book2;
    Book book3;

    BookList(){
        super();
    }

    @Override
    public void loadFakeResources() {
        this.book1 = new Book("Harry Potter", "1997", "J K Rowling");
        this.book2 = new Book("The Hunger Games", "2009", "Suzanne Collins");
        this.book3 = new Book("Twilight", "2005", "Stephenie Meyer");
        addItem(book1);
        addItem(book2);
        addItem(book3);
    }

}
