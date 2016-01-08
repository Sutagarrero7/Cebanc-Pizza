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

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DatosCliente extends AppCompatActivity {

    private EditText nombre;
    private EditText direccion;
    private EditText telefono;
    public Persona cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_cliente);

        // Botón de salida (final de la aplicación)
        final ImageView boton_salida = (ImageView) findViewById(R.id.imgSalir);
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
                                                nombre = (EditText) findViewById(R.id.edtNombre);
                                                direccion = (EditText) findViewById(R.id.edtDireccion);
                                                telefono = (EditText) findViewById(R.id.edtTelefono);
                                                if (!nombre.getText().toString().equals("") && !direccion.getText().toString().equals("") && telefono.getText().length() >= 9 ){
                                                    cliente = new Persona(Integer.parseInt(telefono.getText().toString()),nombre.getText().toString(),direccion.getText().toString());
                                                    setContentView(R.layout.activity_seleccion_bebida);
                                                }else{
                                                    Toast.makeText(getApplicationContext(),"Datos no validos, intentalo de nuevo",Toast.LENGTH_SHORT).show();
                                                }

                                            }
                                        }
        );
    }
}
