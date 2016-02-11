package com.cebanc_pizza.ibonenaitz.cebanc_pizza;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by eni7 on 07/02/2016.
 */
public class Store extends SQLiteOpenHelper {

    private static final String DB_NAME = "CebancPizza";
    private static final int SCHEME_VERSION = 8;
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
                "Nombre text null," +
                "Direccion text null," +
                "Telefono text null," +
                "Pass text not null)");

        db.execSQL("create table PedidoCabecera(" +
                "PedidoCabeceraID integer primary key autoincrement," +
                "FechaHoraPedido DATETIME DEFAULT CURRENT_TIMESTAMP," +
                "TotalPedido text not null," +
                "UsuarioID integer not null)");

        db.execSQL("create table PedidoLinea(" +
                "PedidoLineaID integer primary key autoincrement," +
                "PedidoCabeceraID integer not null," +
                "Cantidad integer not null," +
                "Extra text not null," +
                "Precio double not null," +
                "NombreArticulo text not null)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
