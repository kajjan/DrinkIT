package com.TDA367.drinkit.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class ChallengeWithoutPointActivity extends MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_without_point);
        getCtrl().getCompleteListOfPlayersNames();

        printPlayersName();

        printChallenge();
    }


    public void printPlayersName(){
        TextView text=((TextView)findViewById(R.id.textViewPlayerChallengeWithoutPoint));
        text.setText(getCtrl().getPlayersName());
    }

    public void printChallenge(){
        TextView text=((TextView)findViewById(R.id.textViewChallengeWithoutPoint));
        text.setText(getCtrl().getActiveChallenge());
    }


    public void nextButtonWithoutPoint(View view) {
        getCtrl().failedChallenge();
        if(nextRound()) {
            String nextCategory = getCtrl().getNextCategory();
            startNextActivity(nextCategory);
        }
        else{
            changePage(view);
            //String nextCategory = getCtrl().getNextCategory();
            //startNextActivity(nextCategory);
        }
    }

    public boolean nextRound(){
        return getCtrl().nextRound();
    }

    public void changePage(View view) {
        startActivity(new Intent(ChallengeWithoutPointActivity.this, FinishPageActivity.class));
    }

    public void challengeInstructionPage(View view) {
        startActivity(new Intent(ChallengeWithoutPointActivity.this, ChallengeInstructionActivity.class));
    }

    public void optionsDuringGamePage(View view) {
        startActivity(new Intent(ChallengeWithoutPointActivity.this, OptionsDuringGameActivity.class));
    }

    public void startNextActivity(String category){
        if (category.equals("quiz") || category.equals("songs") || category.equals("charades") ){
            //Dubbelvy med poäng
            startActivity(new Intent(ChallengeWithoutPointActivity.this, ChallengeWithAnswerPageOneActivity.class));
        }
        else if(category.equals("truthOrDare")){
            //Enkelvy med poäng
            startActivity(new Intent(ChallengeWithoutPointActivity.this, ChallengeWithPointActivity.class));
        }
        else if(category.equals("mostLikelyTo") || category.equals("rules")  || category.equals("neverHaveIEver") || category.equals("themes") || category.equals("thisOrThat") )
            //en vy utan poäng (ingen spelar)
            startActivity(new Intent(ChallengeWithoutPointActivity.this, ChallengeWithoutPointActivity .class));
        else{
            System.out.println("Something is wrong with the code in DurationActivity...");
        }

    }

}


