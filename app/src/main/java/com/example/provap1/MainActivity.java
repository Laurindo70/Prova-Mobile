package com.example.provap1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.provap1.banco.AbastecimentoDB;
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
    AbastecimentoDB abastecimentoDB;


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
        listagem = findViewById(R.id.listagem);

        dados= new ArrayList();

        ArrayAdapter adapter =
                new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, dados);
        listagem.setAdapter(adapter);
        abastecimentoDB = new AbastecimentoDB(db);
        abastecimentoDB.listar(dados);
        ((ArrayAdapter) listagem.getAdapter()
        ).notifyDataSetChanged();

        acao();

    }

    public void acao(){
        listagem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                new AlertDialog.Builder(view.getContext())
                        .setMessage("Deseja realmente remover")
                        .setPositiveButton("Confirmar",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface,
                                                        int k) {
                                        Abastecimento abastecimento = dados.get(i);
                                        abastecimentoDB.remover(abastecimento.getId());
                                        abastecimentoDB.listar(dados);
                                        ((ArrayAdapter) listagem.getAdapter()
                                        ).notifyDataSetChanged();
                                    }
                                })
                        .setNegativeButton("cancelar",null)
                        .create().show();
            }
        });
    }

    public void salvar(View view){

        Abastecimento abastecimento = new Abastecimento();

        abastecimento.setData_abastecimento(dataAbastecimento.getText().toString());
        abastecimento.setQuatidadeAbastecida(quantidadeAbastecida.getText().toString());
        abastecimento.setQuilometragem(quilometragem.getText().toString());
        abastecimento.setValor(valor.getText().toString());

        abastecimentoDB.salvar(abastecimento);
        abastecimentoDB.listar(dados);
        ((ArrayAdapter) listagem.getAdapter()
        ).notifyDataSetChanged();

        Toast.makeText(this,"Salvo com sucesso", Toast.LENGTH_SHORT).show();

    }
}