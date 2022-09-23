package com.example.provap1.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context){
        super(context, "BancoListaTelefonica", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(
                "create table abastecimentos(" +
                        "id integer primary key autoincrement," +
                        "quilometragem varchar(20)," +
                        "quantidade_abastecida varchar(10)," +
                        "data_abastecimento varchar(15)," +
                        "valor varchar(20));"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
