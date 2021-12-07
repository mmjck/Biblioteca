package com.tap.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;

import com.hefesto.biblioteca.R;

public class DadosLivro extends AppCompatActivity {
    private ImageButton buttonEditEnable;
    private EditText titleUpdate;
    private EditText authorUpdate;

    private EditText publisherUpdate;
    private EditText yearUpdate;
    private EditText descriptionUpdate;
    private int idBook;
    private Button buttonUpdate;
    private Switch isAvailable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_livro);

        titleUpdate = (EditText)findViewById(R.id.titleUpdate);
        authorUpdate = (EditText)findViewById(R.id.authorUpdate);
        publisherUpdate = (EditText) findViewById(R.id.publisherUpdate);
        yearUpdate = (EditText)findViewById(R.id.yearUpdate);
        descriptionUpdate = (EditText) findViewById(R.id.descriptionUpdate);

        Intent intent = getIntent();
        idBook = intent.getIntExtra("idBook", -1);

        titleUpdate.setText(intent.getStringExtra("title"));
        authorUpdate.setText(intent.getStringExtra("autor"));
        publisherUpdate.setText(intent.getStringExtra("editora"));
        yearUpdate.setText(intent.getStringExtra("ano"));
        descriptionUpdate.setText(intent.getStringExtra("description"));

        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);

        if(intent.getStringExtra("isAvailable") == "1"){
            isAvailable.setChecked(true);
        }

        buttonEditEnable = (ImageButton) findViewById(R.id.buttonEditDados);
        buttonEditEnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titleUpdate.setEnabled(true);
                authorUpdate.setEnabled(true);
                publisherUpdate.setEnabled(true);
                yearUpdate.setEnabled(true);
                descriptionUpdate.setEnabled(true);



                buttonUpdate.setEnabled(true);
                buttonUpdate.setBackgroundColor(Color.parseColor("#2196F3"));
            }
        });


        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleToString = titleUpdate.getText().toString();
                String authorToString = authorUpdate.getText().toString();
                String publisherToString = publisherUpdate.getText().toString();
                String yearToString = yearUpdate.getText().toString();
                String descriptionToString = descriptionUpdate.getText().toString();



                int yearToInt = Integer.parseInt(yearToString);
            }
        });
    }
}