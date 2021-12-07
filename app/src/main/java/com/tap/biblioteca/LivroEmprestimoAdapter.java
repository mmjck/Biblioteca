package com.tap.biblioteca;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.hefesto.biblioteca.R;

import java.util.ArrayList;

public class LivroEmprestimoAdapter extends RecyclerView.Adapter<LivroEmprestimoViewHolder> {
    private Context context;
    private ArrayList<Livro> livros;
    LivroDAO livroDao;


    public LivroEmprestimoAdapter(Context context) {
        this.context = context;
        livroDao = new LivroDAO(context);
        update();
    }
    public void update() {

        livros = livroDao.getAllBooks(1);
    }
    public LivroEmprestimoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ConstraintLayout v = (ConstraintLayout) LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.livros_emprestimos_item, parent, false);
        LivroEmprestimoViewHolder vh = new LivroEmprestimoViewHolder(v, context);
        return vh;
    }
    public void onBindViewHolder(LivroEmprestimoViewHolder holder, int position) {
        System.out.println("ola" + livros.get(position).getAuthor());
        holder.autor.setText(livros.get(position).getAuthor());
        holder.descricao.setText(livros.get(position).getDescription());
        holder.title.setText(livros.get(position).getTitle());
        holder.editora.setText(livros.get(position).getPublisher());


        holder.idBook = livros.get(position).getId();


        //consertar
        holder.idUser = 1;


        //dono do livro
        holder.idUser = livros.get(position).getIdUser();
    }
    public int getItemCount() {

        return livros.size();
    }
}
