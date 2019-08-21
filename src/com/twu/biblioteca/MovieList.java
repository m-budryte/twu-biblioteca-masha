package com.twu.biblioteca;

public class MovieList extends LibraryItemList {
    Movie movie1;
    Movie movie2;
    Movie movie3;

    MovieList(){
        super();
    }

    @Override
    public void loadFakeResources() {
        this.movie1 = new Movie("Titanic", "1997", "James Cameron", 9);
        this.movie2 = new Movie("Avatar", "2009", "James Cameron", 10);
        this.movie3 = new Movie("Hellboy", "2019", "Neil Marshall");
        addItem(movie1);
        addItem(movie2);
        addItem(movie3);
    }

}
