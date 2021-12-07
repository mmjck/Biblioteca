package com.tap.biblioteca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hefesto.biblioteca.R;

public class MeusEmprestimos extends AppCompatActivity {
    private RecyclerView listaReservas;
    private ReservaAdapter adapter;
    private Button novoEmprestimo;
    private Button pedidosReservas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_emprestimos);



        listaReservas = findViewById(R.id.listaLivrosEmprestados);
        listaReservas.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ReservaAdapter(this);

        listaReservas.setAdapter(adapter);

        novoEmprestimo = (Button) findViewById(R.id.novoEmprestimo);
        novoEmprestimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MeusEmprestimos.this, Emprestimos.class);
                startActivity(intent);
            }
        });



        pedidosReservas = findViewById(R.id.pedidosReserva);
        pedidosReservas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MeusEmprestimos.this, PedidosReservas.class);
                intent.putExtra("idUser", 1);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        adapter.update();
        adapter.notifyDataSetChanged();
    }


}