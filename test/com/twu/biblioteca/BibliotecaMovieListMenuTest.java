package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


public class BibliotecaMovieListMenuTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    MovieList movieList = new MovieList();

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Rule
    public TestName name = new TestName();

    @Test
    public void viewBooksTest (){
        movieList.loadFakeResources();
        BibliotecaMovieListMenu bibliotecaMovieListMenu = new BibliotecaMovieListMenu(movieList);
        bibliotecaMovieListMenu.viewAll();
        assertEquals("Shows the list of movies", "Titanic | James Cameron | 1997 | 9\nAvatar | James Cameron | 2009 | 10\nHellboy | Neil Marshall | 2019 | 0\n", getOutput());
    }
//
    @Test
    public void aBookCanBeReservedTest (){
        movieList.loadFakeResources();
        BibliotecaMovieListMenu bibliotecaMovieListMenu = new BibliotecaMovieListMenu(movieList);
        bibliotecaMovieListMenu.reserveItem("Titanic");
        setUpOutput();
        bibliotecaMovieListMenu.viewAll();
        assertEquals("A movie can be reserved", "Avatar | James Cameron | 2009 | 10\nHellboy | Neil Marshall | 2019 | 0\n", getOutput());
    }

    @Test
    public void successMessageReservationTest (){
        movieList.loadFakeResources();
        BibliotecaMovieListMenu bibliotecaMovieListMenu = new BibliotecaMovieListMenu(movieList);
        bibliotecaMovieListMenu.reserveItem("Titanic");
        assertEquals("success message upon reservation", "Thank you! Enjoy the movie.\n", getOutput());
    }

    @Test
    public void unsuccessfullMessageReservationTest (){
        movieList.loadFakeResources();
        BibliotecaMovieListMenu bibliotecaMovieListMenu = new BibliotecaMovieListMenu(movieList);
        bibliotecaMovieListMenu.reserveItem("BDJJKSP:ABCHDNFL");
        assertEquals("unsuccessful message upon reservation", "Sorry, this movie is not available.\n", getOutput());
    }

    @Test
    public void returnBookTest (){
        movieList.loadFakeResources();
        BibliotecaMovieListMenu bibliotecaMovieListMenu = new BibliotecaMovieListMenu(movieList);
        bibliotecaMovieListMenu.reserveItem("Titanic");
        bibliotecaMovieListMenu.returnItem("Titanic");
        setUpOutput();
        bibliotecaMovieListMenu.viewAll();
        assertEquals("movie can be returned", "Avatar | James Cameron | 2009 | 10\nHellboy | Neil Marshall | 2019 | 0\nTitanic | James Cameron | 1997 | 9\n", getOutput());
    }

    @Test
    public void successMessageReturnTest (){
        movieList.loadFakeResources();
        BibliotecaMovieListMenu bibliotecaMovieListMenu = new BibliotecaMovieListMenu(movieList);
        bibliotecaMovieListMenu.reserveItem("Titanic");
        setUpOutput();
        bibliotecaMovieListMenu.returnItem("Titanic");
        assertEquals("success message upon reservation", "Thank you for returning the movie.\n", getOutput());
    }

    @Test
    public void unsuccessfullMessageReturnTest (){
        movieList.loadFakeResources();
        BibliotecaMovieListMenu bibliotecaMovieListMenu = new BibliotecaMovieListMenu(movieList);
        bibliotecaMovieListMenu.returnItem("BDJJKSP:ABCHDNFL");
        assertEquals("fail message", "That is not a valid movie to return.\n", getOutput());
    }
}
