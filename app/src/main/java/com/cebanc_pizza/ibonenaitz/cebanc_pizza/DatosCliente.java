package com.cebanc_pizza.ibonenaitz.cebanc_pizza;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DatosCliente extends AppCompatActivity {
    private View vPrivate;
    private EditText usuario;
    private EditText pass;
    private TextView btn_registrarse;
    public Persona cliente;
    public Dialog d;
    private TextView nombre_pop,usuario_pop,pass_pop,direccion_pop,tlf_pop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_cliente);
        GestionaPedido.startBBDD(getApplicationContext());

        // Botón de salida (final de la aplicación)
        btn_registrarse = (TextView) findViewById(R.id.btnRegistrarse);
        btn_registrarse.setOnClickListener(new OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   abrirPopUp(v);
                                               }
                                           }
        );
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
                                                           GestionaPedido.crearPedido();
                                                           Intent intent = new Intent(DatosCliente.this,SeleccionComida.class);
                                                           startActivity(intent);
                                                       } else {
                                                           vPrivate = v;
                                                           //Mostrar un mensaje de confirmación antes de realizar el test
                                                           final AlertDialog.Builder alertDialog = new AlertDialog.Builder(DatosCliente.this);
                                                           alertDialog.setMessage("Los datos introducidos son incorrectos, ¿Deseas registrarte?");
                                                           alertDialog.setTitle("Ups...");
                                                           alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
                                                           alertDialog.setCancelable(false);
                                                           alertDialog.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                                                               public void onClick(DialogInterface dialog, int which) {
                                                                   abrirPopUp(vPrivate);
                                                               }
                                                           });

                                                           alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                               public void onClick(DialogInterface dialog, int which) {
                                                               }
                                                           });
                                                           alertDialog.show();

                                                       }
                                                   } else {
                                                       Toast.makeText(getApplicationContext(), "Datos no validos, intentalo de nuevo", Toast.LENGTH_SHORT).show();
                                                   }

                                               }
                                           }

        );}

    //Metodo que abre el PopUp para registrar un usuario
    public void abrirPopUp(View v){
        d = new Dialog(DatosCliente.this);
        d.setContentView(R.layout.popup_registro);
        nombre_pop = (TextView)d.findViewById(R.id.edtNombre);
        usuario_pop = (TextView)d.findViewById(R.id.edtUsuario);
        pass_pop = (TextView)d.findViewById(R.id.edtPass);
        direccion_pop = (TextView)d.findViewById(R.id.edtDireccion);
        tlf_pop = (TextView)d.findViewById(R.id.edtTlf);
        Button registrarse =  (Button)d.findViewById(R.id.btnRegistrarse);
        registrarse.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String var_nombre = nombre_pop.getText().toString().trim();
                String var_usuario = usuario_pop.getText().toString();
                String var_pass = pass_pop.getText().toString();
                String var_dir = direccion_pop.getText().toString();
                String var_tlf = tlf_pop.getText().toString();
                if (!var_dir.equals("") && !var_nombre.equals("") && !var_pass.equals("") && !var_tlf.equals("") && !var_usuario.equals("")){
                    GestionaPedido.aniadirUsuario(var_nombre,var_usuario,var_pass,var_dir,var_tlf);
                    Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
                    d.dismiss();
                }else{
                    Toast.makeText(getApplicationContext(), "Rellena todos los campos", Toast.LENGTH_SHORT).show();
                }

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

