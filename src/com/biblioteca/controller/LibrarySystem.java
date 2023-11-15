/*
 * Universidad del Valle de Guatemala
 * POO - seccion 10
 * Roberto Barreda - 23354
 */

package com.biblioteca.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.biblioteca.bean.BaseUser;
import com.biblioteca.bean.LoanManager;
import com.biblioteca.bean.PremiumUser;
import com.biblioteca.bean.User;

/**
 * La clase LibrarySystem representa el sistema principal de la biblioteca.
 */
public class LibrarySystem {
    private User currentUser;
    private Scanner scanner;
    private ArrayList<User> userList;
    LibraryManager libraryManager = new LibraryManager();
    LoanManager loanManager = new LoanManager(libraryManager);
    private static final int MAX_BOOKS_BASE = 3;
    private static final int MAX_BOOKS_PREMIUM = 5;
    private static final int MAX_MAGAZINES_BASE = 9999;
    private static final int MAX_MAGAZINES_PREMIUM = 9999;

    public LibrarySystem() {
        this.userList = new ArrayList<>();
        this.currentUser = null;
        this.libraryManager = new LibraryManager();
        this.loanManager = new LoanManager(libraryManager);
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            showMainMenu();
            int userChoice = readIntegerInput();
            scanner.nextLine();

            switch (userChoice) {
                case 1:
                    registerUser();
                    saveUsersToCSV();
                    break;

                case 2:
                    login();
                    break;

                case 3:
                    if (currentUser != null) {
                        handleUserActions();
                    } else {
                        System.out.println("Debes iniciar sesión de primero.");
                    }
                    break;

                case 4:
                    libraryManager.displayLibrary();
                    break;

                case 5:
                    if (currentUser != null && !currentUser.isPremium()) {
                        changePlan();
                    } else {
                        System.out.println("Opción no válida para usuarios premium.");
                    }
                    break;
                
                case 6:
                    saveLoansToCSV();
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Elige de nuevo.");
            }
        }
    }

    private void showMainMenu() {
        System.out.println("\nMenú principal:");
        System.out.println("1. Registro");
        System.out.println("2. Inicio de sesión");
        System.out.println("3. Acciones de usuario");
        System.out.println("4. Biblioteca");
        System.out.println("5. Cambiar de plan");
        System.out.println("6. Salida");
        System.out.print("Escribe tu opción: ");
    }

    private void registerUser() {
        System.out.println("\nRegistro:");
        System.out.print("Escriba su usuario: ");
        String username = scanner.nextLine();

        System.out.print("Escriba su contraseña: ");
        String password = scanner.nextLine();

        System.out.println("Elija un plan:");
        System.out.println("1. Básico (gratuito)");
        System.out.println("2. Premium (Pagado)");
        System.out.print("Escriba su opción: ");
        int planChoice = scanner.nextInt();
        scanner.nextLine();

        User newUser;
        if (planChoice == 1) {
            newUser = new BaseUser(username, password);
        } else if (planChoice == 2) {
            newUser = new PremiumUser(username, password);
        } else {
            System.out.println("Opción inválida. Registro fallido.");
            return;
        }

        userList.add(newUser);  // Añadir el nuevo usuario a la lista
        currentUser = newUser;

        System.out.println("Registro concluido. Bienvenido, " + currentUser.getUsername() + "!");
    }

    private void login() {
        System.out.println("\nInicio de sesión:");
        System.out.print("Ingrese su usuario: ");
        String username = scanner.nextLine();
    
        System.out.print("Ingrese su contraseña: ");
        String password = scanner.nextLine();
    
        // Verifica si el usuario ya existe
        User existingUser = findUser(username);
    
        if (existingUser != null && existingUser.getPassword().equals(password)) {
            currentUser = existingUser;
            System.out.println("Inicio de sesión exitoso. Bienvenido, " + currentUser.getUsername() + "!");
        } else {
            System.out.println("Inicio de sesión fallido. Usuario o contraseña incorrectos.");
        }
    }
    
    private User findUser(String username) {
        // Verifica si el usuario ya existe en la lista de usuarios
        if (currentUser instanceof BaseUser && currentUser.getUsername().equals(username)) {
            return currentUser;
        } else if (currentUser instanceof PremiumUser && currentUser.getUsername().equals(username)) {
            return currentUser;
        }
        return null;
    }
    

    private void handleUserActions() {
        boolean exitUserMenu = false;
    
        while (!exitUserMenu) {
            showUserMenu();
            int userChoice = scanner.nextInt();
            scanner.nextLine();
    
            switch (userChoice) {
                case 1:
                    libraryManager.displayLibrary();
                    break;
    
                case 2:
                    System.out.println("Máximo de libros permitidos: " +
                            (currentUser.isPremium() ? MAX_BOOKS_PREMIUM : MAX_BOOKS_BASE));
                    System.out.println("Máximo de revistas permitidas: " +
                            (currentUser.isPremium() ? MAX_MAGAZINES_PREMIUM : MAX_MAGAZINES_BASE));
                    loanManager.processLoan(currentUser, libraryManager.getAvailableBooks(),
                            libraryManager.getAvailableMagazines(), scanner);
                    break;
    
                case 3:
                    loanManager.printLoanList(currentUser);
                    break;
    
                case 4:
                    loanManager.saveLoansToCSV();
                    System.out.println("Datos de prestamos guardados en CSV.");
                    break;
    
                case 5:
                    exitUserMenu = true;
                    System.out.println("Regresando al menú principal.");
                    break;
    
                default:
                    System.out.println("Opción inválida. Escriba una opción válida.");
            }
        }
    }
    
    private void changePlan() {
        if (!currentUser.isPremium()) {
            System.out.println("\nCambiar de plan:");
            System.out.println("1. Cambiar a Premium");
            System.out.println("2. Regresar al menú principal");
            System.out.print("Escriba su opción: ");
            int planChoice = scanner.nextInt();
            scanner.nextLine();
            if (planChoice == 1) {
                currentUser.setPremium(true);
                System.out.println("Cambiado a plan Premium exitosamente.");
            } else if (planChoice == 2) {
                System.out.println("Regresando al menú principal.");
            } else {
                System.out.println("Opción inválida. Cambio de plan cancelado.");
            }
        } else {
            System.out.println("Ya eres un usuario Premium.");
        }
    }
    

    private void showUserMenu() {
        System.out.println("\nMenú de usuario:");
        System.out.println("1. Display de biblioteca");
        System.out.println("2. Prestar recurso");
        System.out.println("3. imprimir lista de préstamos");
        System.out.println("4. Guardar préstamos a CSV");
        System.out.println("5. Regresar al menú principal");
        System.out.print("Ingrese su opción: ");
    }

    private void saveLoansToCSV() {
        loanManager.saveLoansToCSV();
        System.out.println("Datos de prestamos guardados en CSV.");
    }

    // Método para guardar información de usuarios en CSV
    public void saveUsersToCSV() {
        try (FileWriter writer = new FileWriter("users.csv")) {
            for (User user : userList) {
                writer.write(user.getUsername() + "," +
                        user.getPassword() + "," +
                        user.isPremium() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int readIntegerInput() {
        while (true) {
            try {
                System.out.print("Ingrese su opción: ");
                int option = scanner.nextInt();
                scanner.nextLine();
                return option;
            } catch (InputMismatchException e) {
                System.out.println("Input inválido. Ingrese un número.");
                scanner.nextLine();
            }
        }
    }      
}

