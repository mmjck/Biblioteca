package com.tap.biblioteca;

/**
 * Classe Reserve - Representa uma reserva na aplicação
 *
 * @author Jackson Matheus dos Santos &lt;msantos@icomp.ufam.edu.br&gt;
 * @version 1.0, 2021-10-28
 *
 */
public class Reserva {

    private int idReserve;

    private int idBook;

    private int idAdmin;

    private int idClient;
    private String dateStart;
    private String dateFinish;
    private String status;

    private String title;

    private String description;
    private String yearPublication;
    private String publisher;
    private int isAvailable;

    private String name;

    /**
     *
     * @param idBook          Identificador do livro
     *
     * @param idAdmin         Identificador do dono
     * @param idClient        Identificador do cliente
     * @param dateStart       Data de inicio
     * @param dateFinish      Data de devoluçao
     * @param status          Status da reserva
     * @param title           Título do livro
     * @param description     Descrição do livro
     * @param yearPublication ano de publicaçao
     * @param publisher       Editora
     * @param idUser          Identificador do usuário dono do livro
     * @param available       Se o livro estará disponivel para emprestimo
     *
     * @param name            Nome do dono do liveo
     * @return boolean Resultado da operaçao
     *
     */
    public Reserva(int idReserve, int idBook, int idAdmin, int idClient, String dateStart, String dateFinish,
                   String status, String title, String description, String yearPublication, String publisher, int isAvailable,
                   String name) {
        super();
        this.idReserve = idReserve;
        this.idBook = idBook;
        this.idAdmin = idAdmin;
        this.idClient = idClient;

        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.status = status;
        this.title = title;
        this.description = description;
        this.yearPublication = yearPublication;
        this.publisher = publisher;
        this.isAvailable = isAvailable;
        this.name = name;
    }

    /**
     * Pega o identificador do usuário/admin
     *
     * @return Int Identificador do usuário/admin
     */
    public int getIdAdmin() {
        return idAdmin;
    }

    /**
     * Atribui o identificador do usuário/admin
     *
     * @param id Identificador do usuário/admin
     */
    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    /**
     * Pega o identificador do usuário/cliente
     *
     * @return Int Identificador do usuário/client
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * Atribui o identificador do usuário/cliente
     *
     * @param id Identificador do usuário/cliente
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * Pega o título do livro
     *
     * @return Título do livro
     */
    public String getTitle() {
        return title;
    }

    /**
     * Atribui o título do livro
     *
     * @param title Título do livro
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Atribui a descrição do livro
     *
     * @param description Descrição do livro
     */
    public String getDescription() {
        return description;
    }

    /**
     * Atribui a descrição do livro
     *
     * @param description Descrição do livro
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Pega o ano de publicação do livro
     *
     * @return String Ano de publicação
     */
    public String getYearPublication() {
        return yearPublication;
    }

    /**
     * Atribui o ano de publicaçao a um livro
     *
     * @param yearPublication Ano de publicação
     */
    public void setYearPublication(String yearPublication) {
        this.yearPublication = yearPublication;
    }

    /**
     * Retorna a editora daquele livro
     *
     * @return String editora do livro
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Atribui uma editora a um livro
     *
     * @param publisher Editora do livro
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Pega a disponibilidade do livro
     *
     * @return Boolean Disponibilidade do livro
     */
    public int getIsAvailable() {
        return isAvailable;
    }

    /**
     * Disponibilidade do livro
     *
     * @param isAvailable Atribui a disponibilidade do livro
     */
    public void setIsAvailable(int isAvailable) {
        this.isAvailable = isAvailable;
    }

    /**
     * Pega o nome do dono do livro
     *
     * @return String Nome do dono do livro
     */
    public String getName() {
        return name;
    }

    /**
     * Atribui o nome do dono do livro
     *
     * @param name Nome do dono do livro
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Pega o identificador do reserva
     *
     * @return Int Indentificador do reserva
     */
    public int getIdReserve() {
        return idReserve;
    }

    /**
     * Atribui o Identificador da reserva
     *
     * @param idReserve Identificador da reserva
     */
    public void setIdReserve(int idReserve) {
        this.idReserve = idReserve;
    }

    /**
     * Pega o identificador do livro
     *
     * @return Int Identificador do livro
     */
    public int getIdBook() {
        return idBook;
    }

    /**
     * Atribui o identificador do livro
     *
     * @param idBook Identificador do livro
     */
    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    /**
     * Pega a data de inicio da reserva
     *
     * @return String Data de inicio da reserva
     */
    public String getDateStart() {
        return dateStart;
    }

    /**
     * Atribui a data de inicio a reserva
     *
     * @param dateStart Data de inicio a reserva
     */
    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    /**
     * Pega a data de devolução
     *
     * @return String Data de devolução
     */
    public String getDateFinish() {
        return dateFinish;
    }

    /**
     * Atribui a data de devolução
     *
     * @param dateFinish Data de devolução
     */
    public void setDateFinish(String dateFinish) {
        this.dateFinish = dateFinish;
    }

    /**
     * Pega o status da reserva
     *
     * @return String Status da reserva
     */
    public String getStatus() {
        return status;
    }

    /**
     * Atribui o status da reserva
     *
     * @param status Status da reserva
     */
    public void setStatus(String status) {
        this.status = status;
    }

}
