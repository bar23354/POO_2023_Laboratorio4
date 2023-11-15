/*
 * Universidad del Valle de Guatemala
 * POO - seccion 10
 * Roberto Barreda - 23354
 */

  /*
  * Javadoc añadido usando ChatGPT con el prompt: añade Javadoc a las siguientes clases que te compartiré.
  */
package com.biblioteca.bean;

/**
 * La clase Book representa un libro en el sistema.
 */
public class Book {
    private String name;
    private String ISBN;
    private String type;
    private double price;

    /**
     * Construye un nuevo objeto Book con el nombre, ISBN, tipo y precio especificados.
     *
     * @param name   El nombre del libro.
     * @param ISBN   El número ISBN del libro.
     * @param type   El tipo de libro.
     * @param price  El precio del libro.
     */
    public Book(String name, String ISBN, String type, double price) {
        this.name = name;
        this.ISBN = ISBN;
        this.type = type;
        this.price = price;
    }

    /**
     * Obtiene el nombre del libro.
     *
     * @return El nombre del libro.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene el número ISBN del libro.
     *
     * @return El número ISBN del libro.
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Obtiene el precio del libro.
     *
     * @return El precio del libro.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Devuelve una representación en cadena del objeto Book.
     *
     * @return Una representación en cadena del objeto Book, incluyendo nombre, ISBN, tipo y precio.
     */
    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}

