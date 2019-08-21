package com.twu.biblioteca;

import java.util.ArrayList;

public class LibraryItemList {
    ArrayList<LibraryItem> libraryItemsList;

    public LibraryItemList() {
        libraryItemsList = new ArrayList<LibraryItem>();
    }

    public void addItem(LibraryItem item) {
        libraryItemsList.add(item);
    }

    public void removeItem(LibraryItem item) {
        libraryItemsList.remove(item);
    }

    public void loadFakeResources() {}

    public String getListString() {
        String itemListString = "";
        for (LibraryItem item : libraryItemsList) {
            itemListString += (item.getFullInfo() + "\n");
        }
        return itemListString;
    }

    public ArrayList<LibraryItem> getList() {
        return libraryItemsList;
    }
}
