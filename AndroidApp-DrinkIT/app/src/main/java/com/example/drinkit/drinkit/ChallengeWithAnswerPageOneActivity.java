package com.example.drinkit.drinkit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ChallengeWithAnswerPageOneActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_with_answer);
        getCtrl().createCompleteListOfPlayers();

        printPlayersName();
        printChallenge();
    }

    public void printPlayersName(){
        TextView text=((TextView)findViewById(R.id.playerOfchallenge));
        text.setText(getCtrl().getPlayersName());
    }

    public void printChallenge(){
        TextView text=((TextView)findViewById(R.id.challengeText));
        text.setText(getCtrl().getActiveChallenge());
    }


    public void toAnswerPage(View view) {
        toAnswerPageActivity();

    }

    public void challengeInstructionPage(View view) {
        startActivity(new Intent(ChallengeWithAnswerPageOneActivity.this, ChallengeInstructionActivity.class));
    }

    public boolean nextRound(){
        return getCtrl().nextRound();
    }


    public void changePage(View view) {
        startActivity(new Intent(ChallengeWithAnswerPageOneActivity.this, FinishPageActivity.class));
    }

    public void toAnswerPageActivity(){
        startActivity(new Intent(ChallengeWithAnswerPageOneActivity.this, ChallengeWithAnswerPageTwoActivity.class));

    }

}
