package com.tap.biblioteca;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.hefesto.biblioteca.R;

public class PedidosReservaViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {

    public Context context;
    public int idUser, idBook, idAdmin, idReserve;
    public Button fazerReserva, aprovar, recusar;

    public TextView autor, descricao, title,  dataInicio, dataFim;

    public PedidosReservaViewHolder(ConstraintLayout v, Context context) {
        super(v);
        this.context = context;

        fazerReserva = v.findViewById(R.id.buttonFazerReserva);
        v.setOnClickListener(this);


        title = v.findViewById(R.id.titleReservaInfo);
        dataInicio = v.findViewById(R.id.dateStartReserva);
        dataFim = v.findViewById(R.id.dataFinishReserva);

        aprovar = v.findViewById(R.id.buttonAprovar);
        aprovar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ReservaDAO reservaDAO = new ReservaDAO(context);

                reservaDAO.updateStatus(idReserve, "Recusado");
                Toast.makeText(context, "Recusado", Toast.LENGTH_SHORT).show();

            }
        });

        recusar = v.findViewById(R.id.buttonRecusar);
        recusar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReservaDAO reservaDAO = new ReservaDAO(context);

                reservaDAO.updateStatus(idReserve, "Aprovado");
                Toast.makeText(context, "Aprovado", Toast.LENGTH_SHORT).show();
            }
        });


    }



    public void onClick(View v) {
        System.out.println("aaa");
    }

}