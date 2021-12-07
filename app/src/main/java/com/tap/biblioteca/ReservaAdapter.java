package com.tap.biblioteca;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.hefesto.biblioteca.R;

import java.util.ArrayList;

public class ReservaAdapter extends RecyclerView.Adapter<ReservaViewHolder>{
    private Context context;
    private ArrayList<Reserva> reservas;
    ReservaDAO reservaDao;


    public ReservaAdapter(Context context) {
        this.context = context;
        reservaDao = new ReservaDAO(context);
        update();
    }
    public void update() {
        reservas = reservaDao.getAllReservesFromUser(1);
    }


    public ReservaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ConstraintLayout v = (ConstraintLayout) LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.emprestimo_item, parent, false);
        ReservaViewHolder vh = new ReservaViewHolder(v, context);
        return vh;
    }



    public void onBindViewHolder(ReservaViewHolder holder, int position) {
        holder.title.setText(reservas.get(position).getTitle());
        holder.donoReserva.setText(reservas.get(position).getName());
        holder.id = reservas.get(position).getIdReserve();
    }
    public int getItemCount() {

        return reservas.size();
    }
}
