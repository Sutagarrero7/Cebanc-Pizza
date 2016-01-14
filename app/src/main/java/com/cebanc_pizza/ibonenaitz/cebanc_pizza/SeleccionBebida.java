package com.cebanc_pizza.ibonenaitz.cebanc_pizza;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class SeleccionBebida extends AppCompatActivity {
    String nombre_class,tamanio;
    TextView precio,cant;
    Dialog d;
    ImageView imagen_cocacola,imagen_burn,imagen_cocacola_ligth,imagen_cocacola_zero,imagen_fanta_n,imagen_fanta_l,imagen_mahou,imagen_mahou_sin,imagen_nestea,imagen_redbull,imagen_siete,imagen_sprite;
    Button btnContinuar_Bebidas;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_bebida);
        btnContinuar_Bebidas = (Button)findViewById(R.id.btnContinuar_Bebidas);
        imagen_cocacola = (ImageView)findViewById(R.id.imgCocaCola);
        imagen_burn = (ImageView)findViewById(R.id.imgBurn);
        imagen_cocacola_ligth = (ImageView)findViewById(R.id.imgCocaColaLigth);
        imagen_cocacola_zero = (ImageView)findViewById(R.id.imgCocaColaZero);
        imagen_fanta_n = (ImageView)findViewById(R.id.imgFantaNaranja);
        imagen_fanta_l = (ImageView)findViewById(R.id.imgFantaLimon);
        imagen_mahou = (ImageView)findViewById(R.id.imgMahou);
        imagen_mahou_sin = (ImageView)findViewById(R.id.imgMahouSin);
        imagen_nestea = (ImageView)findViewById(R.id.imgNestea);
        imagen_redbull = (ImageView)findViewById(R.id.imgRedbull);
        imagen_siete = (ImageView)findViewById(R.id.img7nup);
        imagen_sprite = (ImageView)findViewById(R.id.imgSprite);

        imagen_burn.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {abrirPopUp(v, "burn");
                                           }
                                       }
        );
        imagen_cocacola.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {abrirPopUp(v, "cocacola");
                                               }
                                           }
        );
        imagen_cocacola_ligth.setOnClickListener(new View.OnClickListener() {
                                                     @Override
                                                     public void onClick(View v) {abrirPopUp(v, "cocacola_ligth");
                                                     }
                                                 }
        );
        imagen_cocacola_zero.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {abrirPopUp(v, "cocacola_zero");
                                                    }
                                                }
        );
        imagen_fanta_n.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {abrirPopUp(v, "fanta_n");
                                              }
                                          }
        );
        imagen_fanta_l.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {abrirPopUp(v, "fanta_l");
                                              }
                                          }
        );
        imagen_mahou.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {abrirPopUp(v, "mahou");
                                            }
                                        }
        );
        imagen_mahou_sin.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {abrirPopUp(v, "mahou_sin");
                                                }
                                            }
        );
        imagen_nestea.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {abrirPopUp(v, "nestea");
                                             }
                                         }
        );
        imagen_redbull.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {abrirPopUp(v, "redbull");
                                              }
                                          }
        );
        imagen_siete.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {abrirPopUp(v, "siete");
                                            }
                                        }
        );
        imagen_sprite.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {abrirPopUp(v, "sprite");
                                             }
                                         }
        );

        btnContinuar_Bebidas.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {Intent intent = new Intent(SeleccionBebida.this,ResumenPedido.class);
                                                        startActivity(intent);
                                                    }
                                                }
        );
    }

    //Metodo que abre el PopUp de bebidas y asigna los valores para el mismo
    public void abrirPopUp(View v,String nombre){
        d = new Dialog(SeleccionBebida.this);
        d.setContentView(R.layout.popup_bebidas);
        nombre_class = nombre;
        precio = (TextView)d.findViewById(R.id.lblPrecio);

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
        cant = (TextView)d.findViewById(R.id.txtCantidad);
        ImageView aniadir= (ImageView)d.findViewById(R.id.imgAniadir);
        spinner = (Spinner) d.findViewById(R.id.cmbTamanio);
        String[] valores = {"Grande","Mediano","Pequeño"};
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
                GestionaPedido.añadirProducto(nombre_class,c,precio.getText().toString(),"",tamanio);
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

}



