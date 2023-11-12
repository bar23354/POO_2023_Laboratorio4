package com.biblioteca.bean;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Estandar extends User {
    public Estandar(String name, String password, String ID, ArrayList<ResourcesLibrary> loan, boolean isPremium) {
        super(name, password, ID, loan, isPremium);
    }

    @Override
    public void register() {
    }

    @Override
    public void login() {
    }

    @Override
    public void printLoanList() {
        if (loan.isEmpty()) {
            System.out.println("No hay préstamos registrados.");
        } else {
            System.out.println("\nLista de Préstamos:");
            for (ResourcesLibrary resource : loan) {
                System.out.println("- " + resource.getName() + " - Fecha de Devolución: " + formatDate(resource.getDueDate()));
            }
        }
    }    

    @Override
    public void borrow(ResourcesLibrary resource, int days, String deliveryBranch) {
        Scanner scanner = new Scanner(System.in);

        //Verifica si se ha seleccionado al menos 1 libro/revista
        if (loan.size() < 1) {
            System.out.println("No se puede procesar el préstamo, seleccione al menos 1 libro/revista.");
            return;
        }

        //Verifica restricciones para usuarios estándar
        if (resource instanceof Book) {
            int availableBooks = countAvailableBooks();

            if (availableBooks >= 3) {
                System.out.println("Los usuarios estándar pueden prestar hasta 3 libros como máximo.");
                return;
            }
        }

        //Lógica para procesar el préstamo para usuarios estándar
        System.out.println("Ingrese la hora de entrega (AM/PM): ");
        String deliveryTime = scanner.nextLine();

        //Asumiendo que ya tienes lógica para manejar préstamos en ResourcesLibrary y el manejo de fechas/horas
        Date currentDate = new Date();
        resource.setDueDate(addDays(currentDate, days));

        System.out.println("\nResumen del Préstamo:");
        System.out.println("Recurso Prestado: " + resource.getName());
        System.out.println("Fecha de Préstamo: " + formatDate(currentDate));
        System.out.println("Días de Préstamo: " + days);
        System.out.println("Hora de Entrega: " + deliveryTime);
        System.out.println("Sucursal para Recoger: " + deliveryBranch);

        //Agregar el préstamo a la lista
        loan.add(resource);

        System.out.println("\nPréstamo procesado con éxito.");
    }

    private int countAvailableBooks() {
        int count = 0;
        for (ResourcesLibrary resource : loan) {
            if (resource instanceof Book) {
                count++;
            }
        }
        return count;
    }

    private Date addDays(Date date, int days) {
        long timeInMillis = date.getTime() + (days * 24L * 3600 * 1000);
        return new Date(timeInMillis);
    }

    private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }
}
