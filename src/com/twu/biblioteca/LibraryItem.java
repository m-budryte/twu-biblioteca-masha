package com.twu.biblioteca;

public abstract class LibraryItem {
    String itemTitle;
    String releaseYear;

    public LibraryItem(String title, String year) {
        itemTitle = title;
        releaseYear = year;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public abstract String getFullInfo();
}
