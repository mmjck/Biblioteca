package com.tap.biblioteca;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.hefesto.biblioteca.R;

import java.util.ArrayList;

public class PedidosAdapter extends RecyclerView.Adapter<PedidosReservaViewHolder> {
    private Context context;
    private ArrayList<Reserva> reservas;
    ReservaDAO reservaDAO;


    public PedidosAdapter(Context context) {
        this.context = context;
        reservaDAO = new ReservaDAO(context);
        update();
    }


    public void update() {

        reservas = reservaDAO.getAllReserves(1);
    }


    public PedidosReservaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ConstraintLayout v = (ConstraintLayout) LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_item_pedidos_reserva, parent, false);
        PedidosReservaViewHolder vh = new PedidosReservaViewHolder(v, context);


        return vh;
    }


    public void onBindViewHolder(PedidosReservaViewHolder holder, int position) {
        holder.title.setText(reservas.get(position).getTitle());

        holder.dataInicio.setText(reservas.get(position).getDateStart());
        holder.dataFim.setText(reservas.get(position).getDateFinish());


        holder.idBook = reservas.get(position).getIdBook();
        holder.idAdmin = reservas.get(position).getIdAdmin();
        holder.idUser = reservas.get(position).getIdAdmin();
        holder.idReserve = reservas.get(position).getIdReserve();

    }



    public int getItemCount() {
        return reservas.size();
    }
}
