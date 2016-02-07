package com.cebanc_pizza.ibonenaitz.cebanc_pizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class DatosCliente extends AppCompatActivity {

    private EditText usuario;
    private EditText pass;
    public Persona cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_cliente);
        GestionaPedido.startBBDD(getApplicationContext());


        // Botón de salida (final de la aplicación)
        final ImageView boton_salida = (ImageView) findViewById(R.id.imgAniadir);
        boton_salida.setOnClickListener(new OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                finish();
                                            }
                                        }
        );
        // Botón de continuar
        final Button boton_continuar = (Button) findViewById(R.id.btnContinuar);
        boton_continuar.setOnClickListener(new OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   usuario = (EditText) findViewById(R.id.edtUsuario);
                                                   pass = (EditText) findViewById(R.id.edtPwd);
                                                   if (!usuario.getText().toString().equals("") && !pass.getText().toString().equals("")) {
                                                       if (GestionaPedido.iniciarSesion(usuario.getText().toString().toUpperCase(), pass.getText().toString())) {
                                                          // cliente = new Persona(Integer.parseInt(telefono.getText().toString()), nombre.getText().toString(), direccion.getText().toString());
                                                           GestionaPedido.crearPedido(cliente);
                                                           Intent intent = new Intent(DatosCliente.this,SeleccionComida.class);
                                                           startActivity(intent);
                                                       } else {
                                                           Toast.makeText(getApplicationContext(), "Datos no validos, intentalo de nuevo", Toast.LENGTH_SHORT).show();
                                                       }
                                                   } else {
                                                       Toast.makeText(getApplicationContext(), "Datos no validos, intentalo de nuevo", Toast.LENGTH_SHORT).show();
                                                   }

                                               }
                                           }

        );}

}

