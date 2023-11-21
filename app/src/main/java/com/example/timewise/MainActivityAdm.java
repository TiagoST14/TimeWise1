package com.example.timewise;

import androidx.activity.result.contract.ActivityResultContracts;
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
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);


    }
}