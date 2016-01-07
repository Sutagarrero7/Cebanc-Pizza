package com.cebanc_pizza.ibonenaitz.cebanc_pizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DatosCliente extends AppCompatActivity {

    private EditText nombre;
    private EditText direccion;
    private EditText telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_cliente);

        // Botón de salida (final de la aplicación)
        final Button boton_salida = (Button) findViewById(R.id.btnSalir);
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
                                                if (!nombre.getText().toString().equals("") && !direccion.getText().toString().equals("") && telefono.getText().length() == 9 ){

                                                }else{
                                                    Toast.makeText(getApplicationContext(),"Datos no validos, intentalo de nuevo",Toast.LENGTH_SHORT).show();
                                                }

                                            }
                                        }
        );
    }
}
