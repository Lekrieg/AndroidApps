package com.lekrieg.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

	private TextInputEditText textInputEditTextTip;
	private TextView textViewPercentage, textViewTip, textViewTotal;
	private SeekBar seekBarTipPercentage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		connectViews();

		seekBarTipPercentage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
				textViewPercentage.setText(i + "%");
				calculateTip(i);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}
		});
	}

	private void connectViews()
	{
		textInputEditTextTip = findViewById(R.id.textInputEditTextTip);
		textViewPercentage = findViewById(R.id.textViewPercentage);
		textViewTip = findViewById(R.id.textViewTip);
		textViewTotal = findViewById(R.id.textViewTotal);

		seekBarTipPercentage = findViewById(R.id.seekBarTipPercentage);
	}

	private void calculateTip(int percentageTip)
	{
		String valueReceived = textInputEditTextTip.getText().toString();

		boolean isValid = !validInput(valueReceived);

		if(isValid)
		{
			double payment =  Double.parseDouble(valueReceived);
			double tip = payment * ((double)percentageTip / 100);
			double totalBill = payment + tip;

			// Modificar depois para uma funcao separada
			textViewTip.setText("R$ " + tip);
			textViewTotal.setText("R$ " + totalBill);
		}
		else
		{
			Toast.makeText(getApplicationContext(), "Digite um valor!", Toast.LENGTH_SHORT).show();
		}
	}

	private boolean validInput(String valueReceived)
	{
		return (valueReceived == null || valueReceived.equals(""));
	}
}
