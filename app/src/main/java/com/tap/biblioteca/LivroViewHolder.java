package com.tap.biblioteca;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.hefesto.biblioteca.R;


class LivroViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public Context context;
    public TextView autor, descricao;
    public TextView editora, title;
    public TextView ano, disponivel;

    public int id;
    public ImageButton showInfo;
    public ImageButton editLivro;

    private Dialog dialog;
    public LivroViewHolder(ConstraintLayout v, Context context) {
        super(v);
        this.context = context;

        showInfo = v.findViewById(R.id.showInfoLivro);


        autor = v.findViewById(R.id.itemAuthor);
        descricao = v.findViewById(R.id.itemDescription);
        editora = v.findViewById(R.id.itemPublisher);
        title = v.findViewById(R.id.itemTitle);
        ano = v.findViewById(R.id.anoItem);
        disponivel =  v.findViewById(R.id.estaDisponivel);
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

        showInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });



        editLivro = (ImageButton) v.findViewById(R.id.editLivro);
        editLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, DadosLivro.class);
                intent.putExtra("title", title.getText());
                intent.putExtra("description", descricao.getText());
                intent.putExtra("autor", autor.getText());
                intent.putExtra("ano", ano.getText());
                intent.putExtra("editora", editora.getText());
                intent.putExtra("idBook", id);

                if(disponivel.getText().equals("disponivel")){
                    intent.putExtra("isAvailable", "1");

                }else{
                    intent.putExtra("isAvailable", "0");

                }

                context.startActivity(intent);
            }
        });



    }



    public void onClick(View v) {

    }

}