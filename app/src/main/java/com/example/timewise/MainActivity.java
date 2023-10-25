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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // INTERACAO COM XML
        txtNome = findViewById(R.id.txtNome);
        txtSenha = findViewById(R.id.txtSenha);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarLogin(); // CHAMANDO O METODO DE VALIDACAO
            }
        });


     }
    private void validarLogin(){
        Dados user1 = new Dados("t","t1"); //DEFINICAO DOS VALORES

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

}