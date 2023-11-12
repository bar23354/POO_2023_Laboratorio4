package com.biblioteca.bean;

import java.util.Date;

public class ResourcesLibrary {

    private String name;
    private String ISBN;
    private String type;
    private double price;
    private Date dueDate;  // Fecha de devolución

    public ResourcesLibrary(String name, String ISBN, String type, double price) {
        this.name = name;
        this.ISBN = ISBN;
        this.type = type;
        this.price = price;
        this.dueDate = null;  // Inicialmente no hay fecha de devolución
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
