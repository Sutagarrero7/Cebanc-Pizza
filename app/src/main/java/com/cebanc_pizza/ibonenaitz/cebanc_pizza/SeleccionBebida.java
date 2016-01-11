package com.cebanc_pizza.ibonenaitz.cebanc_pizza;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.util.ArrayList;

public class SeleccionBebida extends AppCompatActivity {
    NumberPicker cant;
    String nombre_class;
    TextView precio;
    Dialog d;
    ArrayList<Producto> lista_productos;
    final ImageView imagen_cocacola = (ImageView)findViewById(R.id.imgCocaCola),
            imagen_arriba = (ImageView)findViewById(R.id.imgArriba),
            imagen_abajo = (ImageView)findViewById(R.id.imgAbajo),
            imagen_burn = (ImageView)findViewById(R.id.imgBaconCrispy),
            imagen_cocacola_ligth = (ImageView)findViewById(R.id.imgPeperoni),
            Imagen_cocacola_zero = (ImageView)findViewById(R.id.imgHawaiana) ,
            imagen_fanta_n = (ImageView)findViewById(R.id.imgEspecialCasa) ,
            imagen_fanta_l = (ImageView)findViewById(R.id.imgFantaLimon ),
            imagen_mahou = (ImageView)findViewById(R.id.imgMahou ),
            imagen_mahou_sin = (ImageView)findViewById(R.id.imgMahouSin ),
            imagen_nestea = (ImageView)findViewById(R.id.imgNestea ),
            imagen_redbull = (ImageView)findViewById(R.id.imgRedbull ),
            imagen_siete = (ImageView)findViewById(R.id.img7nup ),
            imagen_sprite = (ImageView)findViewById(R.id.imgSprite );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_bebida);

        // Arriba
        imagen_arriba.setOnClickListener(new OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 imagen_cocacola.setVisibility(View.VISIBLE);
                                                 imagen_fanta_l.setVisibility(View.VISIBLE);
                                                 imagen_nestea.setVisibility(View.VISIBLE);
                                                 imagen_mahou_sin.setVisibility(View.VISIBLE);
                                                 imagen_sprite.setVisibility(View.VISIBLE);
                                                 imagen_redbull.setVisibility(View.VISIBLE);
                                                 imagen_abajo.setVisibility(View.VISIBLE);
                                                 imagen_arriba.setVisibility(View.INVISIBLE);
                                                 Toast.makeText(getApplicationContext(), "Arriba", Toast.LENGTH_SHORT).show();
                                             }
                                         }
        );

        // Abajo
        imagen_abajo.setOnClickListener(new OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                imagen_cocacola.setVisibility(View.INVISIBLE);
                                                imagen_fanta_l.setVisibility(View.INVISIBLE);
                                                imagen_nestea.setVisibility(View.INVISIBLE);
                                                imagen_mahou_sin.setVisibility(View.INVISIBLE);
                                                imagen_sprite.setVisibility(View.INVISIBLE);
                                                imagen_redbull.setVisibility(View.INVISIBLE);
                                                imagen_abajo.setVisibility(View.INVISIBLE);
                                                imagen_arriba.setVisibility(View.VISIBLE);
                                                Toast.makeText(getApplicationContext(), "Abajo", Toast.LENGTH_SHORT).show();
                                                setContentView(R.layout.activity_seleccion_bebida);
                                            }

        });

        // Botón continuar
        final Button continuar = (Button) findViewById(R.id.btnContinuar);
        continuar.setOnClickListener(new OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               Toast.makeText(getApplicationContext(), "No disponible", Toast.LENGTH_SHORT).show();
                                           }
                                       }
        );
    }

   public void abrirPopUp(View v,String nom){
        d = new Dialog(SeleccionBebida.this);
        d.setContentView(R.layout.popup_bebidas);
        nombre_class = nom;
        precio = (TextView)findViewById(R.id.lblPrecio);

//        switch (nombre) {
//            case "sevenup":
//                precio.setText("Precio: 1.45€");
//                break;
//            case "nestea":
//                precio.setText("Precio: 2.00€");
//               break;
//            case "mahou":
//                precio.setText("Precio: 1.90€");
//                break;
//            case "mahou_sin":
//                precio.setText("Precio: 2.10€");
//                break;
//            case "redbull":
//                precio.setText("Precio: 2.00");
//                break;
//            default:
//                precio.setText("Precio: 1.00€");
//                break;
//        }
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
        cancelar.setOnClickListener(new ImageView.OnClickListener() {
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



