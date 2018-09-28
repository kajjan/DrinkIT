package com.example.drinkit.drinkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
    }

    public void startGame(View view) {
        startActivity(new Intent(StartPageActivity.this, AddPlayerActivity.class));

    }

    public void instructions(View view) {
        startActivity(new Intent(StartPageActivity.this, InstructionsActivity.class));
    }
}
