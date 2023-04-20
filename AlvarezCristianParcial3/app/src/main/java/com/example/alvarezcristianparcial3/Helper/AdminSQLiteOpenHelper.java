package com.example.alvarezcristianparcial3.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase Parcial) {
        Parcial.execSQL("CREATE TABLE Contactos (nombre text,apellido text,telefono integer, correo text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase Parcial, int oldVersion, int newVersion) {

    }
}
