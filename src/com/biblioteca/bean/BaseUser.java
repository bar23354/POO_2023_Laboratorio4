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
 * La clase BaseUser representa un usuario base en el sistema, que no tiene estado premium.
 * Extiende la clase User.
 */
public class BaseUser extends User {
    
    /**
     * Construye un nuevo objeto BaseUser con el nombre de usuario y la contraseña especificados.
     * Este constructor establece el estado premium como falso por defecto.
     *
     * @param username El nombre de usuario del usuario base.
     * @param password La contraseña del usuario base.
     */
    public BaseUser(String username, String password) {
        super(username, password, false);
    }
}

