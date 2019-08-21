package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import static org.junit.Assert.assertEquals;

public class MovieTest {
    @Rule
    public TestName name = new TestName();

    @Test
    public void getMovieTitleTest() {
        Movie movie = new Movie("Titanic", "1997", "James Cameron", 5);
        assertEquals("Shows the title", "Titanic", movie.getItemTitle());
    }

    @Test
    public void getReleaseYearTest() {
        Movie movie = new Movie("Titanic", "1997", "James Cameron", 5);
        assertEquals("Shows the year", "1997", movie.getReleaseYear());
    }

    @Test
    public void getMovieDirectorTest() {
        Movie movie = new Movie("Titanic", "1997", "James Cameron", 5);
        assertEquals("Shows the director", "James Cameron", movie.getDirector());
    }

    @Test
    public void getRatingTest() {
        Movie movie = new Movie("Titanic", "1997", "James Cameron", 5);
        assertEquals("shows the rating", "5", movie.getRating());
    }

    @Test
    public void getFullInfo() {
        Movie movie = new Movie("Titanic", "1997", "James Cameron", 5);
        assertEquals("Shows the title", "Titanic | James Cameron | 1997 | 5", movie.getFullInfo());
    }

}
