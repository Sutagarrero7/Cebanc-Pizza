package com.cebanc_pizza.ibonenaitz.cebanc_pizza;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SeleccionBebida extends AppCompatActivity {
    LayoutInflater layoutInflater;
    View popupView;
    PopupWindow popupWindow;
    ImageView img_burn,img_Cancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_bebida);

//        img_burn = (ImageView)findViewById(R.id.imgBurn);
//        img_burn.setOnClickListener(new ImageView.OnClickListener() {
//            @Override
//            public void onClick(View arg0) {

    }
    public void abrirPopUp(View arg0){
        img_burn = (ImageView)findViewById(R.id.imagenBurn);
        layoutInflater =(LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        popupView = layoutInflater.inflate(R.layout.popup_bebidas, null);
        popupWindow = new PopupWindow(popupView);

        img_Cancelar = (ImageView)popupView.findViewById(R.id.imgCancelar);
        img_Cancelar.setOnClickListener(new ImageView.OnClickListener(){

            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }});

        popupWindow.showAsDropDown(img_burn, 50, 0);

    }
}


