package com.TDA367.drinkit.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class ChallengeWithPointActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_with_point);
        getCtrl().getCompleteListOfPlayersNames();

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
            String nextCategory = getCtrl().getNextCategory();
            startNextActivity(nextCategory);
        }
        else{
            toFinishPage(view);
        }

    }

    public void succeededChallenge(View view) {
        getCtrl().succeededChallenge();
        if(nextRound()) {
            String nextCategory = getCtrl().getNextCategory();
            startNextActivity(nextCategory);
        }
        else{
            toFinishPage(view);
        }

    }


    public void toFinishPage(View view) {
        startActivity(new Intent(ChallengeWithPointActivity.this, FinishPageActivity.class));
    }

    public boolean nextRound(){
        return getCtrl().nextRound();
        }

    public void challengeInstructionPage(View view) {
        startActivity(new Intent(ChallengeWithPointActivity.this, ChallengeInstructionActivity.class));
    }

    public void startNextActivity(String category){
        if (category.equals("quiz") || category.equals("songs") || category.equals("charades") ){
            //Dubbelvy med poäng
            startActivity(new Intent(ChallengeWithPointActivity.this, ChallengeWithAnswerPageOneActivity.class));
        }
        else if(category.equals("truthOrDare")){
            //Enkelvy med poäng
            startActivity(new Intent(ChallengeWithPointActivity.this, TruthOrDarePageActivity.class));
        }
        else if(category.equals("mostLikelyTo") || category.equals("rules")  || category.equals("neverHaveIEver") || category.equals("themes") || category.equals("thisOrThat") )
            //en vy utan poäng (ingen spelar)
            startActivity(new Intent(ChallengeWithPointActivity.this, ChallengeWithoutPointActivity .class));
        else{
            System.out.println("Something is wrong with the code in DurationActivity...");
        }

    }
}
