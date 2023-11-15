/*
 * Universidad del Valle de Guatemala
 * POO - seccion 10
 * Roberto Barreda - 23354
 */

  /*
  * Javadoc añadido usando ChatGPT con el prompt: añade Javadoc a las siguientes clases que te compartiré.
  */

package com.biblioteca.bean;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.biblioteca.controller.LibraryManager;

/**
 * La clase LoanManager gestiona los préstamos en el sistema de la biblioteca.
 */
public class LoanManager {
    private ArrayList<Loan> loans;
    private LibraryManager libraryManager;

    public LoanManager(LibraryManager libraryManager) {
        this.loans = new ArrayList<>();
        this.libraryManager = libraryManager;
    }

    public void processLoan(User user, ArrayList<Book> availableBooks, ArrayList<Magazine> availableMagazines, Scanner scanner) {
        if (availableBooks.isEmpty() && availableMagazines.isEmpty()) {
            System.out.println("No hay libros o revistas disponibles para prestar.");
            return;
        }

        System.out.println("Selecciona un recurso a prestar:");
        System.out.println("1. Libro");
        System.out.println("2. Revista");
        System.out.print("Ingresa tu opción: ");
        int resourceChoice = readIntegerInput(scanner);
        scanner.nextLine();

        if (resourceChoice == 1 && user.isPremium() && countLoans(user, Book.class) >= 5) {
            System.out.println("Los usuarios premium solo pueden prestar hasta 5 libros. Tu cuenta ha llegado al límite.");
            return;
        } else if (resourceChoice == 1 && !user.isPremium() && countLoans(user, Book.class) >= 3) {
            System.out.println("Usuarios base pueden prestar hasta 3 libros. Tu cuenta ha llegado al límite.");
            return;
        }        

        System.out.print("Ingresa el nombre del recurso: ");
        String resourceName = scanner.nextLine();

        if (resourceChoice == 1) {
            Book selectedBook = libraryManager.findBook(availableBooks, resourceName);
            if (selectedBook != null) {
                borrow(user, selectedBook, scanner);
                availableBooks.remove(selectedBook);
            } else {
                System.out.println("Libro no encontrado.");
            }
        } else if (resourceChoice == 2) {
            Magazine selectedMagazine = libraryManager.findMagazine(availableMagazines, resourceName);
            if (selectedMagazine != null) {
                borrow(user, selectedMagazine, scanner);
                availableMagazines.remove(selectedMagazine);
            } else {
                System.out.println("Revista no encontrada.");
            }
        } else {
            System.out.println("Opción inválida. Elije una opción válida.");
        }
    }

    public void borrow(User user, Book book, Scanner scanner) {
        System.out.print("Ingrese el número de días para el préstamo: ");
        int days = readIntegerInput(scanner);
        scanner.nextLine();

        if (user.isPremium() && days > 50) {
            System.out.println("Los usuarios premium solo pueden prestar hasta 50 días. Tu préstamo se ha ajustado a 50 días.");
            days = 50;
        } else if (!user.isPremium() && days > 30) {
            System.out.println("Usuarios base pueden prestar hasta 30 días. Tu préstamo se ha ajustado a 30 días.");
            days = 30;
        }

        Date currentDate = new Date();
        Date dueDate = addDays(currentDate, days);

        Loan loan = new Loan(user, book, currentDate, dueDate);
        loans.add(loan);

        System.out.println("Préstamo llevado a cabo exitosamente");
    }

    public void borrow(User user, Magazine magazine, Scanner scanner) {
        System.out.print("Ingrese el número de días para el préstamo: ");
        int days = readIntegerInput(scanner);
        scanner.nextLine();

        if (user.isPremium() && days > 50) {
            System.out.println("Los usuarios premium solo pueden prestar hasta 50 días. Tu préstamo se ha ajustado a 50 días.");
            days = 50;
        } else if (!user.isPremium() && days > 30) {
            System.out.println("Usuarios base pueden prestar hasta 30 días. Tu préstamo se ha ajustado a 30 días.");
            days = 30;
        }

        Date currentDate = new Date();
        Date dueDate = addDays(currentDate, days);

        Loan loan = new Loan(user, magazine, currentDate, dueDate);
        loans.add(loan);

        System.out.println("Préstamo llevado a cabo exitosamente");
    }

    public void printLoanList(User user) {
        System.out.println("\nLista de préstamos para " + user.getUsername() + ":");
        for (Loan loan : loans) {
            if (loan.getUser().equals(user) && loan.getBook() != null) {
                System.out.println("- " + loan.getBook().getName() +
                        " - Due Date: " + formatDate(loan.getDueDate()));
            }
        }
    }    

    public int countLoans(User user, Class<?> resourceType) {
        int count = 0;
        for (Loan loan : loans) {
            Book book = loan.getBook();
            if (book != null && loan.getUser().equals(user) && book.getClass().equals(resourceType)) {
                count++;
            }
        }
        return count;
    }
    

    public void saveLoansToCSV() {
        try (FileWriter writer = new FileWriter("loans.csv")) {
            for (Loan loan : loans) {
                if (loan.getBook() != null) { // Verificar si el libro no es nulo
                    writer.write(loan.getUser().getUsername() + "," +
                            loan.getBook().getName() + "," +
                            loan.getStartDate().toString() + "," +
                            loan.getDueDate().toString() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

    private int readIntegerInput(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Ingresa un número entero: ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un número entero válido.");
            }
        }
    }
}