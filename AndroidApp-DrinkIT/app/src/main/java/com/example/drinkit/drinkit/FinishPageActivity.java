package com.example.drinkit.drinkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import Controller.Controller;

public class FinishPageActivity extends AppCompatActivity {

    Controller ctrl = new Controller();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_page);

        printScoreBoard();
    }



    public void printScoreBoard(){
        TextView text=((TextView)findViewById(R.id.printScoreBoard));
        text.setText(ctrl.putInPointOrder());
    }

    public void continueTheGame(View view) {


    }


    public void endTheGameButton(View view) {
        ctrl.endTheGame();
        startActivity(new Intent(FinishPageActivity.this, StartPageActivity.class));


    }


}
