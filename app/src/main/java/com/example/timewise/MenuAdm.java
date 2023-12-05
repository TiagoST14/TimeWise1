package com.example.timewise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuAdm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_adm);
    }

    public void abrirCadFunc(View view){
        Intent intent = new Intent(getApplicationContext(), TelaCadastrarFuncionario.class);
        startActivity(intent);
    }
    public void voltarLoginAdm(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivityAdm.class);
        startActivity(intent);
    }
}