package com.example.drinkit.drinkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InstructionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
    }

    public void exitInstrucktions(View view) {
        //just nu bara tillbaka till startsidan, kanske borde vara tillbaka till föregående sida?
            startActivity(new Intent(InstructionsActivity.this, StartPageActivity.class));
    }
}
