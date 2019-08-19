package com.twu.biblioteca;

import java.util.ArrayList;

public interface reserveAndReturn {
    void viewAll();

    LibraryItem findItem(String bookTitle, ArrayList<LibraryItem> list);

    void reserveItem(String bookTitle);

    void returnItem(String bookTitle);
}
