package com.tap.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.hefesto.biblioteca.R;

public class DadosUsuario extends AppCompatActivity {
    private ImageButton editEnable;
    private Button atualizarDados;
    private EditText nomeEdit;
    private EditText emailEdit;
    private EditText senhaEdit;
    private EditText confirmaSenhaEdit;
    private int idUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_usuario);

        Intent intent = getIntent();
        idUser = intent.getIntExtra("idUser", -1);
        nomeEdit = (EditText)findViewById(R.id.nomeAtualiza);
        emailEdit = (EditText)findViewById(R.id.emailAtualiza);
        senhaEdit = (EditText)findViewById(R.id.senhaAtualiza);
        confirmaSenhaEdit = (EditText)findViewById(R.id.confirmaSenhaAtualiza);

        atualizarDados = (Button) findViewById(R.id.botaoAtualiza);

        nomeEdit.setText(intent.getStringExtra("nome"));
        emailEdit.setText(intent.getStringExtra("email"));



        editEnable = (ImageButton) findViewById(R.id.botaoAtivar);
        editEnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nomeEdit.setEnabled(true);
                emailEdit.setEnabled(true);
                senhaEdit.setEnabled(true);
                confirmaSenhaEdit.setEnabled(true);

                atualizarDados.setEnabled(true);
                atualizarDados.setBackgroundColor(Color.parseColor("#2196F3"));
            }
        });
        atualizarDados = (Button) findViewById(R.id.botaoAtualiza);
        atualizarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nomeToString = nomeEdit.getText().toString();
                String emailToString = emailEdit.getText().toString();
                String senhaToString = senhaEdit.getText().toString();
                String confirmaSehaToString = confirmaSenhaEdit.getText().toString();

                if(nomeToString.length() == 0 || emailToString.length() == 0 || senhaToString.length() == 0 || confirmaSehaToString.length() == 0){
                    Toast.makeText(DadosUsuario.this, "Preencha todos os campos", Toast.LENGTH_LONG).show();
                } else {
                    if(!senhaToString.equals(confirmaSehaToString)){
                        Toast.makeText(DadosUsuario.this, "As senhas devem ser iguais", Toast.LENGTH_LONG).show();

                    }else {
                        UserDAO userDAO = new UserDAO(DadosUsuario.this);
                        Boolean result = userDAO.update(nomeToString, emailToString, senhaToString, idUser);


                        if(result != false) {
                            Intent intent = new Intent(DadosUsuario.this, Home.class);
                            intent.putExtra("nome", nomeToString);
                            intent.putExtra("id", idUser);
                            intent.putExtra("email", emailToString);

                            startActivity(intent);
                        }
                    }
                }

            }
        });



    }

}