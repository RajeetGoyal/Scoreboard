package com.example.rajeetgoyal.scoreboard;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private int scoreAR1=0, scoreAR2=0, scoreAR3=0, resultAR1=0, resultAR2=0, resultAR3=0;
    private int scoreBR1=0, scoreBR2=0, scoreBR3=0, resultBR1=0, resultBR2=0, resultBR3=0;
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle(getResources().getString(R.string.activity_name));

        final RadioButton round1RadioButton = findViewById(R.id.round_one_radio_button);
        final RadioButton round2RadioButton = findViewById(R.id.round_two_radio_button);
        final RadioButton round3RadioButton = findViewById(R.id.round_three_radio_button);
        final TextView textView = findViewById(R.id.game_result);

        /*
        * The code automatically determine round win by following below standard rules:
        * 1) The player to score 21 points first will be the winner.
        * 2) But in case the score reaches  at 20-20 then the player who take a two point lead will be the winner.
        * But again if the score reaches 29-29 then the player who score the 30th point will be final winner.
        * */

        /*
         * This method is called when the player A score button is clicked.
         * */
        Button buttonA = findViewById(R.id.player_a_button);
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(round1RadioButton.isChecked()){
                    if (resultAR1 != 1 && resultBR1 != 1) scoreAR1 = scoreAR1 + 1;
                    if (scoreAR1 == 21 && scoreBR1 < 20) resultAR1 = 1;
                    if (scoreAR1 >= 20 && scoreBR1 >= 20 && scoreAR1-scoreBR1==2) resultAR1=1;
                    if (scoreAR1 == 30) resultAR1 = 1;
                    if (resultAR1 == 1) {
                        if(mToast != null)
                            mToast.cancel();
                        mToast = Toast.makeText(MainActivity.this,"Congratulations A! You win Round1", Toast.LENGTH_SHORT);
                        mToast.show();
                    }
                    displayScoreAR1(scoreAR1);
                    displayScoreAT(resultAR1);
                }

                if(round2RadioButton.isChecked()){
                    if (resultAR2 != 1 && resultBR2 != 1) scoreAR2 = scoreAR2 + 1;
                    if (scoreAR2 == 21 && scoreBR2 < 20) resultAR2 = 1;
                    if (scoreAR2 >= 20 && scoreBR2 >= 20 && scoreAR2-scoreBR2==2) resultAR2=1;
                    if (scoreAR2 == 30) resultAR2 = 1;
                    if (resultAR1 == 0 && resultAR2 == 1) {
                        if(mToast != null)
                            mToast.cancel();
                        mToast = Toast.makeText(MainActivity.this,"Congratulations A! You win Round2", Toast.LENGTH_SHORT);
                        mToast.show();
                    }
                    if (resultAR1 == 1 && resultAR2 == 1) {
                        textView.setText(R.string.win_statement_A);
                    }
                    displayScoreAR2(scoreAR2);
                    displayScoreAT(resultAR1 + resultAR2);
                }

                if(round3RadioButton.isChecked()){
                    if (resultAR3 != 1 && resultBR3 != 1 && resultAR1 + resultAR2 != 2 && resultBR1 + resultBR2 != 2) scoreAR3 = scoreAR3 + 1;
                    if (scoreAR3 == 21 && scoreBR3 < 20) resultAR3 = 1;
                    if (scoreAR3 >= 20 && scoreBR3 >= 20 && scoreAR3-scoreBR3==2) resultAR3=1;
                    if (scoreAR3 == 30) resultAR3 = 1;
                    if (resultAR3 == 1) {
                        textView.setText(R.string.win_statement_A);
                    }
                    displayScoreAR3(scoreAR3);
                    displayScoreAT(resultAR1 + resultAR2 + resultAR3);
                }
            }
        });

        /*
        * This method is called when the player B score button is clicked.
        * */
        Button buttonB = findViewById(R.id.player_b_button);
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(round1RadioButton.isChecked()){
                    if (resultAR1 != 1 && resultBR1 != 1) scoreBR1 = scoreBR1 + 1;
                    if (scoreBR1 == 21 && scoreAR1 < 20) resultBR1 = 1;
                    if (scoreBR1 >= 20 && scoreBR1 != 29 && scoreAR1 >= 20 && scoreBR1-scoreAR1==2) resultBR1=1;
                    if (scoreBR1 == 30) resultBR1 = 1;
                    if (resultBR1 == 1) {
                        if(mToast != null)
                            mToast.cancel();
                        mToast = Toast.makeText(MainActivity.this,"Congratulations B! You win Round1", Toast.LENGTH_SHORT);
                        mToast.show();
                    }
                    displayScoreBR1(scoreBR1);
                    displayScoreBT(resultBR1);
                }

                if(round2RadioButton.isChecked()){
                    if (resultAR2 != 1 && resultBR2 != 1) scoreBR2 = scoreBR2 + 1;
                    if (scoreBR2 == 21 && scoreAR2 < 20) resultBR2 = 1;
                    if (scoreBR2 >= 20 && scoreBR2 != 29 && scoreAR2 >= 20 && scoreBR2-scoreAR2==2) resultBR2=1;
                    if (scoreBR2 == 30) resultBR2 = 1;
                    if (resultBR1 == 0 && resultBR2 == 1) {
                        if(mToast != null)
                            mToast.cancel();
                        mToast = Toast.makeText(MainActivity.this,"Congratulations B! You win Round2", Toast.LENGTH_SHORT);
                        mToast.show();
                    }
                    if (resultBR1 == 1 && resultBR2 == 1) {
                        textView.setText(R.string.win_statement_B);
                    }
                    displayScoreBR2(scoreBR2);
                    displayScoreBT(resultBR1 + resultBR2);
                }

                if(round3RadioButton.isChecked()){
                    if (resultAR3 != 1 && resultBR3 != 1 && resultAR1 + resultAR2 != 2 && resultBR1 + resultBR2 != 2) scoreBR3 = scoreBR3 + 1;
                    if (scoreBR3 == 21 && scoreAR3 < 20) resultBR3 = 1;
                    if (scoreBR3 >= 20 && scoreBR3 != 29 && scoreAR3 >= 20 && scoreBR3-scoreAR3==2) resultBR3=1;
                    if (scoreBR3 == 30) resultBR3 = 1;
                    if (resultBR3 == 1) {
                        textView.setText(R.string.win_statement_B);
                    }
                    displayScoreBR3(scoreBR3);
                    displayScoreBT(resultBR1 + resultBR2 + resultBR3);
                }
            }
        });

        /*
         * The method is called when the reset button is clicked.
         */
        Button reset = findViewById(R.id.reset_button);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultAR1=0;
                resultAR2=0;
                resultAR3=0;
                resultBR1=0;
                resultBR2=0;
                resultBR3=0;
                displayScoreAR1(scoreAR1=0);
                displayScoreAR2(scoreAR2=0);
                displayScoreAR3(scoreAR3=0);
                displayScoreBR1(scoreBR1=0);
                displayScoreBR2(scoreBR2=0);
                displayScoreBR3(scoreBR3=0);
                displayScoreAT(0);
                displayScoreBT(0);
                TextView textView = findViewById(R.id.game_result);
                textView.setText(" ");
                round1RadioButton.setChecked(false);
                round2RadioButton.setChecked(false);
                round3RadioButton.setChecked(false);
            }
        });
    }

    /*
     * Displays the score gained by player A in round 1.
     */
    private void displayScoreAR1(int anyName) {
        // Find the TextView in the list_item.xml layout with the ID score_a_round_one
        TextView scoreAR1 = findViewById(R.id.score_a_round_one);
        scoreAR1.setText(String.valueOf(anyName));
    }

    /*
     * Displays the score gained by player A in round 2.
     */
    private void displayScoreAR2(int anyName) {
        TextView scoreAR2 = findViewById(R.id.score_a_round_two);
        scoreAR2.setText(String.valueOf(anyName));
    }

    /*
     * Displays the score gained by player A in round 3.
     */
    private void displayScoreAR3(int anyName) {
        TextView scoreAR3 = findViewById(R.id.score_a_round_three);
        scoreAR3.setText(String.valueOf(anyName));
    }

    /*
     * Displays the round wins of player A.
     */
    private void displayScoreAT(int anyName) {
        TextView scoreAT = findViewById(R.id.total_score_a);
        scoreAT.setText(String.valueOf(anyName));
    }

    /*
     * Displays the score gained by player B in round 1.
     */
    private void displayScoreBR1(int anyName) {
        TextView scoreBR1 = findViewById(R.id.score_b_round_one);
        scoreBR1.setText(String.valueOf(anyName));
    }

    /*
     * Displays the score gained by player B in round 2.
     */
    private void displayScoreBR2(int anyName) {
        TextView scoreBR2 = findViewById(R.id.score_b_round_two);
        scoreBR2.setText(String.valueOf(anyName));
    }

    /*
     * Displays the score gained by player B in round 3.
     */
    private void displayScoreBR3(int anyName) {
        TextView scoreBR3 = findViewById(R.id.score_b_round_three);
        scoreBR3.setText(String.valueOf(anyName));
    }

    /*
     * Displays the round wins of player B.
     */
    private void displayScoreBT(int anyName) {
        TextView scoreBT = findViewById(R.id.total_score_b);
        scoreBT.setText(String.valueOf(anyName));
    }
}