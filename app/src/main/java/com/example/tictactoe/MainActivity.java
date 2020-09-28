package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    // 0 for yellow and 1 for red
    int ActivePlayer = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2};


    public void drop(View view){
        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if (gameState[tappedCounter] == 2) {
            gameState[tappedCounter] = ActivePlayer;
            counter.setTranslationY(-1000f);
            if (ActivePlayer == 0) {
                counter.setImageResource(R.drawable.yellowbtn1);
                ActivePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.redbtn);
                ActivePlayer = 0;
            }

            counter.animate().translationYBy(1000f).setDuration(300);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}