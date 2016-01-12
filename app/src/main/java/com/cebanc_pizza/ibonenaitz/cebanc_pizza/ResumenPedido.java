package com.cebanc_pizza.ibonenaitz.cebanc_pizza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ResumenPedido extends AppCompatActivity {
    ListView lista = (ListView)findViewById(R.id.lstProductos);;
    ArrayList<Producto> arrProductos = new ArrayList<>();
    Producto producto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_pedido);

    }
    public void actualizarListaProductos(){
        lista.removeAllViews();
        arrProductos = GestionaPedido.todoPedido();
        for (int i = 0; i < arrProductos.size(); i++){
            producto = arrProductos.get(i);

        }

    }
}
