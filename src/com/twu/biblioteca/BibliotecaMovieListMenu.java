package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaMovieListMenu implements reserveAndReturn {
    private MovieList unreserved;
    private MovieList reserved;

    public BibliotecaMovieListMenu(MovieList movieList) {
        unreserved = movieList;
        reserved = new MovieList();
    }

    @Override
    public void viewAll() {
        System.out.print(unreserved.getListString());
    }

    @Override
    public Movie findItem(String movieTitle, ArrayList<LibraryItem> list){
        LibraryItem output = null;
        for (LibraryItem item : list) {
            if (item.getItemTitle() == movieTitle){
                output = item;
            };
        }
        return (Movie) output;
    }

    @Override
    public void reserveItem(String bookTitle) {
        ArrayList<LibraryItem> list = unreserved.getList();
        Movie movieToReserve = findItem(bookTitle, list);

        unreserved.removeItem(movieToReserve);
        reserved.addItem(movieToReserve);

        if (movieToReserve != null) {
            System.out.println("Thank you! Enjoy the book.");
        } else {
            System.out.println("Sorry, this book is not available.");
        }
    }

    @Override
    public void returnItem(String bookTitle) {
        ArrayList<LibraryItem> list = unreserved.getList();
        Movie movieToReserve = findItem(bookTitle, list);

        unreserved.addItem(movieToReserve);
        reserved.removeItem(movieToReserve);

        if (movieToReserve != null) {
            System.out.println("Thank you for returning the book.");
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }
}
