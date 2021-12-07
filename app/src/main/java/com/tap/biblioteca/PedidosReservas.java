package com.tap.biblioteca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hefesto.biblioteca.R;

public class PedidosReservas extends AppCompatActivity {
    private RecyclerView listReservas;
    private PedidosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos_reservas);

        listReservas = findViewById(R.id.listaPedidosReservas);
        listReservas.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PedidosAdapter(this);

        listReservas.setAdapter(adapter);

    }
}