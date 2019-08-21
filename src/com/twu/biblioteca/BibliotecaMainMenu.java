package com.twu.biblioteca;

public class BibliotecaMainMenu {
    private String menu;
    private BibliotecaBookListMenu bibliotecaBookListMenu;
    private BookList bookList;

    public BibliotecaMainMenu() {
        menu = "1. View list of books\n9.Exit";
        bookList = new BookList();
        bookList.loadFakeResources();
        bibliotecaBookListMenu = new BibliotecaBookListMenu(bookList);
    }

    public void showMenu() {
        System.out.println(menu);
    }

    public void chooseOption(String choice) {
        switch (choice){
            case "1":
                bibliotecaBookListMenu.viewAll();
                System.out.print("1. Reserve\n2. Return \n0. Go back");
                break;
            case "9":
                System.out.println("EXIT");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
     }
}
