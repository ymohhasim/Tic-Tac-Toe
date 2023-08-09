package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class gameboard extends AppCompatActivity {

    private TicTacToeBoard ticTacToeBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameboard);

        Button playAgainbttn = findViewById(R.id.playagainbttn);
        Button homebttn = findViewById(R.id.Homebttn);
        TextView playerTurn = findViewById(R.id.player_display);
        TextView playerNames1 = findViewById(R.id.player1Name);
        TextView playerNames2 = findViewById(R.id.player2name);
        TextView scorecounter1 = findViewById(R.id.scorecounter1);
        TextView scorecounter2 = findViewById(R.id.scorecounter2);

        playAgainbttn.setVisibility(View.GONE);
        homebttn.setVisibility(View.GONE);
        String[] playerNames = getIntent().getStringArrayExtra("Player Names");

        if (playerNames != null) {
            playerTurn.setText(playerNames[0] + "'s Turn");
        }
        playerNames1.setText(playerNames[0]);
        playerNames2.setText(playerNames[1]);

        ticTacToeBoard = findViewById(R.id.ticTacToeBoard);
        ticTacToeBoard.setUpGame(playAgainbttn,homebttn,playerTurn,playerNames);

    }
    public void clickHomeButton(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
    public void clickPlayAgain(View view) {
        ticTacToeBoard.resetGame();
        ticTacToeBoard.invalidate();
    }
}