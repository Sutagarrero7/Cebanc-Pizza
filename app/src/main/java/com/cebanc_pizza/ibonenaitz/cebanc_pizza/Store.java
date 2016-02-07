package com.cebanc_pizza.ibonenaitz.cebanc_pizza;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by eni7 on 07/02/2016.
 */
public class Store extends SQLiteOpenHelper {

    private static final String DB_NAME = "CebancPizza";
    private static final int SCHEME_VERSION = 2;
    private SQLiteDatabase db;

    public Store(Context context) {
        super(context, DB_NAME, null, SCHEME_VERSION);
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Usuarios(" +
                "UsuarioID integer primary key autoincrement," +
                "Usuario text not null," +
                "Pass text not null)");
        db.execSQL("INSERT INTO Usuarios VALUES ('Admin','1234')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
