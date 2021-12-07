package com.tap.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.hefesto.biblioteca.R;

public class CadastrarLivro extends AppCompatActivity {
    private Button cadastroLivro;
    private Switch isAvailable;

    private EditText title;
    private EditText descricao;
    private EditText ano;
    private EditText editora;
    private EditText autor;

    private int idUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_livro);


        title = (EditText)findViewById(R.id.titleCadastrar);
        descricao = (EditText)findViewById(R.id.descricaoCadastrar);
        ano = (EditText) findViewById(R.id.anoCadastrar);
        autor = (EditText)findViewById(R.id.authorCadastrar);
        editora = (EditText) findViewById(R.id.editoraCadastrar);
        isAvailable = (Switch) findViewById(R.id.disponivelCadastro);


        Intent intent = new Intent();
        idUser = intent.getIntExtra("idUser", -1);


        cadastroLivro = findViewById(R.id.buttonCadastroLivro);
        cadastroLivro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CadastrarLivro.this, "Cadastrado com sucesso!!!", Toast.LENGTH_SHORT).show();
                String titleToString = title.getText().toString();
                String authorToString = autor.getText().toString();
                String publisherToString = editora.getText().toString();
                String yearToString = ano.getText().toString();
                String descriptionToString = descricao.getText().toString();


                int disponivel = isAvailable.isEnabled() == true ? 1 : 0;
                if (titleToString.length() == 0 || authorToString.length() == 0 || publisherToString.length() == 0 || yearToString.length() == 0 || descriptionToString.length() == 0) {
                    Toast.makeText(CadastrarLivro.this, "Preencha todos os campos", Toast.LENGTH_LONG).show();
                } else {
                    LivroDAO livroDAO = new LivroDAO(CadastrarLivro.this);
                    livroDAO.create(titleToString, authorToString, descriptionToString, yearToString, publisherToString, disponivel, idUser);

                    title.setText("");
                    editora.setText("");
                    autor.setText("");
                    ano.setText("");
                    descricao.setText("");


                }
            }
        });

    }


}