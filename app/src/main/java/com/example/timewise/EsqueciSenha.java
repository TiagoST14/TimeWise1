package com.example.timewise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class EsqueciSenha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_esqueci_senha);
    }

    public void voltarLogin(){
        Intent intent = new Intent(getApplicationContext(), TelaLogin.class);
        startActivity(intent);
    }
}