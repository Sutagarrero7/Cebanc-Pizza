package com.cebanc_pizza.ibonenaitz.cebanc_pizza;

import android.app.Notification;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ResumenPedido extends AppCompatActivity {
    ListView lista;
    ArrayList<Producto> arrProductos;
    Producto producto;
    String[] productos;
    int[] imagenes_productos;
    TextView lblPrecio;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_pedido);
        lista = (ListView)findViewById(R.id.lstProductos);
        arrProductos = new ArrayList<>();
        lblPrecio = (TextView)findViewById(R.id.lblPrecio);
        btnFinalizar = (Button)findViewById(R.id.btnFinalizar);
        actualizarListaProductos();
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                finish();
                                            }
                                        }

        );
    }

    private int getImagenProducto(String nombre) {
        switch (nombre) {
            case "siete":
                return R.drawable.siete;
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
                return R.drawable.sprite_logo;
            default:
                return 0;
        }
    }

    public void actualizarListaProductos(){
        arrProductos = GestionaPedido.todoPedido();
        productos = new String[arrProductos.size()];
        imagenes_productos = new int[arrProductos.size()];
        for (int i = 0; i < arrProductos.size(); i++) {
            producto = arrProductos.get(i);
            productos[i] = Integer.toString(producto.getCantidad()) + " - " + producto.getNombre() +"/" + Double.toString(producto.getPrecio())+"€";
            imagenes_productos[i] = getImagenProducto(producto.getNombre());
        }
        ListaAdapter adapter = new ListaAdapter(this, productos, imagenes_productos);
        lista.setAdapter(adapter);
        lblPrecio.setText(Double.toString(GestionaPedido.precioTotalPedido()));
    }

}
