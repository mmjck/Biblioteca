package com.tap.biblioteca;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hefesto.biblioteca.R;

public class Home extends AppCompatActivity {
    private RecyclerView listLivros;
    private LivrosAdapter adapter;
    private TextView nomeUsuario;
    private TextView emailUsuario;
    private Button buttoonEmprestimos;
    private int idUser;
    private FloatingActionButton buttonCadastro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        nomeUsuario = findViewById(R.id.nomeUsuarioHome);
        emailUsuario = findViewById(R.id.emailUsuario);


        Intent intent = getIntent();

        nomeUsuario.setText(intent.getStringExtra("nome"));
        emailUsuario.setText(intent.getStringExtra("email"));

        idUser = intent.getIntExtra("idUser", -1);
        listLivros = findViewById(R.id.listaLivros);
        listLivros.setLayoutManager(new LinearLayoutManager(this));
        adapter = new LivrosAdapter(this);

        listLivros.setAdapter(adapter);
        buttonCadastro = (FloatingActionButton) findViewById(R.id.cadastroLivro);
        buttonCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, CadastrarLivro.class);
                startActivity(intent);
            }
        });


        buttoonEmprestimos = (Button) findViewById(R.id.emprestimos);
        buttoonEmprestimos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, MeusEmprestimos.class);
                intent.putExtra("idUser", idUser);
                startActivity(intent);
            }
        });




    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.dados:
                Intent intent = new Intent(Home.this, DadosUsuario.class);
                intent.putExtra("nome", nomeUsuario.getText());
                intent.putExtra("idUser", idUser);
                intent.putExtra("email", emailUsuario.getText());

                startActivity(intent);
                startActivity(intent);
                return true;
            case R.id.sair:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setMessage("Deseja sair?")
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(Home.this, MainActivity.class);
                                    startActivity(intent);

                            }
                        }).setNegativeButton("Cancelar", null);

                AlertDialog alert = builder.create();
                alert.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        adapter.update();
        adapter.notifyDataSetChanged();

        UserDAO userDAO = new UserDAO(this);
        User user = userDAO.getById(idUser);

        nomeUsuario.setText(user.getName());
        emailUsuario.setText(user.getName());
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }




}