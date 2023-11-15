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
 * La clase PremiumUser representa un usuario premium en el sistema, que tiene estado premium.
 * Extiende la clase User.
 */
public class PremiumUser extends User {
    
    /**
     * Construye un nuevo objeto PremiumUser con el nombre de usuario y la contraseña especificados.
     * Este constructor establece el estado premium como verdadero por defecto.
     *
     * @param username El nombre de usuario del usuario premium.
     * @param password La contraseña del usuario premium.
     */
    public PremiumUser(String username, String password) {
        super(username, password, true);
    }
}
