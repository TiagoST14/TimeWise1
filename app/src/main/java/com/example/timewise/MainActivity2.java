package com.example.timewise;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity2 extends AppCompatActivity {
    private TextView textViewRelogio;
    private Handler handler;// Handler é para atualizar o horario
    private Button buttonBaterPonto;

    private String horaUltPonto;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        textViewRelogio = findViewById(R.id.textViewRelogio);
        handler = new Handler();
        atualizarRelogio();// Função
        buttonBaterPonto = findViewById(R.id.buttonBaterPonto);

            buttonBaterPonto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    baterPonto();
                }
            });


    }

    private void baterPonto(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm");
        String horaAtual = formato.format(calendar.getTime());
        TextView horaUltPonto =findViewById(R.id.horaUltPonto);
        horaUltPonto.setText(horaAtual);

    }

    private void atualizarRelogio() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm");
        String horaAtual = formato.format(calendar.getTime());

        textViewRelogio.setText(horaAtual);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                atualizarRelogio();
            }
        }, 1000);
    }
    public void botaoSair(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }




}
