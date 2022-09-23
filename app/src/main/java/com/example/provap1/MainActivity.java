package com.example.provap1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.provap1.banco.DBHelper;
import com.example.provap1.model.Abastecimento;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText quilometragem;
    private EditText quantidadeAbastecida;
    private EditText dataAbastecimento;
    private EditText valor;
    private EditText media;
    List<Abastecimento> dados;
    ListView listagem;
    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBHelper(this);

        quilometragem = findViewById(R.id.quilometragem);
        quantidadeAbastecida = findViewById(R.id.quantidadeAbastecida);
        dataAbastecimento = findViewById(R.id.diaAbastecimento);
        valor = findViewById(R.id.valor);
        media = findViewById(R.id.mediaConsulmo);

        dados = new ArrayList();

        ArrayAdapter adapter =
                new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, dados);
        listagem.setAdapter(adapter);

    }
}