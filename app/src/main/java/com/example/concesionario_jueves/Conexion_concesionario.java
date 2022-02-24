package com.example.concesionario_jueves;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexion_concesionario extends SQLiteOpenHelper {

    public Conexion_concesionario(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table TblCliente(Identificacion text primary key, nombre text not null, usuario text not null, clave text not null," +
                " activo text not null default 'si' )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE TblCliente");{
            onCreate(sqLiteDatabase);
        }

    }
}
