package com.tap.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.EditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hefesto.biblioteca.R;

public class Cadastrar extends AppCompatActivity {
    private Button botaoFazerCadastro;
    private EditText nome;
    private EditText senha;
    private EditText email;
    private EditText confirmaSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cadastrar);




        nome = findViewById(R.id.cadastroNome);
        email = findViewById(R.id.cadastroEmail);
        senha = findViewById(R.id.cadastroSenha);
        confirmaSenha = findViewById(R.id.confirmaSenha);


        botaoFazerCadastro = (Button) findViewById(R.id.botaoCatastroUsuario);
        botaoFazerCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nomeToString = nome.getText().toString();
                String emailToString = email.getText().toString();
                String senhaToString = senha.getText().toString();
                String confirmaSehaToString = confirmaSenha.getText().toString();

                if(nomeToString.length() == 0 || emailToString.length() == 0 || senhaToString.length() == 0 || confirmaSehaToString.length() == 0){
                    Toast.makeText(Cadastrar.this, "Preencha todos os campos", Toast.LENGTH_LONG).show();
                } else {
                    if(!senhaToString.equals(confirmaSehaToString)){
                        Toast.makeText(Cadastrar.this, "As senhas devem ser iguais", Toast.LENGTH_LONG).show();

                    }else {
                        UserDAO userDAO = new UserDAO(Cadastrar.this);
                        User user = userDAO.create(nomeToString, emailToString, senhaToString);


                        if(user != null) {
                            Intent intent = new Intent(Cadastrar.this, Home.class);
                            intent.putExtra("nome", user.getName());
                            intent.putExtra("id", user.getId());
                            intent.putExtra("email", user.getEmail());

                            startActivity(intent);
                        }
                    }
                }

            }
        });


    }

//    private  void fazerCadastro(String nome, String s, String email){
//        //UserDAO userDAO = new UserDAO(null);
//
//        //User resultUser = userDAO.create(nome, email, s);
//
//        //if (resultUser != null) {
//        Intent intent = new Intent(Cadastrar.this, Home.class);
//        startActivity(intent);
//       // }
//
//    }
}