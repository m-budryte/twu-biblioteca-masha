package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import static org.junit.Assert.assertEquals;

class BookListStub extends BookList {
    @Override
    public String getList() {
        return "Book\nBook\nBook\n";
    }
}

public class BibliotecaViewBookListMenuTest {
    @Rule
    public TestName name = new TestName();

    @Test
    public void viewBooksTest (){
        BookListStub bookListStub = new BookListStub();
        BibliotecaViewBookListMenu bibliotecaViewBookListMenu = new BibliotecaViewBookListMenu(bookListStub);
        assertEquals("Shows the list of books", "Book\nBook\nBook\n", bibliotecaViewBookListMenu.viewBooks());
    }
}
