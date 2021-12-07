package com.tap.biblioteca;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "biblioteca.db";



    private static final String SQL_CREATE_USER = "CREATE TABLE user (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name TEXT, email TEXT, password TEXT )";


    private static final String SQL_CREATE_BOOK = "CREATE TABLE book ( "+
            "idBook INTEGER PRIMARY KEY  AUTOINCREMENT,"+
            "title TEXT NOT NULL," +
            "author TEXT NOT NULL," +
            "description TEXT NOT NULL," +
            "yearPublication TEXT NOT NULL," +
            "publisher TEXT NOT NULL," +
            "available BOOL DEFAULT 1," +
            "idUser INT," +
            "CONSTRAINT fk_book FOREIGN KEY (idUser) REFERENCES user(idUser) );";


    private static final String SQL_CREATE_RESERVE = "CREATE TABLE reserve (" +
            "idReserve INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "idBook INTEGER, " +
            "idAdmin INTEGER," +
            "idClient INTEGER," +
            "dateStart TEXT NOT NULL," +
            "dateFinish TEXT, " +
            "status TEXT NOT NULL, " +
            "CONSTRAINT fk_reserve_book FOREIGN KEY (idBook) REFERENCES book(idBook), " +
            "CONSTRAINT fk_reserve_client FOREIGN KEY (idClient) REFERENCES user(idUser) );";

    private static final String SQL_POPULATE_USER1 = "INSERT INTO user (name, email, password) VALUES " +
            "('Harry Potter', 'harry@gmail.com', '1234')";

    private static final String SQL_POPULATE_USER2 = "INSERT INTO user (name, email, password) VALUES " +
            "('Ronald Weasley', 'ronald@gmail.com', '1234')";

    private static final String SQL_POPULATE_USER3 = "INSERT INTO user (name, email, password) VALUES " +
            "('Hermione Granger', 'hermione@gmail.com', '1234')";

    private static final String SQL_POPULATE_BOOK1 = "INSERT INTO book (title, author, description, publisher, yearPublication, available, idUser) VALUES " +
            "('Harry potter e a pedra filosofal', 'J.K. Rowling ', '----------', '2000', 'Rocco; 1ª edição (7 abril 2000)', 1, 1)";


    private static final String SQL_POPULATE_BOOK2 = "INSERT INTO book (title, author, description, yearPublication, publisher,available, idUser) VALUES " +
            "('A Garota Alemã', 'Armando Lucas Correia', '----------', '2017', 'Editora Jangada; 1ª edição (20 dezembro 2017)', 2, 1)";


    private static final String SQL_POPULATE_BOOK3 = "INSERT INTO book (title, author, description, yearPublication, publisher, available, idUser) VALUES " +
            "('A Garota Alemã', 'Armando Lucas Correia', '----------', '2017', 'Editora Jangada; 1ª edição (20 dezembro 2017)', 3, 1)";

    private static final String SQL_POPULATE_RESERVE = "INSERT INTO reserve(idBook, idAdmin, idClient, dateStart, dateFinish, status ) VALUES " +
            "(1, 2, 1, '11/12/2021','13/12/2021', 'pendente')";


    private static final String SQL_DELETE_USER = "DROP TABLE IF EXISTS user";
    private static final String SQL_DELETE_BOOK = "DROP TABLE IF EXISTS book";
    private static final String SQL_DELETE_RESERVE = "DROP TABLE IF EXISTS reserve";

    public Database(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_USER);
        db.execSQL(SQL_CREATE_BOOK);
        db.execSQL(SQL_CREATE_RESERVE);

        db.execSQL(SQL_POPULATE_USER1);
        db.execSQL(SQL_POPULATE_USER2);
        db.execSQL(SQL_POPULATE_USER3);

        db.execSQL(SQL_POPULATE_BOOK1);
        db.execSQL(SQL_POPULATE_BOOK2);
        db.execSQL(SQL_POPULATE_BOOK3);
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_USER);
        db.execSQL(SQL_DELETE_BOOK);
        db.execSQL(SQL_DELETE_RESERVE);

        onCreate(db);
    }
}
