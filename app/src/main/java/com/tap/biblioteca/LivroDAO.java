package com.tap.biblioteca;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class LivroDAO {
    private SQLiteDatabase database;
    private Context context;
    private static ArrayList<Livro> listLivros = new ArrayList<>();


    public LivroDAO(Context context) {

        this.context = context;
        this.database = (new Database(context)).getWritableDatabase();

    }

    /**
     * Cadastro de um novo livro
     *
     * @param title           Título do livro
     * @param description     Descrição do livro
     * @param yearPublication ano de publicaçao
     * @param publisher       Editora
     * @param idUser          Identificador do usuário dono do livro
     * @param available       Se o livro estará disponivel para emprestimo
     * @return boolean Sucesso da operação
     */
    public boolean create(String title, String author, String description, String yearPublication, String publisher, int idUser,
                          int available) {
        try {
            database.execSQL(
                    "INSERT INTO book(title, author, description, publisher, yearPublication, idUser, available) VALUES ('"
                            + title + "', '" + author + "', '" +  description + "', '" + publisher + "', '" + yearPublication + "', '"
                            + idUser + "', '" + available + "')");

            Toast.makeText(context, "Livro cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            return true;

        } catch (SQLException e) {
            Toast.makeText(context, "Erro ao cadastrar livro!", Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    /**
     * Pega um livro pelo id
     *
     * @param idBook Identificador do livro
     * @param idUser Identificador do usuario
     * @return Livro Livro resultado da busca
     */
    public Livro getById(int idBook, int idUser) {
        try {
            Cursor cursor = database.rawQuery("SELECT * FROM book WHERE idBook='" + idBook + "'", null);

            if (cursor.moveToNext()) {
                return new Livro(cursor.getInt(0), cursor.getString(2),  cursor.getString(1), cursor.getString(3), cursor.getString(4), cursor.getString(5),
                        cursor.getInt(6), cursor.getInt(7));
            }

            return null;
        } catch (SQLException e) {
            return null;

        }
    }

    /**
     * Pega todos os livros disponiveis para emprestimo
     *
     * @param idUser Identificador do usuário
     * @return Arraylist<Livro> Lista com os livros
     */
    public ArrayList<Livro> getAllBooks(int idUser) {
        try {
            Cursor cursor = database.rawQuery("SELECT * FROM book WHERE idUser !='" + idUser + "' AND available=1", null);

            ArrayList<Livro> list = new ArrayList<Livro>();
            while (cursor.moveToNext()) {
                list.add(new Livro(cursor.getInt(0), cursor.getString(2),  cursor.getString(1), cursor.getString(3), cursor.getString(4), cursor.getString(5),
                        cursor.getInt(6), cursor.getInt(7)));
            }
            System.out.println("alo"+  list.get(0).getTitle());
            return list;
        } catch (SQLException e) {
            Toast.makeText(context, "Erro", Toast.LENGTH_SHORT).show();

            return null;

        }
    }

    /**
     * Pega todos os livros do usuario
     *
     * @param idUser Identificador do usuario
     * @return ArrayList<Livro> Lista com os livros do usuario
     */
    public ArrayList<Livro> getAllBooksByUser(int idUser) {
        try {
            String sql = "SELECT * FROM book WHERE idUser=" + idUser;
            Cursor cursor = database.rawQuery(sql, null);


            ArrayList<Livro> list = new ArrayList<Livro>();
            while (cursor.moveToNext()) {
                list.add(new Livro(cursor.getInt(0), cursor.getString(2),  cursor.getString(1), cursor.getString(3), cursor.getString(4), cursor.getString(5),
                        cursor.getInt(6), cursor.getInt(7)));
            }

            return list;
        } catch (SQLException e) {
            Toast.makeText(context, "Erro", Toast.LENGTH_SHORT).show();
            return null;

        }
    }

    /**
     * Atualiza os dados de um livro
     *
     * @param title           Título do livro
     * @param description     Descrição do livro
     * @param yearPublication ano de publicaçao
     * @param publisher       Editora
     * @return boolean Sucesso da operação
     */
    public boolean update(int idLivro, String title, String description, String yearPublication, String publisher,
                          int isAvailable) {
        try {
            database.execSQL("UPDATE book SET publisher='" + publisher + "', yearPublication='" + yearPublication
                    + "', description='" + description + "',  available = '" + isAvailable + "',  title = '" + title
                    + "' WHERE idBook=" + idLivro);
            return true;
        } catch (SQLException e) {
            System.out.print(e);
            return false;

        }
    }

    /**
     * Deleta um livro pelo identicardor (id)
     *
     * @param idBook Identificador
     * @return boolean Sucesso da operação
     */
    public boolean delete(int idBook) {
        try {
            database.execSQL("DELETE FROM book WHERE idBook=" + idBook);
            return true;
        } catch (SQLException e) {
            System.out.print(e);
            return false;

        }
    }

    /**
     * Pega todos os livros do usuario que estão reservador
     *
     * @param idUser Identificador
     * @return ArrayList<Livro>
     */
    public ArrayList<Livro> getAllBooksFromUserIsReserve(int idUser) {
        try {
            Cursor cursor = database.rawQuery("SELECT * FROM book, reserve WHERE book.idUser='" + idUser
                    + "'AND book.idUser = reserve.idUser AND book.available=0'", null
            );

            ArrayList<Livro> list = new ArrayList<Livro>();
            while (cursor.moveToNext()) {
                list.add(new Livro(cursor.getInt(0), cursor.getString(2),  cursor.getString(1), cursor.getString(3), cursor.getString(4), cursor.getString(5),
                        cursor.getInt(6), cursor.getInt(7)));
            }

            return null;
        } catch (SQLException e) {
            System.out.print(e);
            return null;

        }
    }

    /**
     * Pega todos os livros do usuario pela disponibilidade
     *
     * @param idUser    Identificador
     * @param available Disponibilidade
     * @return ArrayList<Livro> Lista com os livros
     */
    public ArrayList<Livro> getAllBooksFromUserByAvailable(int idUser, boolean available) {
        try {
            Cursor cursor = database.rawQuery("SELECT * FROM book WHERE idUser='" + idUser + "'AND available= '" + available + "'", null);

            ArrayList<Livro> list = new ArrayList<Livro>();
            while (cursor.moveToNext()) {
                list.add(new Livro(cursor.getInt(0), cursor.getString(2),  cursor.getString(1), cursor.getString(3), cursor.getString(4), cursor.getString(5),
                        cursor.getInt(6), cursor.getInt(7)));
            }

            return list;
        } catch (SQLException e) {
            System.out.print(e);
            return null;

        }
    }

    /**
     * Atualiza os status de um livro
     *
     *
     * @param idLivro    Identificador do usuário dono do livro
     * @param isAvailable Se o livro estará disponivel para emprestimo
     * @return boolean Sucesso da operação
     */
    public boolean updateStatus(int idLivro, int isAvailable) {
        try {
            database.execSQL("UPDATE book SET   available = '" + isAvailable + "' WHERE idBook=" + idLivro);
            return true;
        } catch (SQLException e) {
            System.out.print(e);
            return false;

        }
    }
}
