package com.cebanc_pizza.ibonenaitz.cebanc_pizza;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by eni7 on 12/01/2016.
 */
public class ListaAdapter extends BaseAdapter {


    // Declare Variables
    Context context;
    String[] nombre,cantidad,extra,tamaño,precio;
    int[] imagenes;
    LayoutInflater inflater;

    public ListaAdapter(Context context, String[] pnombre, int[] imagenes, String[] pcant , String[] pextra , String[] ptamanio, String[] pprecio ) {
        this.context = context;
        this.nombre = pnombre;
        this.cantidad = pcant;
        this.extra = pextra;
        this.tamaño = ptamanio;
        this.precio = pprecio;
        this.imagenes = imagenes;
    }

    @Override
    public int getCount() {
        return nombre.length;
    }

    @Override
    public Object getItem(int position) {
        Producto p = new Producto(Double.parseDouble(precio[position]),Integer.parseInt(cantidad[position]),nombre[position],extra[position],tamaño[position]);
        return p;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // Declare Variables
        TextView txtNombre,txtCantidad,txtExtra,txtTamaño,txtPrecio;
        ImageView imgImg;

        //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.fila, parent, false);

        // Locate the TextViews in listview_item.xml
        txtNombre = (TextView) itemView.findViewById(R.id.nombre);
        txtCantidad = (TextView) itemView.findViewById(R.id.cantidad);
        txtTamaño = (TextView) itemView.findViewById(R.id.tamaño);
        txtExtra = (TextView) itemView.findViewById(R.id.extra);
        imgImg = (ImageView) itemView.findViewById(R.id.iconLista);
        txtPrecio = (TextView) itemView.findViewById(R.id.precio);
        // Capture position and set to the TextViews
        txtNombre.setText(nombre[position]);
        txtCantidad.setText(cantidad[position]);
        txtTamaño.setText(tamaño[position]);
        txtExtra.setText(extra[position]);
        double pre_temp = Double.parseDouble(precio[position]);
        int cant_temp = Integer.parseInt(cantidad[position]);
        double precio = pre_temp * cant_temp;
        txtPrecio.setText(Double.toString(precio) +"€");
        imgImg.setImageResource(imagenes[position]);

        return itemView;
    }
}
