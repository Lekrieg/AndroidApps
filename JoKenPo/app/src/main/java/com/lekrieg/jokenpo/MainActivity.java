package com.lekrieg.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void paper(android.view.View view){
        this.selectEnemyType("paper");
    }

    public void rock(android.view.View view){
        this.selectEnemyType("rock");
    }

    public void scissor(android.view.View view){
        this.selectEnemyType("scissor");
    }

    public void selectEnemyType(String userChoice){
        ImageView resultImage = findViewById(R.id.imageViewResult);
        TextView resultText = findViewById(R.id.textViewResult);

        String[] computerChoices = { "paper", "rock", "scissor" };
        int choice = new Random().nextInt(3);
        String computerChoice = computerChoices[choice];

        switch (computerChoice){
            case "paper":
                resultImage.setImageResource(R.drawable.papel);
                break;
            case "rock":
                resultImage.setImageResource(R.drawable.pedra);
                break;
            case "scissor":
                resultImage.setImageResource(R.drawable.tesoura);
                break;
        }

        if((computerChoice == "rock" && userChoice == "scissor") || (computerChoice == "paper" && userChoice == "rock") || (computerChoice == "scissor" && userChoice == "paper"))
        {
            resultText.setText("Computador ganhou!");
        }
        else if((userChoice == "rock" && computerChoice == "scissor") || (userChoice == "paper" && computerChoice == "rock") || (userChoice == "scissor" && computerChoice == "paper"))
        {
            resultText.setText("Você ganhou!");
        }
        else
        {
            resultText.setText("Empate!");
        }
    }

}
