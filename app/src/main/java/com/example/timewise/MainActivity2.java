package com.example.timewise;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity2 extends AppCompatActivity {
    private TextView textViewRelogio;
    private Handler handler;// Handler é para atualizar o horario
    private Button buttonBaterPonto;
    private TextView textUser;



    private String horaUltPonto;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);


        textViewRelogio = findViewById(R.id.textViewRelogio);
        handler = new Handler();
        atualizarRelogio();// Função
        buttonBaterPonto = findViewById(R.id.buttonBaterPonto);

            buttonBaterPonto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) { // METODO ONCLICK PUXA A FUNCAO BATER PONTO AO CLICAR COM O VIEW, QUE MOSTRA NO XML
                    baterPonto();

                }



            });

            

    }
    // FUNCAO PARA PUXAR OO MOMENTO EXATO EM QUE O PONTO FOI BATIDO
    private void baterPonto(){
        Calendar calendar = Calendar.getInstance();           //PEGA O HORARIO EXATO
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm");  // GUARDA O HORARIO NO FORMATO ESCOLHIDO NAS ASPAS
        String horaAtual = formato.format(calendar.getTime()); // GUARDA O HORARIO QUEFOI PEGO NO CALENDAR E O FORMATO E GUARDA NA STRING "horaAtual"
        TextView horaUltPonto =findViewById(R.id.horaUltPonto);
        horaUltPonto.setText(horaAtual);
        mensagemPonto("Ponto confirmado " + horaAtual);

    }

    private void mensagemPonto (String messagem){
        Toast.makeText(getApplicationContext(),messagem,Toast.LENGTH_SHORT).show();
    }

    // FUNCAO ATUALIZA O HORARIO NO APP, EM CONJUNDO COM O HANDLER QUE ATUALIZA A CADA 1 SEG
    private void atualizarRelogio() {
        Calendar calendar = Calendar.getInstance(); // PEGA O HORARIO EXATO
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm"); //GUARDA NO FORMATO ESCOLHIDO NAS ASPAS
        String horaAtual = formato.format(calendar.getTime()); // GUARDA O HORARIO QUEFOI PEGO NO CALENDAR E O FORMATO E GUARDA NA STRING "horaAtual"

        textViewRelogio.setText(horaAtual); // COMANDO PARA MANDAR A STRING PARA O TEXTVIEW NO XML

        handler.postDelayed(new Runnable() { // HANDLER QUE ATUALIZA
            @Override
            public void run() {
                atualizarRelogio();
            } // PUXA A FUNCAO QUE SERA FEITA A CADA 1 SEGUNDO
        }, 1000);
    }
    //BOTAO CRIADO PARA SAIDA PARA A TELA PRINCIPAL
    public void botaoSair(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }





}
