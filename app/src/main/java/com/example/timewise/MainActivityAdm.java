package com.example.timewise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivityAdm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_adm);
    }
    public void abrirUser(View v){
        Intent intent = new Intent(getApplicationContext(), TelaLogin.class);
        startActivity(intent);


    }
    public void entrarAdm(View view){
        Intent intent = new Intent(getApplicationContext(),MenuAdm.class);
        startActivity(intent);
    }
}