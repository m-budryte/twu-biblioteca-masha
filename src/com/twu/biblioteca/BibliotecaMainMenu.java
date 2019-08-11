package com.twu.biblioteca;

import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class BibliotecaMainMenu {
    private String menu;

    public BibliotecaMainMenu() {
        menu = "1. View list of books\n9. Exit";
    }

    public String showMenu() {
        return menu;
    }

    public String chooseOption(String s) {
        if (s.equals("1")) {
            return "Harry Potter\nBible";
        } else if (s.equals("9")) {
            return "Valid option.";
        } else {
            return "Invalid option. Please try again.";
        }
     }
}
