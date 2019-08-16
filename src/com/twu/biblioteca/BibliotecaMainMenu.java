package com.twu.biblioteca;

public class BibliotecaMainMenu {
    private String menu;

    public BibliotecaMainMenu() {
        menu = "1. View list of books\n9.Exit";
    }

    public void showMenu() {
        System.out.println(menu);
    }

    public void chooseOption(String s) {
        if (s.equals("1")) {
            System.out.println("Valid option.\n0. Go back");
        } else if (s.equals("9")) {
            System.out.println("EXIT");
        } else {
            System.out.println("Invalid option. Please try again.");
        }
     }
}
