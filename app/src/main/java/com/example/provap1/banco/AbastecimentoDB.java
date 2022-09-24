package com.example.provap1.banco;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.provap1.model.Abastecimento;

import java.util.List;

public class AbastecimentoDB {

    private DBHelper db;
    private SQLiteDatabase conexao;
    public AbastecimentoDB(DBHelper db){
        this.db=db;
    }

    public void salvar(Abastecimento dados){

        conexao = db.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("data_abastecimento", dados.getData_abastecimento());
        valores.put("quilometragem", dados.getQuilometragem());
        valores.put("quantidade_abastecida", dados.getQuatidadeAbastecida());
        valores.put("valor", dados.getValor());

        conexao.insert("abastecimentos", null, valores);

        conexao.close();

    }

    public void listar(List dados){

        dados.clear();
        conexao = db.getWritableDatabase();
        String colunas[] = {"id", "quilometragem", "quantidade_abastecida", "data_abastecimento", "valor"};

        Cursor query = conexao.query("abastecimentos", colunas,
                null, null, null,
                null, "quilometragem");

        while (query.moveToNext()){
            Abastecimento dado = new Abastecimento();
            dado.setValor(query.getString(4));
            dado.setId(Integer.parseInt(query.getString(0)));
            dado.setData_abastecimento(query.getString(3));
            dado.setQuilometragem(query.getString(1));
            dado.setQuatidadeAbastecida(query.getString(2));
            dados.add(dado);
        }

        conexao.close();

    }

    public void remover(int id){

        conexao = db.getWritableDatabase();
        conexao.delete("abastecimentos", "id=?", new String[]{id+""});

        conexao.close();

    }

    public float mediaConsulmo(){
        float media = 0;
        float quilometragem = 0;
        float quantidade = 0;
        conexao = db.getWritableDatabase();
        String colunas[] = {"quilometragem", "quantidade_abastecida"};

        Cursor query = conexao.query("abastecimentos", colunas,
                null, null, null,
                null, "quilometragem");

        while (query.moveToNext()){
            quilometragem = quilometragem + Integer.parseInt(query.getString(0));
            quantidade = quantidade + Integer.parseInt(query.getString(1));
        }

        conexao.close();

        media = quantidade/quilometragem;

        if(quilometragem == 0){
            return 0;
        } else {
            return media;
        }

    }

}
