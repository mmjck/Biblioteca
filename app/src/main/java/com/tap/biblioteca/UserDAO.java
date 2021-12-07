package com.tap.biblioteca;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class UserDAO {
    private Context context;
    private SQLiteDatabase database;



    public UserDAO(Context context) {
        this.context = context;
        this.database = (new Database(context)).getWritableDatabase();
    }

    /**
     * Cria um novo usuario
     *
     * @param name     Nome do usuario
     * @param email    Email do usuario
     * @param password Senha do usuario
     * @return User Usuario criado
     */
    public User create(String name, String email, String password) {
        try {
            database.execSQL("INSERT INTO user (name, email, password) VALUES ('" + name + "', '" + email
                    + "', '" + password + "')");

            Cursor cursor = database.rawQuery("SELECT * FROM user WHERE email='" + email + "'", null);
            if (cursor.moveToNext()) {
                return new User(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
            }
            return null;
        } catch (SQLException e) {
            Toast.makeText(context, "Erro ao cadastrar usuário!", Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    /**
     * Pega um usuario pelo seu identificador
     *
     * @param idUser Identificador do usuario
     * @return User Usuario selecionado
     */
    public User getById(int idUser) {
        try {
            Cursor cursor = database.rawQuery("SELECT * FROM user WHERE idUser='" + idUser + "'", null);

            if (cursor.moveToNext()) {
                return new User(cursor.getInt(1), cursor.getString(2), cursor.getString(3));
            }

            return null;
        } catch (SQLException e) {
            return null;

        }
    }

    /**
     * Faz o login de um usuario
     *
     * @param email    Email do usuario
     * @param password Senha do usuario
     * @return User Usuario referente aquele login
     */
    public User authUser(String email, String password) {
        try {
            Cursor cursor = database.rawQuery("SELECT * FROM user WHERE email='" + email + "'", null);

            if (cursor.moveToNext()) {
                User user = new User(cursor.getInt(0), cursor.getString(1), cursor.getString(2));


                if (password.equals(cursor.getString(3))) {
                    return user;
                }

            }

            return null;
        } catch (SQLException e) {
            Toast.makeText(context, "Erro ao cadastrar usuário!", Toast.LENGTH_SHORT).show();

            return null;

        }
    }

    /**
     * Atualiza os dados do usuario
     *
     * @param name   Nome do usuario
     * @param email  Email do usuario
     * @param id Identificador do usuario
     * @return boolean Resultado da opecaçao
     */
    public boolean update(String name, String email, String senha, int id) {
        try {
            database.execSQL("UPDATE user SET "+
                    "name='" + name + "', " +
                    "email='" + email + "' , "+
                    "password='" + senha + "'  "+
                    "WHERE id=" + id);
            return true;
        } catch (SQLException e) {
            System.out.print(e);
            return false;

        }
    }


}
