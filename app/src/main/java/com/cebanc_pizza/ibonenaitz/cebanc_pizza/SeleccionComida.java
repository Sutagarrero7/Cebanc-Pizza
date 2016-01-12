package com.cebanc_pizza.ibonenaitz.cebanc_pizza;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.util.ArrayList;

public class SeleccionComida extends AppCompatActivity {

    private Button button;
    private TextView resultText;
    String nombre_class,tamanio;
    TextView precio,cant;
    Dialog d;
    ArrayList<Producto> lista_productos;
    ImageView imgBaconCrispy,imgEspecialCasa,imgPeperoni,img4q,imgHawaiana,imgSteakHouse;
    Button btnContinuar_Comida;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_comida);
        btnContinuar_Comida = (Button)findViewById(R.id.btnContinuar_Comida);
        imgBaconCrispy = (ImageView)findViewById(R.id.imgBaconCrispy);
        imgEspecialCasa = (ImageView)findViewById(R.id.imgEspecialCasa);
        imgPeperoni = (ImageView)findViewById(R.id.imgPeperoni);
        img4q = (ImageView)findViewById(R.id.img4q);
        imgHawaiana = (ImageView)findViewById(R.id.imgHawaiana);
        imgSteakHouse = (ImageView)findViewById(R.id.imgSteakHouse);


        imgBaconCrispy.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               abrirPopUp(v, "bacon_crispy");
                                           }
                                       }
        );
        imgEspecialCasa.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  abrirPopUp(v, "especial_casa");
                                              }
                                          }
        );
        imgPeperoni.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  abrirPopUp(v, "peperoni");
                                              }
                                          }
        );
        img4q.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  abrirPopUp(v, "4_quesos");
                                              }
                                          }
        );
        imgHawaiana.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   abrirPopUp(v, "hawaiana");
                                               }
                                           }
        );
        imgSteakHouse.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               abrirPopUp(v, "steak_house");
                                           }
                                       }
        );


        btnContinuar_Comida.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        Intent intent = new Intent(SeleccionComida.this,SeleccionBebida.class);
                                                        startActivity(intent);
                                                    }
                                                }
        );
    }


    public void abrirPopUp(View v,String nombre){
        d = new Dialog(SeleccionComida.this);
        d.setContentView(R.layout.popup_comida);
        nombre_class = nombre;
        precio = (TextView)d.findViewById(R.id.lblPrecio);

        switch (nombre) {
            case "bacon_crispy":
                precio.setText("Precio: 14.95€");
                break;
            case "hawaiana":
                precio.setText("Precio: 12.95€");
                break;
            case "especial_casa":
                precio.setText("Precio: 15.95€");
                break;
            case "steak_house":
                precio.setText("Precio: 17.95€");
                break;
            case "peperoni":
                precio.setText("Precio: 14.95€");
                break;
            case "4_quesos":
                precio.setText("Precio: 17.95€");
                break;
            default:
                precio.setText("Precio: 14.95€");
                break;
        }
        cant = (TextView)d.findViewById(R.id.txtCantidad);
        ImageView aniadir= (ImageView)d.findViewById(R.id.imgAniadir);
        spinner = (Spinner) d.findViewById(R.id.cmbTamanio);
        String[] valores = {"Familiar","Mediano","Pequeño"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                tamanio = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // vacio

            }
        });
        aniadir.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                int c = Integer.parseInt(cant.getText().toString());
                Producto p;
                p = añadirProducto(nombre_class,c,precio.getText().toString(),"",tamanio);
                lista_productos.add(p);
                d.dismiss();
            }

        });
        ImageView cancelar= (ImageView)d.findViewById(R.id.imgCancelar);
        cancelar.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                d.dismiss();
            }

        });
        d.show();
    }
    public Producto añadirProducto(String nombre, int cantidad, String precio,String extra,String tamaño){
        double pvp = Double.parseDouble(precio.substring(8, 12).toString());
        Producto p=new Producto(pvp,cantidad,nombre,extra,tamaño);
        return p;
    }
}