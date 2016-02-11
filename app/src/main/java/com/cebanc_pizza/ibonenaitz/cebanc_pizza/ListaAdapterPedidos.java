package com.cebanc_pizza.ibonenaitz.cebanc_pizza;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListaAdapterPedidos extends BaseAdapter {


    // Declare Variables
    Context context;
    String[] pedidocabeceraid,fechahora,total;
    LayoutInflater inflater;

    public ListaAdapterPedidos(Context context, String[] pedidocabeceraid,String[] fechahora, String[] total) {
        this.context = context;
        this.pedidocabeceraid = pedidocabeceraid;
        this.fechahora = fechahora;
        this.total = total;
    }

    @Override
    public int getCount() {
        return pedidocabeceraid.length;
    }

    @Override
    public Object getItem(int position) {
        Producto p = new Producto(1,1,"","","");
        return p;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Declare Variables
        TextView txtid,txtfechahora,txtPrecio;

        //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.fila_pedido, parent, false);

        // Locate the TextViews in listview_item.xml
        txtid = (TextView) itemView.findViewById(R.id.id);
        txtfechahora = (TextView) itemView.findViewById(R.id.fechahora);
        txtPrecio = (TextView) itemView.findViewById(R.id.precio);
        // Capture position and set to the TextViews
        txtid.setText(pedidocabeceraid[position]);
        txtfechahora.setText(fechahora[position]);
        txtPrecio.setText(total[position]+"€");

        return itemView;
    }

}
