package com.cebanc_pizza.ibonenaitz.cebanc_pizza;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class SeleccionComida extends AppCompatActivity {

    private Button button;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_comida);


        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {

            }
        });

    }
}