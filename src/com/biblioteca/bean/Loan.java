/*
 * Universidad del Valle de Guatemala
 * POO - seccion 10
 * Roberto Barreda - 23354
 */

  /*
  * Javadoc añadido usando ChatGPT con el prompt: añade Javadoc a las siguientes clases que te compartiré.
  */
  
package com.biblioteca.bean;

import java.util.Date;

/**
 * La clase Loan representa un préstamo en el sistema.
 */
public class Loan {
    private User user;
    private Book book;
    private Magazine magazine; // Cambiado de "Magazine magazine" a "Magazine magazine"
    private Date startDate;
    private Date dueDate;

    /**
     * Constructor para un préstamo de revista.
     *
     * @param user      El usuario que realiza el préstamo.
     * @param magazine  La revista que se está prestando.
     * @param startDate La fecha de inicio del préstamo.
     * @param dueDate   La fecha de vencimiento del préstamo.
     */
    public Loan(User user, Magazine magazine, Date startDate, Date dueDate) {
        this.user = user;
        this.magazine = magazine;
        this.startDate = startDate;
        this.dueDate = dueDate;
    }

    /**
     * Constructor para un préstamo de libro.
     *
     * @param user      El usuario que realiza el préstamo.
     * @param book      El libro que se está prestando.
     * @param startDate La fecha de inicio del préstamo.
     * @param dueDate   La fecha de vencimiento del préstamo.
     */
    public Loan(User user, Book book, Date startDate, Date dueDate) {
        this.user = user;
        this.book = book;
        this.startDate = startDate;
        this.dueDate = dueDate;
    }

    /**
     * Obtiene el usuario asociado al préstamo.
     *
     * @return El usuario asociado al préstamo.
     */
    public User getUser() {
        return user;
    }

    /**
     * Obtiene el libro asociado al préstamo.
     *
     * @return El libro asociado al préstamo.
     */
    public Book getBook() {
        return book;
    }

    /**
     * Obtiene la revista asociada al préstamo.
     *
     * @return La revista asociada al préstamo.
     */
    public Magazine getMagazine() {
        return magazine;
    }

    /**
     * Obtiene la fecha de inicio del préstamo.
     *
     * @return La fecha de inicio del préstamo.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Obtiene la fecha de vencimiento del préstamo.
     *
     * @return La fecha de vencimiento del préstamo.
     */
    public Date getDueDate() {
        return dueDate;
    }
}
