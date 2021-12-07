package com.tap.biblioteca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.TextView;

import com.hefesto.biblioteca.R;

public class Emprestimos extends AppCompatActivity {
    private RecyclerView listaLivrosDisponiveis;
    private LivroEmprestimoAdapter adapter;
    private TextView testIsEmpty;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emprestimos);


        listaLivrosDisponiveis = findViewById(R.id.listaLivrosDisponiveis);
        listaLivrosDisponiveis.setLayoutManager(new LinearLayoutManager(this));
        adapter = new LivroEmprestimoAdapter(this);
        listaLivrosDisponiveis.setAdapter(adapter);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        adapter.update();
        adapter.notifyDataSetChanged();
    }
}