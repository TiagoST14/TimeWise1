package com.example.timewise;

import static com.example.timewise.ValidadadorTelefone.isTelValid;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Patterns;
import java.util.regex.Pattern;
import android.widget.Toast;
import java.util.regex.Matcher;
public class TelaCadastrarFuncionario extends AppCompatActivity {

    private static final Pattern PHONE_PATTERN = Pattern.compile(
            "(\\+[0-9]+[\\- \\.]*)?"
                    + "(\\([0-9]+\\)[\\- \\.]*)?"
                    + "([0-9][0-9\\- \\.]+[0-9])");
    private EditText editTextCpf;
    private Button buttonCadastrar;
    private EditText editTextRg;
    private EditText editTextEmail;
    private EditText editTextTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastrar_funcionario);

        editTextCpf = findViewById(R.id.editTextCpf);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);
        editTextRg = findViewById(R.id.editTextRg);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextTelefone = findViewById(R.id.editTextTelefone);
        setupCpfEditText();
        setupRgEditText();
        setupEmailEditText();

        editTextTelefone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String telefone = editTextTelefone.getText().toString();
                String cpf = editTextCpf.getText().toString().replaceAll("[^\\d]", "");
                String rg = editTextRg.getText().toString().replaceAll("[^\\d]", "");
                String email = editTextEmail.getText().toString().trim();

                boolean isTelValid = isTelValid(telefone);
                boolean isCpfValid = ValidadorCPF.isValidCPF(cpf);
                boolean isRgValid = ValidadorRg.isValidRG(rg);
                boolean isEmailValid = isValidEmail(email);



                if (isCpfValid) {
                    editTextCpf.setError(null);
                    editTextCpf.setText("CPF Válido");
                } else {
                    editTextCpf.setError("CPF Inválido");
                }

                if (isRgValid) {
                    editTextRg.setError(null);
                    editTextRg.setText("RG Válido");
                } else {
                    editTextRg.setError("RG Inválido");
                }
                if (isEmailValid) {
                    editTextEmail.setError(null);
                    editTextEmail.setText("");
                } else {
                    editTextEmail.setError("E-mail Inválido");
                }
                if (isTelValid(telefone)){
                    editTextEmail.setError(null);
                    editTextEmail.setText("Telefone Válido");
                }else{
                    editTextEmail.setError("Telefone Inválido");
                }
            }
        });
    }


    private void setupCpfEditText() {
        editTextCpf.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                editTextCpf.removeTextChangedListener(this);

                String cpf = editable.toString().replaceAll("[^\\d]", "");

                if (cpf.length() > 11) {
                    cpf = cpf.substring(0, 11);
                }

                StringBuilder formattedCpf = new StringBuilder();

                for (int i = 0; i < cpf.length(); i++) {
                    formattedCpf.append(cpf.charAt(i));

                    if (i == 2 || i == 5) {
                        if (i != cpf.length() - 1) {
                            formattedCpf.append(".");
                        }
                    } else if (i == 8) {
                        if (i != cpf.length() - 1) {
                            formattedCpf.append("-");
                        }
                    }
                }

                editTextCpf.setText(formattedCpf.toString());
                editTextCpf.setSelection(formattedCpf.length());
                editTextCpf.addTextChangedListener(this);
            }
        });

        editTextCpf.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    if (TextUtils.isEmpty(editTextCpf.getText()) || editTextCpf.getText().toString().equals("CPF Válido")) {
                        editTextCpf.getText().clear();
                        editTextCpf.setError(null);
                    }
                }
            }
        });
    }

    private void setupRgEditText() {
        editTextRg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                editTextRg.removeTextChangedListener(this);

                String rg = editable.toString().replaceAll("[^\\d]", "");

                if (rg.length() > 9) {
                    rg = rg.substring(0, 9);
                }

                StringBuilder formattedRg = new StringBuilder();

                for (int i = 0; i < rg.length(); i++) {
                    formattedRg.append(rg.charAt(i));

                    if (i == 1 || i == 4) {
                        if (i != rg.length() - 1) {
                            formattedRg.append(".");
                        }
                    } else if (i == 9) {
                        if (i != rg.length() - 1) {
                            formattedRg.append("-");
                        }
                    }
                }

                editTextRg.setText(formattedRg.toString());
                editTextRg.setSelection(formattedRg.length());
                editTextRg.addTextChangedListener(this);
            }
        });

        editTextRg.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    if (TextUtils.isEmpty(editTextRg.getText()) || editTextRg.getText().toString().equals("RG Válido")) {
                        editTextRg.getText().clear();
                        editTextRg.setError(null);
                    }
                }
            }
        });
    }
    private void setupEmailEditText() {
        editTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                editTextEmail.removeTextChangedListener(this);

                String email = editable.toString().trim();

                editTextEmail.setText(email);
                editTextEmail.setSelection(email.length());
                editTextEmail.addTextChangedListener(this);
            }
        });

        editTextEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    if (TextUtils.isEmpty(editTextEmail.getText()) || editTextEmail.getText().toString().equals("E-mail Válido")) {
                        editTextEmail.getText().clear();
                        editTextEmail.setError(null);
                    }
                }
            }
        });
    }
    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    private boolean isValidRG(String rg) {
        return rg.length() >= 8;
    }

    public void voltar(View view){
        Intent intent = new Intent(getApplicationContext(), MenuAdm.class);
        startActivity(intent);
    }


}