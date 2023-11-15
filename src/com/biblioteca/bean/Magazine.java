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
 * La clase Magazine representa una revista en el sistema.
 */
public class Magazine {
    private String name;
    private String ISSN;
    private String type;
    private double price;

    /**
     * Construye un nuevo objeto Magazine con el nombre, ISSN, tipo y precio especificados.
     *
     * @param name   El nombre de la revista.
     * @param ISSN   El número ISSN de la revista.
     * @param type   El tipo de la revista.
     * @param price  El precio de la revista.
     */
    public Magazine(String name, String ISSN, String type, double price) {
        this.name = name;
        this.ISSN = ISSN;
        this.type = type;
        this.price = price;
    }

    /**
     * Obtiene el nombre de la revista.
     *
     * @return El nombre de la revista.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene el número ISSN de la revista.
     *
     * @return El número ISSN de la revista.
     */
    public String getISSN() {
        return ISSN;
    }

    /**
     * Obtiene el precio de la revista.
     *
     * @return El precio de la revista.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Devuelve una representación en cadena del objeto Magazine.
     *
     * @return Una representación en cadena del objeto Magazine, incluyendo nombre, ISSN, tipo y precio.
     */
    @Override
    public String toString() {
        return "Magazine{" +
                "name='" + name + '\'' +
                ", ISSN='" + ISSN + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}