package com.example.timewise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TelaCadastrarFuncionario extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastrar_funcionario);



    }

    public void voltar(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivityAdm.class);
        startActivity(intent);
    }
}