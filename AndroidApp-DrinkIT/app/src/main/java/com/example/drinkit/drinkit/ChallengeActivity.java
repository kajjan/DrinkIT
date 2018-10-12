package com.example.drinkit.drinkit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class ChallengeActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);
        getCtrl().createCompleteListOfPlayers();

        printPlayersName();
        printChallenge();
    }

    //print the name of the player on the challenge card
    public void printPlayersName(){
        TextView text=((TextView)findViewById(R.id.playerOfchallenge));
        text.setText(getCtrl().getPlayersName());
    }

    public void printChallenge(){
        TextView text=((TextView)findViewById(R.id.challengeText));
        text.setText(getCtrl().getActiveChallenge());
    }


    public void failChallenge(View view) {
        getCtrl().failedChallenge();
        if(nextRound()) {
            printPlayersName();
            printChallenge();
        }
        else{
            changePage(view);
        }
    }

    public void succeededChallenge(View view) {
        getCtrl().succeededChallenge();
        if(nextRound()) {
            printPlayersName();
            printChallenge();
        }
        else{
            changePage(view);
        }
    }


    public void changePage(View view) {
        startActivity(new Intent(ChallengeActivity.this, FinishPageActivity.class));
    }

    public boolean nextRound(){
        return getCtrl().nextRound();
        }

    public void challengeInstructionPage(View view) {
        startActivity(new Intent(ChallengeActivity.this, ChallengeInstructionActivity.class));
    }
}
