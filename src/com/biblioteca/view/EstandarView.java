package com.biblioteca.view;

import com.biblioteca.bean.ResourcesLibrary;
import com.biblioteca.bean.Estandar;

import java.util.Scanner;

public class EstandarView {
    private Estandar user;

    public void borrow() {
        Scanner scanner = new Scanner(System.in);

        //Lógica para mostrar opciones y recopilar información para el préstamo :P
        System.out.println("Seleccione el recurso (libro/revista): ");
        ResourcesLibrary selectedResource = getSelectedResource();

        System.out.println("Ingrese la cantidad de días de préstamo: ");
        int days = getDays();

        System.out.println("Ingrese la sucursal para recoger el préstamo: ");
        String deliveryBranch = getDeliveryBranch();

        //Llamar al método borrow de la instancia de Estandar
        user.borrow(selectedResource, days, deliveryBranch);
    }

    //LLENAR LA LOGICA DE ESTO!!!
    private int getDays() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private ResourcesLibrary getSelectedResource() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del recurso que desea seleccionar: ");
        String resourceName = scanner.nextLine();

        //Psst! Aquí se podría buscar el recurso en la lista de recursos disponibles en la biblioteca 
        // y devolver la "instancia" correspondiente. Pero no se, por el momento devuelve null.
        return null;
    }

    //LLENAR LA LOGICA DE ESTO!!!
    private String getDeliveryBranch() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void printLoanList() {
        //Lógica para mostrar la lista de préstamos B)
        if (user.getLoan().isEmpty()) {
            System.out.println("No hay préstamos registrados.");
        } else {
            System.out.println("\nLista de Préstamos:");
            for (ResourcesLibrary resource : user.getLoan()) {
                System.out.println("- " + resource.getName() + " - Fecha de Devolución: " + resource.getDueDate());
            }
        }
    }
}
