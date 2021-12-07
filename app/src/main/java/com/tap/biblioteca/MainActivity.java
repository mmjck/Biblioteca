package com.tap.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hefesto.biblioteca.R;

public class MainActivity extends AppCompatActivity {
    private Button cadastrar;
    private Button entrar;
    private EditText email;
    private EditText senha;
    UserDAO userDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cadastrar = (Button) findViewById(R.id.cadastrar);
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Cadastrar.class);
                startActivity(intent);
            }
        });


        LivroDAO livroDao = new LivroDAO(this);
        livroDao.getAllBooksByUser(1);
        email = findViewById(R.id.emailEntrar);
        senha = findViewById(R.id.senhaEntrar);


        entrar = (Button) findViewById(R.id.buttonEntrar);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().length() == 0 ||  senha.getText().toString().length() == 0 ){
                    Toast.makeText(MainActivity.this, "Preencha todos os campos", Toast.LENGTH_LONG).show();
                } else {
                    UserDAO userDAO = new UserDAO(MainActivity.this);

                    User user  = userDAO.authUser(email.getText().toString(), senha.getText().toString());


                    if(user == null) {
                        Toast.makeText(MainActivity.this, "Erro ao fazer login!", Toast.LENGTH_SHORT).show();
                    }else{
                        Intent intent = new Intent(MainActivity.this, Home.class);
                        intent.putExtra("nome", user.getName());
                        intent.putExtra("idUser", user.getId());
                        intent.putExtra("email", user.getEmail());

                        startActivity(intent);
                    }
                }
            }
        });
    }
}