package com.tap.biblioteca;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.hefesto.biblioteca.R;

public class LivroEmprestimoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public Context context;
    public int idUser, idBook, idAmin;
    public Button fazerReserva;
    private Dialog dialog;
    public TextView autor, descricao,title, editora;

    public LivroEmprestimoViewHolder(ConstraintLayout v, Context context) {
        super(v);
        this.context = context;

        fazerReserva = v.findViewById(R.id.buttonFazerReserva);
        v.setOnClickListener(this);

        autor = v.findViewById(R.id.autorInfoLivroEmprestimo);
        title = v.findViewById(R.id.titleLivroEmprestimo);
        editora = v.findViewById(R.id.editoraLivroEmprestimo);
        descricao = v.findViewById(R.id.descricaoInfoLivroEmprestimo);

        dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_confirm_reserve);

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        Button close = dialog.findViewById(R.id.cancelarReserva);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        Button reserva = dialog.findViewById(R.id.reservaOk);
        reserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText data = dialog.findViewById(R.id.dataEntrega);
                ReservaDAO reservaDAO = new ReservaDAO(context);

                reservaDAO.create(1, 1, 1,  "11/12/2021", "13/12/2021", "pendente");
                dialog.dismiss();
            }
        });

        fazerReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
    }



    public void onClick(View v) {
        System.out.println("aaa");
    }

}