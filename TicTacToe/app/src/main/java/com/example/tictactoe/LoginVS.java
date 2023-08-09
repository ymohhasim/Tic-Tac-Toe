package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginVS extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    TextView name;
    public static final String mypreference = "mypref";
    public static final String Name = "nameKey";
    private EditText player1;
    private EditText player2;
    private TextView getscore1;
    private TextView getscore2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginvs);
        name = (TextView) findViewById(R.id.player1Name);
        player1 = findViewById(R.id.player1Name);
        player2 = findViewById(R.id.player2Name);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
    }
    public void Save(View view) {
        String n = name.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Name, n);
        editor.commit();
    }
    public void Get(View view) {
        name = (TextView) findViewById(R.id.player1Name);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
    }

    public void clear(View view) {
        name = (TextView) findViewById(R.id.player1Name);
        name.setText("");
    }

    public void launchGame(View view) {
        String player1Name = player1.getText().toString();
        String player2Name = player2.getText().toString();
        Intent intent = new Intent(this, gameboard.class);
        intent.putExtra("Player Names",new String[] {player1Name,player2Name});
        startActivity(intent);

    }

}