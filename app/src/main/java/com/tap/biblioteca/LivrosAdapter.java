package com.tap.biblioteca;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.hefesto.biblioteca.R;

import java.util.ArrayList;

class LivrosAdapter extends RecyclerView.Adapter<LivroViewHolder> {
    private Context context;
    private ArrayList<Livro> livros;
    LivroDAO livroDao;


    public LivrosAdapter(Context context ) {
        this.context = context;
        livroDao = new LivroDAO(context);
        update();
    }


    public void update() {
        livros = livroDao.getAllBooksByUser(2);


    }



    public LivroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ConstraintLayout v = (ConstraintLayout) LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.livro_item, parent, false);
        LivroViewHolder vh = new LivroViewHolder(v, context);
        return vh;
    }



    public void onBindViewHolder(LivroViewHolder holder, int position) {
        //holder.autor.setText(livros.get(position).getAuthor());
        holder.descricao.setText(livros.get(position).getDescription());
        holder.title.setText(livros.get(position).getTitle());
        holder.editora.setText(livros.get(position).getPublisher());
        holder.ano.setText(livros.get(position).getYearPublication());

        if(livros.get(position).isAvailable() == 1){
            holder.disponivel.setText("Disponivel");

        }else{
            holder.disponivel.setText("Indisponivel");
            holder.disponivel.setTextColor(Color.RED);


        }
        holder.id = livros.get(position).getId();
    }
    public int getItemCount() {
        return livros.size();
    }
}
