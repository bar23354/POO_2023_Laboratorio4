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
 * La clase User representa a un usuario en el sistema.
 */
public class User {
    private String username;
    private String password;
    private boolean isPremium;

    /**
     * Construye un nuevo objeto User con el nombre de usuario, la contraseña y el estado premium especificados.
     *
     * @param username   El nombre de usuario del usuario.
     * @param password   La contraseña del usuario.
     * @param isPremium  Un booleano que indica si el usuario tiene un estado premium.
     */
    public User(String username, String password, boolean isPremium) {
        this.username = username;
        this.password = password;
        this.isPremium = isPremium;
    }

    /**
     * Obtiene el nombre de usuario del usuario.
     *
     * @return El nombre de usuario del usuario.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Verifica si el usuario tiene un estado premium.
     *
     * @return {@code true} si el usuario es premium, {@code false} en caso contrario.
     */
    public boolean isPremium() {
        return isPremium;
    }

    /**
     * Cambia el estado de un usuario base a premium.
     *
     * @return {@code true} si el usuario no es premium, {@code false} en caso contrario.
     */
    public void setPremium(boolean premium) {
        this.isPremium = premium;
    }

    /**
     * Devuelve una representación en cadena del objeto User.
     *
     * @return Una representación en cadena del objeto User, incluyendo nombre de usuario, contraseña y estado premium.
     */
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isPremium=" + isPremium +
                '}';
    }
}
