package com.twu.biblioteca;

public class Movie extends LibraryItem {
    String movieDirector;
    Integer movieRating;

    public Movie(String title, String year, String director, Integer rating ){
        super(title, year);
        movieDirector = director;
        movieRating = rating;
    }

    public Movie(String title, String year, String director){
        super(title, year);
        movieDirector = director;
        movieRating = 0;
    }

    public String getFullInfo() {
        return itemTitle + " | " + movieDirector + " | " + releaseYear + " | " + movieRating;
    }
}
