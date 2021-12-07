package com.tap.biblioteca;

import android.database.sqlite.SQLiteDatabase;

/**
 * Classe User - Representa um usuário na aplicaçao
 *
 * @author Jackson Matheus dos Santos &lt;msantos@icomp.ufam.edu.br&gt;
 * @version 1.0, 2021-10-28
 *
 */
public class User {
    private int id;
    private String name;
    private String email;
    /**
     *
     * @param id    Identificador do usuário
     * @param name  Nome do usuário
     * @param email Email do usuário
     */
    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;

    }

    /**
     * Pega o identificador do usuário
     *
     * @return Int Identificador do usuário
     */
    public int getId() {
        return id;
    }

    /**
     * Atribui o identificador do usuário
     *
     * @param id Identificador do usuário
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Pega o nome do usuário
     *
     * @return String Nome do usuário
     */
    public String getName() {
        return this.name;
    }

    /**
     * Atribui o nome do usuário
     *
     * @param name Nome do usuário
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Pega o email do usuário
     *
     * @return String Email do usuário
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Atribui o email do usuário
     *
     * @param email Email do usuário
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
