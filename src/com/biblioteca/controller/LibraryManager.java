/*
 * Universidad del Valle de Guatemala
 * POO - seccion 10
 * Roberto Barreda - 23354
 */

package com.biblioteca.controller;

import java.util.ArrayList;

import com.biblioteca.bean.Book;
import com.biblioteca.bean.Magazine;


/**
 * La clase LibraryManager gestiona los recursos disponibles en la biblioteca.
 */
public class LibraryManager {
    private ArrayList<Book> availableBooks;
    private ArrayList<Magazine> availableMagazines;

    public LibraryManager() {
        this.availableBooks = new ArrayList<>();
        this.availableMagazines = new ArrayList<>();
        initializeLibrary();
    }

    public ArrayList<Book> getAvailableBooks() {
        return availableBooks;
    }

    public ArrayList<Magazine> getAvailableMagazines() {
        return availableMagazines;
    }

    private void initializeLibrary() {
        availableBooks.add(new Book("Narnia", "ISBN1", "Fiction", 19.99));
        availableBooks.add(new Book("Facismo", "ISBN2", "Non-Fiction", 24.99));
        availableBooks.add(new Book("Soldados", "ISBN3", "Mystery", 14.99));

        availableMagazines.add(new Magazine("Coiffe", "ISSN1", "Fashion", 9.99));
        availableMagazines.add(new Magazine("Tesla", "ISSN2", "Science", 12.99));
        availableMagazines.add(new Magazine("Boston", "ISSN3", "Travel", 8.99));
    }

    public void displayLibrary() {
        System.out.println("\nRecursos de biblioteca:");
        System.out.println("Libros:");
        for (Book book : availableBooks) {
            System.out.println("- " + book.getName() + " - ISBN: " + book.getISBN() + " - Precio: $" + book.getPrice());
        }
        System.out.println("Revistas:");
        for (Magazine magazine : availableMagazines) {
            System.out.println("- " + magazine.getName() + " - ISSN: " + magazine.getISSN() + " - Precio: $" + magazine.getPrice());
        }
    }

    public Book findBook(ArrayList<Book> books, String name) {
        for (Book book : books) {
            if (book.getName().equalsIgnoreCase(name)) {
                return book;
            }
        }
        return null;
    }

    public Magazine findMagazine(ArrayList<Magazine> magazines, String name) {
        for (Magazine magazine : magazines) {
            if (magazine.getName().equalsIgnoreCase(name)) {
                return magazine;
            }
        }
        return null;
    }
}