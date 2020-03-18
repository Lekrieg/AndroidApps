package com.lekrieg.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AndroidException;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText number1TextInputEditText;
    private TextInputEditText number2TextInputEditText;

    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonMult;
    private Button buttonDiv;

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1TextInputEditText = findViewById(R.id.number1TextInputEditText);
        number2TextInputEditText = findViewById(R.id.number2TextInputEditText);

        textViewResult = findViewById(R.id.textViewResult);

        buttonPlus = findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {
                sum(view);
            }
        });

        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {
                subtraction(view);
            }
        });

        buttonMult = findViewById(R.id.buttonMult);
        buttonMult.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {
                multiplication(view);
            }
        });

        buttonDiv = findViewById(R.id.buttonDiv);
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {
                division(view);
            }
        });
    }

    private void sum(View view)
    {
        String number1 = number1TextInputEditText.getText().toString();
        String number2 = number2TextInputEditText.getText().toString();

        boolean isValid = CheckFields(number1, number2);

        if(isValid)
        {
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);

            textViewResult.setText("" + (num1 + num2));
        }
    }
    private void subtraction(View view)
    {
        String number1 = number1TextInputEditText.getText().toString();
        String number2 = number2TextInputEditText.getText().toString();

        boolean isValid = CheckFields(number1, number2);

        if(isValid)
        {
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);

            textViewResult.setText("" + (num1 - num2));
        }
    }
    private void division(View view)
    {
        String number1 = number1TextInputEditText.getText().toString();
        String number2 = number2TextInputEditText.getText().toString();

        boolean isValid = CheckFields(number1, number2);

        if(isValid)
        {
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);

            textViewResult.setText("" + (num1 / num2));
        }
    }
    private void multiplication(View view)
    {
        String number1 = number1TextInputEditText.getText().toString();
        String number2 = number2TextInputEditText.getText().toString();

        boolean isValid = CheckFields(number1, number2);

        if(isValid)
        {
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);

            textViewResult.setText("" + (num1 * num2));
        }
    }

    private boolean CheckFields(String num1, String num2)
    {
        boolean isValid = ((num1 != null || !num1.equals("")) && (num2 != null || !num2.equals("")));

        return isValid;
    }
}
