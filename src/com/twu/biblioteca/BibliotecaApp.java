package com.twu.biblioteca;

public class BibliotecaApp {
    static void welcome(){ System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"); }
    static void showMenu() {
        BibliotecaMainMenu bibliotecaMainMenu = new BibliotecaMainMenu();
        bibliotecaMainMenu.showMenu();
    }


    public static void main(String[] args) {
        welcome();
        showMenu();
    }
}
