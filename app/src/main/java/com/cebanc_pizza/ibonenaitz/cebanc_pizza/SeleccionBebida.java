package com.cebanc_pizza.ibonenaitz.cebanc_pizza;

import android.app.Dialog;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SeleccionBebida extends AppCompatActivity {
    ImageView img_burn;
    NumberPicker cant;
    String nombre_class;
    TextView precio;
    Dialog d;
    ArrayList<Producto> lista_productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_bebida);
        img_burn = (ImageView)findViewById(R.id.imagenBurn);
        img_burn.setClickable(true);
        img_burn.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                abrirPopUp(arg0,"redbull");
            }

        });
    }
    public void abrirPopUp(View arg0,String nombre){
        d = new Dialog(SeleccionBebida.this);
        d.setContentView(R.layout.popup_bebidas);
        nombre_class = nombre;
        precio = (TextView)findViewById(R.id.lblPrecio);

        switch (nombre) {
            case "sevenup":
                precio.setText("Precio: 1.45€");
                break;
            case "nestea":
                precio.setText("Precio: 2.00€");
                break;
            case "mahou":
                precio.setText("Precio: 1.90€");
                break;
            case "mahou_sin":
                precio.setText("Precio: 2.10€");
                break;
            case "redbull":
                precio.setText("Precio: 2.00€");
                break;
            default:
                precio.setText("Precio: 1.00€");
                break;
        }
        cant = (NumberPicker)findViewById(R.id.cantidad);
        ImageView aniadir= (ImageView)findViewById(R.id.imgAniadir);
        aniadir.setOnClickListener(new ImageView.OnClickListener() {
           @Override
           public void onClick(View arg0) {
               int c = cant.getValue();
               Producto p;
               p = añadirProducto(nombre_class,c,precio.getText().toString());
               lista_productos.add(p);
               d.dismiss();
        }

    });
        ImageView cancelar= (ImageView)findViewById(R.id.imgCancelar);
        aniadir.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                d.dismiss();
            }

        });
    d.show();
    }
    public Producto añadirProducto(String nombre, int cantidad, String precio){
        int pvp = Integer.parseInt(precio.substring(8,11));
        Producto p=new Producto(pvp,cantidad,nombre,"");
        return p;
    }
}



