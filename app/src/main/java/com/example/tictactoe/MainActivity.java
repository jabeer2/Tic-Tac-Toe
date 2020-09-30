package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 0 for yellow and 1 for red
    int ActivePlayer = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] Winners = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};


    public void drop(View view) {
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
            for (int[] winner : Winners) {
                if (gameState[winner[0]] == gameState[winner[1]] &&
                        gameState[winner[1]] == gameState[winner[2]] &&
                        gameState[winner[0]] != 2) {
                    String win = "Red";
                    if (gameState[winner[0]] == 0) {
                        win = "Yellow";
                    }
                    System.out.println("0" + gameState[winner[0]]);
                    System.out.println("1" +gameState[winner[1]]);
                    TextView winnerMsg = (TextView) findViewById(R.id.winnerMsg);
                    winnerMsg.setText(win + " has won");
                    LinearLayout playAgainLay = (LinearLayout) findViewById(R.id.plyAgainlay);
                    playAgainLay.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}