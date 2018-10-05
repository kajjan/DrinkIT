package com.example.drinkit.drinkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import Controller.Controller;

public class ChallengeActivity extends AppCompatActivity {


    Controller ctrl = new Controller();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);
        ctrl.setCompleteListOfPlayers();

        printPlayersName();
    }

    //print the name of the player on the challenge card
    public void printPlayersName(){
        TextView text=((TextView)findViewById(R.id.playerOfchallenge));
        text.setText(ctrl.getPlayersName());
    }


    public void failChallenge(View view) {
        ctrl.failedChallenge();
        if(nextRound()) {
            printPlayersName();
        }
        else{
            changePage(view);
        }
    }

    public void succeedChallenge(View view) {
        ctrl.succeedChallenge();
        if(nextRound()) {
            printPlayersName();
        }
        else{
            changePage(view);
        }
    }


    public void changePage(View view) {
        startActivity(new Intent(ChallengeActivity.this, FinishPageActivity.class));
    }

    public boolean nextRound(){
        return ctrl.nextRound();
        }
}
