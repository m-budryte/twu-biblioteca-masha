package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class BibliotecaMainMenu {
    String menu;
    String [] validOptions;

    public BibliotecaMainMenu(){
        menu = "9. Exit";
        validOptions = new String[]{"9"};
    }
    public String showMenu() {
        return menu;
    }

    public String chooseOption(String s) {
        List<String> list = Arrays.asList(validOptions);
        if (list.contains(s)) {
            return "Valid option";
        } else {
            return "Invalid option. Please try again.";
        }
    }
}
