package com.lekrieg.alertdialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText textInputEditTextName;
    private TextInputEditText textInputEditTextSurname;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputEditTextName = findViewById(R.id.textInputEditTextName);
        textInputEditTextSurname = findViewById(R.id.textInputEditTextSurname);

        textViewResult = findViewById(R.id.textViewResult);


    }

    public void sendInfo(View view)
    {
        String name = textInputEditTextName.getText().toString();
        String surname = textInputEditTextSurname.getText().toString();

        boolean validStrings = isValid(name, surname);

        if(validStrings)
        {
            textViewResult.setText("Nome: " + name + " Sobrenome: " + surname);
        }
    }
    public void resetInfo(View view)
    {
        // Instancia um AlertDialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        // Configurar titulo e mensagem
        dialog.setTitle("Resetar");
        dialog.setMessage("Deseja remover os dados?");

        dialog.setCancelable(false);

        // Configura acoes para sim e nao
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                textInputEditTextName.setText("");
                textInputEditTextSurname.setText("");

                textViewResult.setText("");

                Toast.makeText(getApplicationContext(), "Dados removidos!", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setNegativeButton("Nao", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        // Cria e exibe AlertDialog
        dialog.create();
        dialog.show();

    }

    private boolean isValid(String name, String surname) {
        return (name != null || name.equals("")) && (surname != null || surname.equals(""));
    }
}
