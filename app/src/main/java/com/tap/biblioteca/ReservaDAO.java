package com.tap.biblioteca;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ReservaDAO {

    private Context context;
    private SQLiteDatabase database;

    private static ArrayList<Reserva> listaReserva = new ArrayList<>();


    public ReservaDAO(Context context) {
        this.database = (new Database(context)).getWritableDatabase();

        this.context = context;
    }

    /**
     * Cria um novo pedido de reserva de livro
     *
     * @param idBook     Identificador do livro
     * @param idAdmin    Identificador do dono
     * @param idClient   Identificador do cliente
     * @param dateStart  Data de inicio
     * @param dateFinish Data de devoluçao
     * @param status     Status da reserva
     * @return boolean Resultado da operaçao
     */
    public boolean create(int idBook, int idAdmin, int idClient,

                          String dateStart, String dateFinish, String status) {
        try {
            database.execSQL(
                    "INSERT INTO reserve(idBook, idAdmin, idClient, dateStart, dateFinish, status ) VALUES ('" + idBook
                            + "', '" + idAdmin + "', '" + idClient + "', '" + dateStart + "', '" + dateFinish + "', '"
                            + status + "')");

            return true;
        } catch (SQLException e) {
            System.out.print(e);
            return false;
        }
    }

    /**
     * Atualiza o status de uma reserva
     *
     * @param idReserve Identificador da reserva
     * @param status    Status da reserva
     * @return boolean Resultado da opecaçao
     */
    public boolean updateStatus(int idReserve, String status) {
        try {
            database.execSQL("UPDATE reserve SET status='" + status + "' WHERE idReserve=" + idReserve);
            return true;
        } catch (SQLException e) {
            System.out.print(e);
            return false;

        }
    }

    /**
     * Deleta uma reserva
     *
     * @param idReserve Identificador da reserva
     * @return boolean Resultado da operaçao
     */
    public boolean delete(int idReserve) {
        try {
            database.execSQL("DELETE FROM reserve idReserve=" + idReserve);
            return true;
        } catch (SQLException e) {
            System.out.print(e);
            return false;

        }
    }

    /**
     * Pega todas as reservas que um usario fez, ou seja, os livros que ele deseja
     * emprestar
     *
     * @param idUser Identificador do usuario
     * @return ArrayList<Reserve> Lista com as reservas feitas
     */
    public ArrayList<Reserva> getAllReservesFromUser(int idUser) {
        try {
            Cursor cursor = database.rawQuery(
                    "SELECT  reserve.idReserve, reserve.idBook, reserve.idAdmin, reserve.idClient, reserve.dateStart, reserve.dateFinish, reserve.status, title, description, yearPublication, publisher, available, name  FROM reserve, book, user WHERE reserve.idClient='"
                            + idUser + "' AND book.idBook = reserve.idBook AND user.id = reserve.idClient",null);
            ArrayList<Reserva> listReserves = new ArrayList<>();
            while (cursor.moveToNext()) {

                listReserves.add(new Reserva(cursor.getInt(0), cursor.getInt(1), cursor.getInt(2), cursor.getInt(3), cursor.getString(4),
                        cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9),
                        cursor.getString(10), cursor.getInt(11), cursor.getString(12)));
            }

            return listReserves;
        } catch (SQLException e) {
            System.out.print(e);
            return null;

        }
    }

    /**
     * Pega todas os pedidos de reserva feitas por outros usuario
     *
     * @param idUser Identificador do usuário
     * @return ArrayList<Reserve> Lista com as reservas solicitadas
     */
    public ArrayList<Reserva> getAllReserves(int idUser) {
        try {
            Cursor cursor = database.rawQuery(
                    "SELECT reserve.idReserve, reserve.idBook, reserve.idAdmin, reserve.idClient, reserve.dateStart, reserve.dateFinish, reserve.status,  title, description, yearPublication, publisher, available, name  FROM reserve, book, user WHERE reserve.idAdmin='"
                            + idUser
                            + "' AND book.idBook = reserve.idBook AND user.id=reserve.idAdmin  AND reserve.status='pendente'", null);
            ArrayList<Reserva> listReserves = new ArrayList<>();
            while (cursor.moveToNext()) {
                listReserves.add(new Reserva(cursor.getInt(0), cursor.getInt(1), cursor.getInt(2), cursor.getInt(3), cursor.getString(4),
                        cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9),
                        cursor.getString(10), cursor.getInt(11), cursor.getString(12)));
            }

            return listReserves;
        } catch (SQLException e) {
            return null;

        }
    }

}
