package com.tap.biblioteca;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.hefesto.biblioteca.R;

public class ReservaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public Context context;
    public TextView donoReserva, title;
    public int id;
    public ImageButton showInfoReserva;

    private Dialog dialog;
    public ReservaViewHolder(ConstraintLayout v, Context context) {
        super(v);
        this.context = context;

        showInfoReserva = v.findViewById(R.id.showInfoReserva);


        title = v.findViewById(R.id.titleReserva);
        donoReserva = v.findViewById(R.id.donoReserva);
        v.setOnClickListener(this);


        dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom_dialog);

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        Button close = dialog.findViewById(R.id.buttonClose);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        showInfoReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

    }

    public void onClick(View v) {
        Toast.makeText(context, "Olá " + this.donoReserva.getText().toString(), Toast.LENGTH_LONG)
                .show();
    }
}
