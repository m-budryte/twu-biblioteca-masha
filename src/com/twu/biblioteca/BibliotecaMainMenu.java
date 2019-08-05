package com.twu.biblioteca;

public class BibliotecaMainMenu {
    public String showMenu() {
        return "9. Exit";
    }

    public String chooseOption(String s) {
        if (s == "9") {
            return "Valid option";
        } else {
            return "Invalid option. Please try again.";
        }
    }
}
