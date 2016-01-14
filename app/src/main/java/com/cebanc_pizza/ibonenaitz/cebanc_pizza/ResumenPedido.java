package com.cebanc_pizza.ibonenaitz.cebanc_pizza;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ResumenPedido extends AppCompatActivity {
    ListView lista;
    ArrayList<Producto> arrProductos;
    Producto producto;
    Persona client;

    String[] nombre,cantidad,extra,tamanio,precio;
    int[] imagenes_productos;
    TextView lblPrecio,lblNombre;
    Button btnFinalizar,btnBorrar;
    Boolean bBorrar = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_pedido);
        lista = (ListView)findViewById(R.id.lstProductos);
        arrProductos = new ArrayList<>();
        client = GestionaPedido.getCliente();
        lblPrecio = (TextView)findViewById(R.id.lblPrecio);
        lblNombre = (TextView)findViewById(R.id.lblNombre);
        lblNombre.setText(client.getNombre()+", tu pedido:");
        btnFinalizar = (Button)findViewById(R.id.btnFinalizar);
        btnBorrar = (Button)findViewById(R.id.btnBorrar_OnOff);
        btnBorrar.setBackgroundResource(R.drawable.borrar_off);
        btnBorrar.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                if (bBorrar == false){
                                                    bBorrar = true;
                                                    btnBorrar.setBackgroundResource(R.drawable.borrar_on);

                                                }else{
                                                    bBorrar = false;
                                                    btnBorrar.setBackgroundResource(R.drawable.borrar_off);
                                                }
                                            }
                                        }

        );
        actualizarListaProductos();
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                notificacion();
                                                //finish();
                                                Intent intent = new Intent(getApplicationContext(), DatosCliente.class);
                                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                startActivity(intent);
                                            }
                                        }

        );

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (bBorrar == true) {
                    Producto p = new Producto(Double.parseDouble(precio[position]), Integer.parseInt(cantidad[position]), nombre[position], extra[position], tamanio[position]);
                    GestionaPedido.eliminarProducto(p);
                    actualizarListaProductos();
                }else{
                    Toast.makeText(getApplicationContext(), "Activa la opcion borrar desde el boton", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private int getImagenProducto(String nombre) {
        switch (nombre) {
            case "siete":
                return R.drawable.siete_logo;
            case "nestea":
                return R.drawable.nestea;
            case "mahou":
                return R.drawable.mahou;
            case "mahou_sin":
                return R.drawable.mahou_sin;
            case "redbull":
                return R.drawable.redbull;
            case "burn":
                return R.drawable.burn;
            case "cocacola":
                return R.drawable.cocalcola;
            case "cocacola_ligth":
                return R.drawable.cocacola_light;
            case "cocacola_zero":
                return R.drawable.cocacola_zero;
            case "fanta_l":
                return R.drawable.fanta_limon;
            case "fanta_n":
                return R.drawable.fanta_naranja;
            case "sprite":
                return R.drawable.sprite_logo_;
            case "bacon_crispy":
                return R.drawable.pizza_bacon_crispy;
            case "hawaiana":
                return R.drawable.pizza_hawaiana;
            case "especial_casa":
                return R.drawable.pizza_especial_casa;
            case "steak_house":
                return R.drawable.pizza_steak_house;
            case "peperoni":
                return R.drawable.pizza_peperoni;
            case "4_quesos":
                return R.drawable.pizza_4q;
            case "barbacoa":
                return R.drawable.pizza_bbq;
            case "formagio":
                return R.drawable.pizza_formagio;
            case "jamon_queso":
                return R.drawable.pizza_jamon_queso;
            case "carbonara":
                return R.drawable.pizza_carbonara;
            default:
                return 0;
        }
    }

    public void actualizarListaProductos(){
        arrProductos = GestionaPedido.todoPedido();
        nombre = new String[arrProductos.size()];
        cantidad = new String[arrProductos.size()];
        extra = new String[arrProductos.size()];
        precio = new String[arrProductos.size()];
        tamanio = new String[arrProductos.size()];
        imagenes_productos = new int[arrProductos.size()];
        for (int i = 0; i < arrProductos.size(); i++) {
            producto = arrProductos.get(i);
            nombre[i] = producto.getNombre();
            cantidad[i] = Integer.toString(producto.getCantidad());
            precio[i] = Double.toString(producto.getPrecio());
            extra[i] = producto.getExtra();
            tamanio[i] = producto.getTamano();
            imagenes_productos[i] = getImagenProducto(producto.getNombre());
        }
        ListaAdapter adapter = new ListaAdapter(this, nombre, imagenes_productos,cantidad,extra,tamanio,precio);
        lista.setAdapter(adapter);
        lblPrecio.setText(Double.toString(GestionaPedido.precioTotalPedido()));
    }

    public void notificacion() {
        double p = GestionaPedido.precioTotalPedido();
        CharSequence chapada = client.getNombre() + ", le informamos de que su pedido está camino a " + client.getDireccion()+". El total del pedido son: "+Double.toString(producto.getPrecio())+" euros.";
        if (p > 20 && p <=33){
            chapada = chapada + " Por ser un pedido superior a 20 euros te regalamos un peluche del muñeco de android.";
        }else if(p>33){
            chapada = chapada + " Por ser un pedido superior a 33 euros te regalamos un peluche del muñeco de android y un vale para comer en el comedor de Cebanc.";
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Cebanc - Pizza")
            .setContentText("Expanda esta notificacion")
            .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
            .setLights(Color.RED, 3000, 3000)
            .setAutoCancel(true)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(chapada));

        // Construir la notificación y emitirla
        NotificationManager notifyMgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);;
        notifyMgr.notify(1, builder.build());
    }


}
