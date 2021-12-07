package com.tap.biblioteca;

public class Livro {
    private int id;
    private String title;
    private String description;
    private String yearPublication;
    private String publisher;
    private int idUser;
    private int isAvailable;



    private String author;
    /**
     *
     * @param id              Identificador do livro
     * @param title           Título do livro
     * @param description     Descrição do livro
     * @param yearPublication ano de publicaçao
     * @param publisher       Editora
     * @param idUser          Identificador do usuário dono do livro
     * @param isAvailable       Se o livro estará disponivel para emprestimo
     */
    public Livro(int id, String author,  String title, String description, String yearPublication, String publisher, int isAvailable,
                 int idUser) {
        super();
        this.id = id;
        this.idUser = idUser;

        this.title = title;
        this.description = description;
        this.yearPublication = yearPublication;
        this.publisher = publisher;
        this.isAvailable = isAvailable;

    }
    /**
     * Pega o nome do autor  do livro
     *
     * @return String autor
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Atribui o autor do livro
     *
     * @param author Nome do autor
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Pega o Identificador do usuario dono do livro
     *
     * @return int Identificador
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * Atribui o identificador do usuario
     *
     * @param idUser Identificador do usuario
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * Pega a disponibilidade do livro
     *
     * @return Boolean Disponibilidade do livro
     */
    public int isAvailable() {
        return isAvailable;
    }

    /**
     * Disponibilidade do livro
     *
     * @param isAvailable Atribui a disponibilidade do livro
     */
    public void setAvailable(int isAvailable) {
        this.isAvailable = isAvailable;
    }

    /**
     * Pega identificador do livro
     *
     * @return Int Identificador do livro
     */
    public int getId() {
        return id;
    }

    /**
     * Atribui identificador do livro
     *
     * @param id Itendificador do livro
     */
    public void setId(int id) {
        this.id = id;
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
     * @return String Descrição do livro
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




}
