package com.example.timewise;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtNome;
    private EditText txtSenha;
    private Button buttonLogin;
    private Button buttonAdm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);

        // INTERACAO COM XML
        txtNome = findViewById(R.id.txtNome);
        txtSenha = findViewById(R.id.txtSenha);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonAdm = findViewById(R.id.buttonAdm);


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarLogin(); // CHAMANDO O METODO DE VALIDACAO
            }
        });
     }
    private void validarLogin(){
        Dados user1 = new Dados("tiago","tiago"); //DEFINICAO DOS VALORES

        String username = txtNome.getText().toString();
        String password = txtSenha.getText().toString();

        if(username.equals(user1.nome) && password.equals(user1.getSenha())){
            Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
            startActivity(intent); //VALIDACAO PARA SEGUNDA TELA
        }else{

            exibirMensagem("Nome do usuario ou senha incorretos!");
        }
    }
    private void exibirMensagem(String mensagem){
        Toast.makeText(getApplicationContext(),mensagem, Toast.LENGTH_SHORT).show();
    }

    public  void abrirAdm(View v){
        Intent intent = new Intent(getApplicationContext(),MainActivityAdm.class);
        startActivity(intent);
    }

    public void esqueciSenha(View v){
        Intent intent = new Intent(getApplicationContext(),EsqueciSenha.class);
        startActivity(intent);
    }
}